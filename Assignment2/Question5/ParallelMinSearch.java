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
        double min = Double.MAX_VALUE;
        for (int i = startIdx; i < endIdx; i++) {
            if (sensorData[i] < min) {
                min = sensorData[i];
            }
        }
        this.resultMin = min;
        return min;
    }
}