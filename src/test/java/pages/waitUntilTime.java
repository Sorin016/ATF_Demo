package pages;

import java.util.concurrent.TimeUnit;

public class waitUntilTime {
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
