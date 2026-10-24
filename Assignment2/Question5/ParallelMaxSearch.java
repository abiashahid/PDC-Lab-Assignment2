package Assignment2.Question5;

public class ParallelMaxSearch extends SensorSearchEngine {
    private double resultMax = -Double.MAX_VALUE;

    public ParallelMaxSearch(double[] sensorData, int startIdx, int endIdx) {
        super(sensorData, startIdx, endIdx);
    }

    public double getResultMax() {
        return resultMax;
    }

    @Override
    public double processGrid() {
        return 0.0;
    }
}