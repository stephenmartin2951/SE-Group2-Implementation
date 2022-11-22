public class TemperatureReader {
    private double recordedTemp;
    final private int minTemp = 0;
    final private int maxTemp = 120;
    private boolean inRange = false;

    public double getRecordedTemp() {
        return recordedTemp;
    }

    public void setRecordedTemp(double recordedTemp) {
        this.recordedTemp = recordedTemp;
    }


    public boolean isInRange(double inRange) {
        if(inRange >= 0 && inRange <= 120){
            return true;
        } else {
            return false;
        }
    }

    public TemperatureReader(){
        double tempSimulation = (Math.random() * (100 - 60)) + 60;

        if(isInRange(tempSimulation)){
            setRecordedTemp(tempSimulation);
        }

    }

}
