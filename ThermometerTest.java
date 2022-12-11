import org.junit.*;
import static org.junit.Assert.*;
import java.awt.Toolkit;

public class ThermometerTest {

    @Test
    public void Thermometer() {
        Thermometer thermometer = new Thermometer();
        assert(!thermometer.powerOn);
        assert(!thermometer.inactivity);
        assert(thermometer.batteryLevel == 100);
        assert(!thermometer.powerButton);
        assert(!thermometer.batteryButton);

    }

    @Test
    public void isPowerButton() {
        Thermometer thermometer = new Thermometer();
        assert(!thermometer.powerButton);
    }

    @Test
    public void pressPowerButton() {
        Thermometer thermometer = new Thermometer();
        assert(!thermometer.powerButton);
        thermometer.pressPowerButton(true);
        assert(thermometer.powerButton);
    }

    @Test
    public void isBatteryButton() {
        Thermometer thermometer = new Thermometer();
        assert(!thermometer.batteryButton);
    }

    @Test
    public void pressBatteryButton() {
        Thermometer thermometer = new Thermometer();
        assert(!thermometer.batteryButton);
        thermometer.pressBatteryButton(true);
        assert(thermometer.batteryButton);
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
    public void isInactivity() {
        Thermometer thermometer = new Thermometer();
        assert(!thermometer.isInactivity());
    }

    @Test
    public void setInactivity() {
        Thermometer thermometer = new Thermometer();
        assert(!thermometer.isInactivity());
        thermometer.setInactivity(true);
        assert(thermometer.isInactivity());
    }

    @Test
    public void setBatteryLevel() {
        Thermometer thermometer = new Thermometer();
        thermometer.setBatteryLevel(90);
        assert(thermometer.batteryLevel == 90);
        thermometer.setBatteryLevel(80);
        assert(thermometer.batteryLevel == 80);
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
