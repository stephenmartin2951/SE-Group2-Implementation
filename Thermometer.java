public class Thermometer {

    private boolean powerOn = false;
    private boolean inactivity = false;
    private int batteryLevel = 100;

    private boolean powerButton = false;
    private boolean batteryButton = false;

    public void pressPowerButton(boolean powerButton){
        this.powerButton = powerButton;
        setPowerOn(powerButton);
    }

    public void pressBatteryButton(boolean batteryButton){
        this.batteryButton = batteryButton;
    }

    public boolean isPowerButton() {
        return powerButton;
    }

    public boolean isBatteryButton() {
        return batteryButton;
    }


    public boolean isPowerOn() {
        return powerOn;
    }

    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    public boolean isInactivity() {
        return inactivity;
    }

    public void setInactivity(boolean inactivity) {
        this.inactivity = inactivity;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public void beep(){
        System.out.println("Beep!");
    }


}
