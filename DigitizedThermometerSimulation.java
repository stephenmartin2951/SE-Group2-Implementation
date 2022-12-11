import java.io.*;
import java.util.Scanner;

public class DigitizedThermometerSimulation {

    public static void main(String args[]) throws FileNotFoundException, InterruptedException {
        Thermometer thermometer = new Thermometer();
        WindowDisplay display = new WindowDisplay();
        TemperatureReader temp = new TemperatureReader();
        SelfTest selftest = new SelfTest();
        File inputFile = new File("simulatedTemps.txt");


        //Turn thermometer on
        thermometer.pressPowerButton(true);

        //Run self test
        selftest.runSelfTest(thermometer);

        if(thermometer.isPowerOn() && selftest.isTestPassed()){
            Scanner sc = new Scanner(inputFile);
            while (sc.hasNext()){
                double nextTemp = sc.nextDouble();
                if(temp.isInRange(nextTemp)){
                    temp.setRecordedTemp(sc.nextDouble());
                display.setTemperatureDisplay(temp.getRecordedTemp());
                display.displayTemperature(display);
                    if(temp.hasFever(temp.getRecordedTemp())) {
                        System.out.println("You have a fever!");
                    }
                Thread.sleep(1000);
                } else {
                    System.out.println(temp.outOfRange);
                }
            }

        }




    }


}


