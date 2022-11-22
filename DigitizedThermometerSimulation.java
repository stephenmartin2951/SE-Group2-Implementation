import java.io.*;
import java.util.Scanner;

public class DigitizedThermometerSimulation {

    public static void main(String args[]){
        Thermometer thermometer = new Thermometer();
        WindowDisplay display = new WindowDisplay();
        TemperatureReader temp = new TemperatureReader();
        SelfTest selftest = new SelfTest();

        //Turn thermometer on
        thermometer.pressPowerButton(true);

        //Run self test
        selftest.runSelfTest();

        if(thermometer.isPowerOn() && selftest.isTestPassed()){
            Scanner sc = new Scanner(new File("SimulatedTemperatures.csv")); //TODO: Idk why this isn't working
            while (sc.hasNext()){
                double nextTemp = sc.nextDouble();
                if(temp.isInRange(nextTemp)){
                    temp.setRecordedTemp(sc.nextDouble());
                }
                display.setTemperatureDisplay(temp.getRecordedTemp());

            }

        }




    }


}


