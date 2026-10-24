package Assignment2.Question6;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InventoryCatalogApp {
    private static final int TOTAL_ITEMS = 1000;
    private static final int THREAD_POOL_SIZE = 10;
    private static final int OPS_PER_THREAD = 5000; // Total 50,000 operations

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== E-Commerce Inventory Catalog Concurrency Benchmark ===");
        InventoryCatalogManager manager = new InventoryCatalogManager(TOTAL_ITEMS);

        double syncTime = benchmarkSynchronizedMap(manager);
        double concurrentTime = benchmarkConcurrentMap(manager);

        System.out.println("\n--- Concurrency Performance Summary ---");
        System.out.printf("SynchronizedMap Execution Time: %.3f ms\n", syncTime);
        System.out.printf("ConcurrentHashMap Execution Time: %.3f ms\n", concurrentTime);
        System.out.printf("Fine-grained Bucket Locking Speedup: %.2fx faster\n", (syncTime / concurrentTime));
        System.out.println("=========================================================");
    }

    private static double benchmarkSynchronizedMap(InventoryCatalogManager manager) throws InterruptedException {
        Map<String, Integer> syncCatalog = manager.createSynchronizedMap();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        long startTime = System.nanoTime();

        for (int t = 0; t < THREAD_POOL_SIZE; t++) {
            executor.execute(() -> {
                for (int i = 0; i < OPS_PER_THREAD; i++) {
                    String key = "PROD_" + (i % TOTAL_ITEMS);
                    manager.executeCatalogTransaction(syncCatalog, key);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        long durationNs = System.nanoTime() - startTime;

        double timeMs = durationNs / 1e6;
        double seconds = durationNs / 1e9;
        double throughput = (THREAD_POOL_SIZE * OPS_PER_THREAD) / seconds;

        System.out.println("\n--- Collections.synchronizedMap Benchmark ---");
        System.out.printf("Total Execution Time: %.3f ms\n", timeMs);
        System.out.printf("Throughput: %.2f ops/sec\n", throughput);

        return timeMs;
    }

    private static double benchmarkConcurrentMap(InventoryCatalogManager manager) throws InterruptedException {
        Map<String, Integer> concurrentCatalog = manager.createConcurrentMap();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        long startTime = System.nanoTime();

        for (int t = 0; t < THREAD_POOL_SIZE; t++) {
            executor.execute(() -> {
                for (int i = 0; i < OPS_PER_THREAD; i++) {
                    String key = "PROD_" + (i % TOTAL_ITEMS);
                    manager.executeCatalogTransaction(concurrentCatalog, key);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        long durationNs = System.nanoTime() - startTime;

        double timeMs = durationNs / 1e6;
        double seconds = durationNs / 1e9;
        double throughput = (THREAD_POOL_SIZE * OPS_PER_THREAD) / seconds;

        System.out.println("\n--- ConcurrentHashMap Benchmark ---");
        System.out.printf("Total Execution Time: %.3f ms\n", timeMs);
        System.out.printf("Throughput: %.2f ops/sec\n", throughput);

        return timeMs;
    }
}