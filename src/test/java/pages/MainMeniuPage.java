package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MainMeniuPage extends PageObjectsPage {

    @FindBy(xpath = "//h2[contains(text(),'Account Services')]")
    WebElement accountServices;

    @FindBy(xpath = "//a[contains(text(),'Open New Account')]")
    WebElement openNewAccount;

    @FindBy(xpath = "//a[contains(text(),'Accounts Overview')]")
    WebElement accountsOverview;

    @FindBy(xpath = "//a[contains(text(),'Transfer Funds')]")
    WebElement transferFunds;

    @FindBy(xpath = "//a[contains(text(),'Bill Pay')]")
    WebElement billPay;

    @FindBy(xpath = "//a[contains(text(),'Find Transactions')]")
    WebElement findTransactions;

    @FindBy(xpath = "//a[contains(text(),'Update Contact Info')]")
    WebElement updateContactInfo;

    @FindBy(xpath = "//a[contains(text(),'Request Loan')]")
    WebElement requestLoan;

    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    WebElement logOut;

    public MainMeniuPage(WebDriver driver) {
        super(driver);
    }
}
