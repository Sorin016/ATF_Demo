package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import stepDefinition.AbstractStepDef;

public class Hooks extends AbstractStepDef {

    private static final ThreadLocal<RemoteWebDriver> drivers = new ThreadLocal<>();

    @Before(order = -2)
    public void beforeTest() {
//        options.addArguments("--remote-allow-original=*");
        System.setProperty("webdriver.chrome.driver", "src\\webdrivers\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(homePageUrl);
        driver.manage().window().maximize();
    }

    @After
    public void closeChromeDriver() {
        log.info("Calling method to close the browser");
//        driver.quit();
//        driver.close();
    }
}
