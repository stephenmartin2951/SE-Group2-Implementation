public class TemperatureReader {
    private double recordedTemp;
    final private int minTemp = 0;
    final private int maxTemp = 120;
    private boolean inRange = false;

    final private double feverLimit = 98.6;
    private boolean hasFever = false;

    public double getRecordedTemp() {
        return recordedTemp;
    }

    public void setRecordedTemp(double recordedTemp) {
        this.recordedTemp = recordedTemp;
    }


    public boolean isInRange(double inRange) {
        if(inRange >= minTemp && inRange <= maxTemp){ //Requirement 3.2.1
            return true;
        } else {
            System.out.println("Temperature out of range"); //Requirement 3.2.1
            return false;
        }
    }

    public boolean hasFever(double recordedTemp) {
        return (recordedTemp >= feverLimit);
    }

    public TemperatureReader(){
        double tempSimulation = (Math.random() * (100 - 60)) + 60;

        if(isInRange(tempSimulation)){
            setRecordedTemp(tempSimulation);
        }

    }

    public boolean isHasFever() {
        return hasFever;
    }

    public void setHasFever(boolean hasFever) {
        this.hasFever = hasFever;
    }
}
