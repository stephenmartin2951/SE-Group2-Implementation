public class WindowDisplay {

    private double temperatureDisplay = 65.00;
    private boolean idle = true;

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

    public double convertCelsiusOrFahrenheit(double temperature, boolean convertToCelsius){ //Requirement (5.2)
        if(convertToCelsius){
            //Convert to Celsius
            temperature = (temperature - 32.0) * (5.0/9.0);
        } else {
            //Convert to Fahrenheit
            temperature = temperature * (9.0/5.0) + 32.0;
        }

        return temperature;
    }

    public void displayBatteryLife(Thermometer thermometer){
        System.out.println("Battery Level: " + thermometer.getBatteryLevel() + "%");
    }

    public void displayTemperature(WindowDisplay temperature){System.out.println("Thermometer is displaying" +
            " temperature of: " + (int)temperature.getTemperatureDisplay());}
}
