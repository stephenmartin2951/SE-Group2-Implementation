public class TemperatureReader {
    public double recordedTemp;
    final public int minTemp = 96;
    final public int maxTemp = 120;
    final public double feverLimit = 98.6;
    public boolean hasFever = false;
    public boolean inRange = false;
    public String outOfRange = "Error: Temperature out of range.";

    public double getRecordedTemp() {
        return recordedTemp;
    }

    public void setRecordedTemp(double recordedTemp) {
        this.recordedTemp = recordedTemp;
    }

    public boolean hasFever(double recordedTemp) {
        return (recordedTemp >= feverLimit);
    }

    public boolean isInRange(double inRange) {
        return inRange >= minTemp && inRange <= maxTemp;
    }

    public TemperatureReader(){
        double tempSimulation = (Math.random() * (100 - 60)) + 60;

        if(isInRange(tempSimulation)){
            setRecordedTemp(tempSimulation);
        }

    }

}
