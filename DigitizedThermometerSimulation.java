import java.io.*;
import java.util.Scanner;

public class DigitizedThermometerSimulation {

    public static void main(String args[]) throws FileNotFoundException, InterruptedException {
        Thermometer thermometer = new Thermometer();
        WindowDisplay display = new WindowDisplay();
        TemperatureReader temp = new TemperatureReader();
        SelfTest selftest = new SelfTest();
        File inputFile = new File("simulatedTemps.txt");
        long startTime = System.currentTimeMillis();
        boolean displayBattery = true;
        boolean batteryIsDisplayed = true;


        //Turn thermometer on (Requirement 1.1)
        thermometer.pressPowerButton(true);

        //Showing default temp & battery (Requirement 1.2)
        display.setTemperatureDisplay(thermometer.getDefaultTemp());
        display.displayTemperature(display);
        display.displayBatteryLife(thermometer);


        //Run self test (Requirement 2.1)
        selftest.runSelfTest();
        thermometer.produceBeepingSound(3); //Beep three times (Requirement 2.1.2)
        if(selftest.isTestPassed()){
            thermometer.setIdle(false);
        } else{
            //if test fails, thermometer will remain in idle state (Requirement 2.1.1)
            System.out.println("Test Failed");
        }

        if(thermometer.isPowerOn() && !thermometer.isIdle()){
            Scanner sc = new Scanner(inputFile);
            long currentCycleTime = startTime;
            long batteryCycleTime = startTime;
            long batteryRunTime = startTime;
            long inactivityTime = startTime;
            while (sc.hasNext() && thermometer.isPowerOn()){
                double nextTemp = sc.nextDouble();
                long currentTime = System.currentTimeMillis();
                long timeRun = currentTime - currentCycleTime;
                long batteryTimeRun = currentTime - batteryCycleTime;
                long inactivityTimeRun = currentTime - inactivityTime;

                if(inactivityTimeRun >= 180000){ //Requirement (6.1)
                    thermometer.setPowerOn(false);
                }

                if(temp.isInRange(nextTemp)){ //Requirement 3.2
                    temp.setRecordedTemp(nextTemp);
                }
                display.setTemperatureDisplay(temp.getRecordedTemp()); //Requirement (3.1)
                display.displayTemperature(display); //Requirements (3.1, 3.1.1 (Displaying Fahrenheit by default))

                if(timeRun >= 90000){ //Requirement (3.3)
                    double finalTemp = nextTemp;
                    thermometer.produceBeepingSound(2);
                    temp.setRecordedTemp(finalTemp);
                    display.setTemperatureDisplay(temp.getRecordedTemp());
                    display.displayTemperature(display);
                    if(temp.hasFever(temp.getRecordedTemp())) {
                        System.out.println("You have a fever!");
                    }
                    Thread.sleep(6000);
                    System.out.println("Conversion Button Pressed");
                    temp.setRecordedTemp(display.convertCelsiusOrFahrenheit(finalTemp, true)); //Requirements(5.1)
                    display.setTemperatureDisplay(temp.getRecordedTemp());
                    display.displayTemperature(display);
                    Thread.sleep(6000);

                    currentCycleTime = currentTime;
                }

                //Start of Battery Display Logic
                if(batteryTimeRun >= 60000){
                    thermometer.setBatteryLevel(thermometer.getBatteryLevel() - 1);
                    while(thermometer.getBatteryLevel() <= 2){
                        thermometer.produceBeepingSound(5);
                        thermometer.setPowerOn(false); //Requirement 4.2
                    }
                    //Reset start time
                    batteryCycleTime = currentTime;
                    if(!displayBattery){
                        displayBattery = true;
                    }
                }
                //Display battery level for only 5 seconds (Requirement 1.2.1, 4.1.1)
                if(displayBattery){
                    display.displayBatteryLife(thermometer); //Requirement 4.1
                    if(batteryIsDisplayed){
                        long batteryDisplayTime = System.currentTimeMillis() - batteryRunTime;
                        if(batteryDisplayTime >= 5000){
                            displayBattery = false;
                        }
                    }
                } else {
                    batteryRunTime = currentTime;
                } //End of Battery Display Logic


                Thread.sleep(1000);
            }

        }

    }


}


