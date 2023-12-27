package stepDefinition;

import lombok.Getter;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import util.PropretyLoader;

import java.util.logging.Logger;
@Getter
public class AbstractStepDef {
    protected static RemoteWebDriver driverManager;
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptException executor;
    protected static String chromeDriver= PropretyLoader.loadProperty("chromeDriver");
    protected static String homePageUrl= PropretyLoader.loadProperty("homePageUrl");
    protected ChromeOptions options=new ChromeOptions();

    protected Logger log= Logger.getLogger((this.getClass().getName()));
    LoginPage loginPage=new LoginPage(driver);
    SearchForMensShoes searchForMensShoes=new SearchForMensShoes(driver);
    GoogleSearchForWebsite googleSearchForWebsite=new GoogleSearchForWebsite(driver);
    HomePage homePage=new HomePage(driver);
    ViewCart viewCart=new ViewCart(driver);
    ErrorLoginPage errorLoginPage=new ErrorLoginPage(driver);
    LoginPageOpencart loginPageOpencart=new LoginPageOpencart(driver);
}
