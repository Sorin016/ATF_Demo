package stepDefinition.important;

import lombok.Getter;
import openCart.IponeProductOpencart;
import openCart.LoginPageOpencart;
import openCart.OpencartHomePage;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.functionalImportantDarVechi.*;
import pages.paraBankModules.*;
import util.PropretyLoader;
import util.RandomStream;

import java.util.logging.Logger;

@Getter
public class AbstractStepDef {
    protected static RemoteWebDriver driverManager;
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptException executor;
    protected static String chromeDriver = PropretyLoader.loadProperty("chromeDriver");
    protected static String homePageUrl = PropretyLoader.loadProperty("homePageUrl");
    protected ChromeOptions options = new ChromeOptions();

    protected Logger log = Logger.getLogger((this.getClass().getName()));
    LoginPage loginPage = new LoginPage(driver);
    SearchForMensShoes searchForMensShoes = new SearchForMensShoes(driver);
    GoogleSearchForWebsite googleSearchForWebsite = new GoogleSearchForWebsite(driver);
    HomePage homePage = new HomePage(driver);
    ViewCart viewCart = new ViewCart(driver);
    ErrorLoginPage errorLoginPage = new ErrorLoginPage(driver);
    LoginPageOpencart loginPageOpencart = new LoginPageOpencart(driver);
    IponeProductOpencart iponeProductOpencart = new IponeProductOpencart(driver);
    OpencartHomePage opencartHomePage = new OpencartHomePage(driver);
    RegisterNewUserOpencart registerNewUserOpencart = new RegisterNewUserOpencart(driver);
    public ParaBankHomePage paraBankHomePage = new ParaBankHomePage(driver);
    public RegisterPage registerPage = new RegisterPage(driver);
    public RegisterNewUserErrors registerNewUserErrors = new RegisterNewUserErrors(driver);
    public SuccessfulRegistrecion successfulRegistrecion = new SuccessfulRegistrecion(driver);
    public MainMeniu mainMeniu = new MainMeniu(driver);
    public OpenNewAccount openNewAccount = new OpenNewAccount(driver);
    public AccountDetails accountDetails = new AccountDetails(driver);
    public TransferFunds transferFunds = new TransferFunds(driver);
    public AccountsOverview accountsOverview = new AccountsOverview(driver);

    public RandomStream randomStream = new RandomStream();
}
