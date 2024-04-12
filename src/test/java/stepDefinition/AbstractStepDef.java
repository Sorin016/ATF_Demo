package stepDefinition;

import lombok.Getter;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
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
    public ParaBankHomePage paraBankHomePage = new ParaBankHomePage(driver);
    public RegisterPage registerPage = new RegisterPage(driver);
    public RegisterNewUserErrorsPage registerNewUserErrorsPage = new RegisterNewUserErrorsPage(driver);
    public SuccessfulRegistrecionPage successfulRegistrecionPage = new SuccessfulRegistrecionPage(driver);
    public MainMeniuPage mainMeniuPage = new MainMeniuPage(driver);
    public OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage(driver);
    public AccountDetailsPage accountDetailsPage = new AccountDetailsPage(driver);
    public TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
    public AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
    public BillPaymentPage billPaymentPage=new BillPaymentPage(driver);
    public RandomStream randomStream = new RandomStream();
    protected ChromeOptions options = new ChromeOptions();
    protected Logger log = Logger.getLogger((this.getClass().getName()));
}
