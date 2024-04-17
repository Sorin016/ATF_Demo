package stepDefinition;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pages.*;
import util.PropretyLoader;

import java.util.logging.Logger;

@Getter
public class AbstractStepDef {
    protected static WebDriver driver;
    protected static String homePageUrl = PropretyLoader.loadProperty("homePageUrl");
    protected static String homePageUrlForAPI = PropretyLoader.loadProperty("homePageUrlForAPI");
    protected static String registerPageForAPI = PropretyLoader.loadProperty("registerPage");
    protected static String loginPageForAPI = PropretyLoader.loadProperty("loginPage");
    protected static String createNewAccountPageForAPI = PropretyLoader.loadProperty("createNewAccountPage");
    protected static String sentNewTransactionPageFromAPI = PropretyLoader.loadProperty("newTransaction");
    protected static String billPayForAPI = PropretyLoader.loadProperty("billPay");
    public ParaBankHomePage paraBankHomePage = new ParaBankHomePage(driver);
    public RegisterPage registerPage = new RegisterPage(driver);
    public RegisterNewUserErrorsPage registerNewUserErrorsPage = new RegisterNewUserErrorsPage(driver);
    public SuccessfulRegistrecionPage successfulRegistrecionPage = new SuccessfulRegistrecionPage(driver);
    public MainMeniuPage mainMeniuPage = new MainMeniuPage(driver);
    public OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage(driver);
    public AccountDetailsPage accountDetailsPage = new AccountDetailsPage(driver);
    public TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
    public AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
    public BillPaymentCompletePage billPaymentCompletePage = new BillPaymentCompletePage(driver);
    public BillPaymentPage billPaymentPage = new BillPaymentPage(driver);
    protected Logger log = Logger.getLogger((this.getClass().getName()));
}
