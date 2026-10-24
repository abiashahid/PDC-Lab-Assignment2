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
}