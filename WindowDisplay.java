public class WindowDisplay {

    public double temperatureDisplay = 65.00;
    public boolean idle = true;

    public double getTemperatureDisplay() {
        return temperatureDisplay;
    }

    public void setTemperatureDisplay(double defaultDisplay) {
        this.temperatureDisplay = defaultDisplay;
    }

    public boolean isIdle() {
        return idle;
    }

    public void setIdle(boolean idle) {
        this.idle = idle;
    }

    public int convertCelsiusOrFahrenheit(int temperature, boolean convertToCelsius){
        if(convertToCelsius){
            //Convert to Celsius
            temperature = temperature * (9/5) + 32;
        } else {
            //Convert to Fahrenheit
            temperature = (temperature - 32) * (5/9);
        }
        return temperature;
    }

    public void displayBatteryLife(Thermometer thermometer){
        System.out.println(thermometer.getBatteryLevel());
    }

    public void displayTemperature(WindowDisplay temperature){System.out.println("Thermometer is displaying" +
            " temperature of: " + temperature.getTemperatureDisplay());}
}
