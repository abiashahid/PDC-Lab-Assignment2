package Assignment2.Question5;

public class ParallelMinSearch extends SensorSearchEngine {
    private double resultMin = Double.MAX_VALUE;

    public ParallelMinSearch(double[] sensorData, int startIdx, int endIdx) {
        super(sensorData, startIdx, endIdx);
    }

    public double getResultMin() {
        return resultMin;
    }

    @Override
    public double processGrid() {
        return 0.0;
    }
}