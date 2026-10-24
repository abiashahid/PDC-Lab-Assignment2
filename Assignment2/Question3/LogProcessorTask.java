package Assignment2.Question3;

public class LogProcessorTask implements Runnable {
    private final int iterations = 5;
    private final long sleepDurationMs = 1000;

    @Override
    public void run() {
        for (int i = 1; i <= iterations; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] Log Metric Iteration: " + i + "/5");
            try {
                Thread.sleep(sleepDurationMs);
            } catch (InterruptedException e) {
                System.err.println("[" + Thread.currentThread().getName() + "] Interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}