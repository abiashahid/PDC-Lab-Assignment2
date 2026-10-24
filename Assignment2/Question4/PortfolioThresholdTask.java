package Assignment2.Question4;

import java.util.concurrent.RecursiveAction;

public class PortfolioThresholdTask extends RecursiveAction {
    private static final int THRESHOLD = 1000;
    private final double[] assetValues;
    private final int start;
    private final int end;
    private final double riskCap;

    public PortfolioThresholdTask(double[] assetValues, int start, int end, double riskCap) {
        this.assetValues = assetValues;
        this.start = start;
        this.end = end;
        this.riskCap = riskCap;
    }

    @Override
    protected void compute() {
        if ((end - start) <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                if (assetValues[i] > riskCap) {
                    assetValues[i] *= 0.95; // 5% volatility stress-test penalty
                }
            }
        }
    }
}