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
            telemetryData[i] = -10.0 + (random.nextDouble() * 120.0); // Ambient temp / vibration values
        }

        System.out.println("Initialized " + DATA_SIZE + " sensor telemetry data elements.");
        System.out.println("Grid partitioned across " + THREAD_COUNT + " parallel worker threads.");
    }
}