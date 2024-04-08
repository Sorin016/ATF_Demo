package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class OpenNewAccountPage extends ObjectsPage {

    @FindBy(xpath = "//h1[contains(text(),'Open New Account')]")
    WebElement openNewAccountText;

    @FindBy(xpath = "//select[@id='type']")
    WebElement type;

    @FindBy(xpath = "//option[contains(text(),'CHECKING')]")
    WebElement checkingAccount;

    @FindBy(xpath = "//option[contains(text(),'SAVINGS')]")
    WebElement savingsAccount;

    @FindBy(xpath = "//input[@value = 'Open New Account']")
    WebElement openNewAccountButton;

    @FindBy(xpath = "//h1[contains(text(),'Account Opened!')]")
    WebElement accountOpened;

    @FindBy(xpath = "//b[contains(text(),'Your new account number:')]")
    WebElement yourAccountNumberText;

    @FindBy(xpath = "//a[@id='newAccountId']")
    WebElement newAccountID;

    @FindBy(xpath = "//select[@id='fromAccountId']")
    WebElement defauldAccountID;

    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }
}
