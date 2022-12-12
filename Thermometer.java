public class Thermometer {

    private boolean powerOn = false;
    private int batteryLevel = 100;
    private int defaultTemp = 60;
    private boolean idle = true;

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

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public int getDefaultTemp() {
        return defaultTemp;
    }

    public boolean isIdle() {
        return idle;
    }

    public void setIdle(boolean idle) {
        this.idle = idle;
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
