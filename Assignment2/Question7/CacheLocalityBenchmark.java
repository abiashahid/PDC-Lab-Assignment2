package Assignment2.Question7;

public class CacheLocalityBenchmark {
    private static final int MATRIX_SIZE = 2000;

    public static void main(String[] args) {
        System.out.println("=== Cache Locality & Memory Profiling Benchmark ===");
        System.out.println("Matrix Dimensions: " + MATRIX_SIZE + "x" + MATRIX_SIZE);
        
        int[][] matrix = initializeMatrix(MATRIX_SIZE);
        System.out.println("Matrix allocated and initialized successfully.");

        long rowMajorTime = measureRowMajorTraversal(matrix);
        long colMajorTime = measureColumnMajorTraversal(matrix);

        System.out.println("\n--- Execution Metrics ---");
        System.out.printf("Row-Major Access Time:    %.3f ms\n", rowMajorTime / 1e6);
        System.out.printf("Column-Major Access Time: %.3f ms\n", colMajorTime / 1e6);

        logMemoryFootprint();
    }

    private static void logMemoryFootprint() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.printf("Estimated Heap Footprint: %.2f MB\n", usedMemory / (1024.0 * 1024.0));
    }

    private static int[][] initializeMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i + j) % 100;
            }
        }
        return matrix;
    }

    private static long measureRowMajorTraversal(int[][] matrix) {
        long startTime = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                sum += matrix[i][j];
            }
        }
        long duration = System.nanoTime() - startTime;
        return duration;
    }

    private static long measureColumnMajorTraversal(int[][] matrix) {
        long startTime = System.nanoTime();
        long sum = 0;
        for (int j = 0; j < MATRIX_SIZE; j++) {
            for (int i = 0; i < MATRIX_SIZE; i++) {
                sum += matrix[i][j];
            }
        }
        long duration = System.nanoTime() - startTime;
        return duration;
    }
}