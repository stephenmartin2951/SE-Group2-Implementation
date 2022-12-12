import org.junit.*;
import static org.junit.Assert.*;
import java.awt.Toolkit;

public class ThermometerTest {

    @Test
    public void Thermometer() {
        Thermometer thermometer = new Thermometer();
        assert(!thermometer.isPowerOn());
        assert(thermometer.getBatteryLevel() == 100);
    }

    @Test
    public void isPowerButton() {
        Thermometer thermometer = new Thermometer();
        assert(!thermometer.isPowerButton());
    }

    @Test
    public void pressPowerButton() {
        Thermometer thermometer = new Thermometer();
        assert(!thermometer.isPowerOn());
        thermometer.pressPowerButton(true);
        assert(thermometer.isPowerOn());
    }

    @Test
    public void isBatteryButton() {
        Thermometer thermometer = new Thermometer();
        assert(!thermometer.isBatteryButton());
    }

    @Test
    public void pressBatteryButton() {
        Thermometer thermometer = new Thermometer();
        assert(!thermometer.isBatteryButton());
        thermometer.pressBatteryButton(true);
        assert(thermometer.isBatteryButton());
    }

    @Test
    public void isPowerOn() {
        Thermometer thermometer = new Thermometer();
        assert(!thermometer.isPowerOn());
    }

    @Test
    public void setPowerOn() {
        Thermometer thermometer = new Thermometer();
        assert(!thermometer.isPowerOn());
        thermometer.setPowerOn(true);
        assert(thermometer.isPowerOn());
    }


    @Test
    public void setBatteryLevel() {
        Thermometer thermometer = new Thermometer();
        thermometer.setBatteryLevel(90);
        assert(thermometer.getBatteryLevel() == 90);
        thermometer.setBatteryLevel(80);
        assert(thermometer.getBatteryLevel() == 80);
    }

    @Test
    public void getBatteryLevel() {
        Thermometer thermometer = new Thermometer();
        thermometer.setBatteryLevel(90);
        assert(thermometer.getBatteryLevel() == 90);
        thermometer.setBatteryLevel(80);
        assert(thermometer.getBatteryLevel() == 80);
    }

    @Test
    public void produceBeepingSound(){
        Thermometer thermometer = new Thermometer();
        assertTrue(thermometer.produceBeepingSound(1));
        assertTrue(thermometer.produceBeepingSound(3));
    }
}