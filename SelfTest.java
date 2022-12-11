public class SelfTest {
    private boolean testPassed = false;

    public void runSelfTest(Thermometer thermometer){
        this.testPassed = true;
        thermometer.produceBeepingSound(3);
        System.out.println("Temperature is ready to be read");
    }

    public boolean isTestPassed() {
        return testPassed;
    }
}
