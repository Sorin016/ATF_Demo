package hooks;

import actions.Actions;
import io.cucumber.java.*;
import lombok.SneakyThrows;
import org.openqa.selenium.chrome.ChromeDriver;
import stepDefinition.important.AbstractStepDef;

public class Hooks extends AbstractStepDef {
    @Before("@UI")
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src\\webdrivers\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(homePageUrl);
        driver.manage().window().maximize();
    }

    @After("@UI")
    public void closeChromeDriver() {
        log.info("Calling method to close the browser");
        driver.close();
        driver.quit();
    }

    @SneakyThrows
    @BeforeStep("@UI")
    public void takeScreenshotBeforeEachStep(Scenario scenario) {
        log.info("take a screenshot before steps");
        Actions.takeScreenshot(scenario, driver);
    }

    @SneakyThrows
    @AfterStep("@UI")
    public void takeScreenshotAfterEachStep(Scenario scenario) {
        log.info("take a screenshot after steps");
        Actions.takeScreenshot(scenario, driver);
    }
}
