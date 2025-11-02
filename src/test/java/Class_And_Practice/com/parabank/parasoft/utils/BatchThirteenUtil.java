package Class_And_Practice.com.parabank.parasoft.utils;

public class BatchThirteenUtil {
    final public static int WAIT_TIME = 30;

    public static final String PAGE_TITLE = "ParaBank | Welcome | Online Banking";

    public static void waitForDomStable() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
