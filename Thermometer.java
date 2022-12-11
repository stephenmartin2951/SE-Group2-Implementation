import java.awt.Toolkit;

public class Thermometer {

    public boolean powerOn = false;
    public boolean inactivity = false;
    public int batteryLevel = 100;

    public boolean powerButton = false;
    public boolean batteryButton = false;

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

    public Boolean produceBeepingSound(int times){
        for(int i = 0; i < times; i++){
            java.awt.Toolkit.getDefaultToolkit().beep();
            System.out.println("Beep!");
            try{
                Thread.sleep(350);
            } catch (InterruptedException e){
                return false;
            }
        }
        return true;
    }


}
