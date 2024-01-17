package hooks;


import actions.Actions;
import driverFactory.DriverType;
import io.cucumber.java.*;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stepDefinition.AbstractStepDef;



public class Hooks extends AbstractStepDef {
    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src\\webdrivers\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(homePageUrl);
        driver.manage().window().maximize();
    }

    @After
    public void closeChromeDriver() {
        log.info("Calling method to close the browser");
           driver.quit();
           driver.close();
    }

    @SneakyThrows
    @BeforeStep
    public void takeScreenshotBeforeEachStep(Scenario scenario){
        log.info("take a screenshot before steps");
        Actions.takeScreenshot(scenario,driver);
    }
    @SneakyThrows
    @AfterStep
    public void takeScreenshotAfterEachStep(Scenario scenario){
        log.info("take a screenshot after steps");
        Actions.takeScreenshot(scenario,driver);
    }
}
