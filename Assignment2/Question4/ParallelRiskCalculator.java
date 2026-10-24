package Assignment2.Question4;

import java.util.concurrent.RecursiveTask;

public class ParallelRiskCalculator extends RecursiveTask<Double> {
    private static final int THRESHOLD = 1000;
    private final double[] assetValues;
    private final int start;
    private final int end;

    public ParallelRiskCalculator(double[] assetValues, int start, int end) {
        this.assetValues = assetValues;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        if ((end - start) <= THRESHOLD) {
            double sum = 0;
            for (int i = start; i < end; i++) {
                sum += assetValues[i];
            }
            return sum;
        }
        return 0.0;
    }
}