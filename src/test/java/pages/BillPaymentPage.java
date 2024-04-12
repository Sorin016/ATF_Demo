package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter

public class BillPaymentPage extends PageObjectsPage {
    @FindBy(xpath = "//h1[contains(text(),'Bill Payment Service')]")
    WebElement billPaymentText;

    @FindBy(xpath = "//input[@name='payee.name']")
    WebElement billPayeeNameField;

    @FindBy(xpath = "//input[@name='payee.address.street']")
    WebElement billPayeeAddressField;

    @FindBy(xpath = "//input[@name='payee.address.city']")
    WebElement billPayeeCityField;

    @FindBy(xpath = "//input[@name='payee.address.state']")
    WebElement billpayeeStateField;

    @FindBy(xpath = "//input[@name='payee.address.zipCode']")
    WebElement billPayeeZipCodeField;

    @FindBy(xpath = "//input[@name='payee.phoneNumber']")
    WebElement billPayeePhoneField;

    @FindBy(xpath = "//input[@name='payee.accountNumber']")
    WebElement billPayeeAccountNumberField;

    @FindBy(xpath = "//input[@name='verifyAccount']")
    WebElement billPayeeVerifyAccountNumberField;

    @FindBy(xpath = "//input[@name='amount']")
    WebElement billPayeeAmount;

    @FindBy(xpath = "//select[@name='fromAccountId']")
    WebElement billpayeeFromAmountId;

    @FindBy(xpath = "//input[@value='Send Payment']")
    WebElement billpayeeSendPaymentButton;

    public BillPaymentPage(WebDriver driver) {
        super(driver);
    }
}
