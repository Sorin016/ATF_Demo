package browserManager;

import driverFactory.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

import util.PropretyLoader;

public class ChromeManager extends DriverManager {
    private ChromeDriverService chromeDriverService;

    public void startService() {
        if (null == chromeDriverService) {
            try {
                chromeDriverService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(PropretyLoader.loadProperty("chromeDriver")))
                        .usingPort(4723)
                        .build();
                chromeDriverService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stopService() {
        if (null != chromeDriverService && chromeDriverService.isRunning())
            chromeDriverService.stop();
    }

    public void createDriver() {
        driver = new ChromeDriver(chromeDriverService);
    }
}
