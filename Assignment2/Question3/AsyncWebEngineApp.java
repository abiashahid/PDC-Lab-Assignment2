package Assignment2.Question3;

public class AsyncWebEngineApp {
    public static void main(String[] args) {
        System.out.println("=== Async Web Engine Initializing ===");
        System.out.println("Default JVM Main Thread Name: " + Thread.currentThread().getName());
        System.out.println("-------------------------------------");

        // Instantiating TelemetryThread with custom name
        TelemetryThread telemetryThread = new TelemetryThread("Telemetry-Worker");

        // Instantiating LogProcessorTask and wrapping in Thread with custom name
        LogProcessorTask logTask = new LogProcessorTask();
        Thread logThread = new Thread(logTask, "Log-Worker");

        // Pre-start state logging
        System.out.println("[PRE-START] " + telemetryThread.getName() + " State: " + telemetryThread.getState() + " | Is Alive: " + telemetryThread.isAlive());
        System.out.println("[PRE-START] " + logThread.getName() + " State: " + logThread.getState() + " | Is Alive: " + logThread.isAlive());

        // Simultaneous execution launch
        System.out.println("\n--- Launching Concurrent Operations ---");
        telemetryThread.start();
        logThread.start();
    }
}