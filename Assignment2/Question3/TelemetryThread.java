package Assignment2.Question3;

public class TelemetryThread extends Thread {
    private final int iterations = 5;
    private final long sleepDurationMs = 800;

    public TelemetryThread() {
        super();
    }

    public TelemetryThread(String name) {
        super(name);
    }

    private String getSystemHealthMetrics(int step) {
        int cpuUsage = 20 + (step * 7);
        int memoryUsage = 40 + (step * 5);
        return "CPU Usage: " + cpuUsage + "% | Memory Usage: " + memoryUsage + "%";
    }

    @Override
    public void run() {
        for (int i = 1; i <= iterations; i++) {
            System.out.println("[" + getName() + "] Health Update #" + i + ": " + getSystemHealthMetrics(i));
            try {
                Thread.sleep(sleepDurationMs);
            } catch (InterruptedException e) {
                System.err.println("[" + getName() + "] Telemetry thread interrupted: " + e.getMessage());
                interrupt();
            }
        }
    }
}