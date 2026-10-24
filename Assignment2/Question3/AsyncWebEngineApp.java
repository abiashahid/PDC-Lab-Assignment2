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
    }
}