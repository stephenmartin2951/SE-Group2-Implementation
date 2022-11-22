public class SelfTest {
    private boolean testPassed = false;

    public void runSelfTest(){
        this.testPassed = true;
    }

    public boolean isTestPassed() {
        return testPassed;
    }
}
