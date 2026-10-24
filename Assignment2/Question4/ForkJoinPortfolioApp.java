package Assignment2.Question4;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPortfolioApp {
    private static final int ASSET_COUNT = 10000;
    private static final double RISK_CAP = 500.0;

    public static void main(String[] args) {
        System.out.println("=== Fork/Join Parallel Portfolio Assessment Engine ===");
        
        double[] assets = new double[ASSET_COUNT];
        Random random = new Random(42);
        for (int i = 0; i < ASSET_COUNT; i++) {
            assets[i] = 100.0 + (random.nextDouble() * 900.0);
        }
        
        System.out.println("Generated " + ASSET_COUNT + " synthetic asset values.");

        ForkJoinPool pool = new ForkJoinPool();

        // Phase 1: Parallel Cumulative Risk Calculation
        long startTime = System.nanoTime();
        ParallelRiskCalculator riskTask = new ParallelRiskCalculator(assets, 0, assets.length);
        double initialRiskScore = pool.invoke(riskTask);
        long riskCalcTime = System.nanoTime() - startTime;

        System.out.printf("\n--- Phase 1: Cumulative Risk Assessment ---\n");
        System.out.printf("Calculated Total Risk Score: $%.2f\n", initialRiskScore);
        System.out.printf("Execution Time: %.3f ms\n", riskCalcTime / 1e6);

        pool.close();
    }
}