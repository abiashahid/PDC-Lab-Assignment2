package Assignment2.Question5;

import java.util.Random;

public class SensorGridMonitorApp {
    private static final int DATA_SIZE = 50000;
    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("=== IoT Sensor Grid Realtime Monitoring Engine ===");
        
        double[] telemetryData = new double[DATA_SIZE];
        Random random = new Random(101);
        for (int i = 0; i < DATA_SIZE; i++) {
            telemetryData[i] = -10.0 + (random.nextDouble() * 120.0);
        }

        System.out.println("Initialized " + DATA_SIZE + " sensor telemetry data elements.");
        System.out.println("Grid partitioned across " + THREAD_COUNT + " parallel worker threads.");

        ParallelMinSearch[] minTasks = new ParallelMinSearch[THREAD_COUNT];
        ParallelMaxSearch[] maxTasks = new ParallelMaxSearch[THREAD_COUNT];
        Thread[] minThreads = new Thread[THREAD_COUNT];
        Thread[] maxThreads = new Thread[THREAD_COUNT];

        int segmentSize = DATA_SIZE / THREAD_COUNT;

        long startTime = System.nanoTime();

        // Launching parallel min and max reductions across 4 partitioned segments
        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * segmentSize;
            int end = (i == THREAD_COUNT - 1) ? DATA_SIZE : (i + 1) * segmentSize;

            minTasks[i] = new ParallelMinSearch(telemetryData, start, end);
            maxTasks[i] = new ParallelMaxSearch(telemetryData, start, end);

            final int taskIdx = i;
            minThreads[i] = new Thread(() -> minTasks[taskIdx].processGrid(), "MinWorker-" + i);
            maxThreads[i] = new Thread(() -> maxTasks[taskIdx].processGrid(), "MaxWorker-" + i);

            minThreads[i].start();
            maxThreads[i].start();
        }

        // Wait for all worker threads to finish
        try {
            for (int i = 0; i < THREAD_COUNT; i++) {
                minThreads[i].join();
                maxThreads[i].join();
            }
        } catch (InterruptedException e) {
            System.err.println("Thread execution interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}