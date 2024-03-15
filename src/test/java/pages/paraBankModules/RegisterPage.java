package pages.paraBankModules;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.functionalImportantDarVechi.PageObjects;
@Getter
public class RegisterPage extends PageObjects {

    @FindBy(xpath = "//h1[contains(text(),'Signing up is easy!')]")
    WebElement sighUpIsEasyPhraseOnRegistPage;

    @FindBy(xpath = "//input[@id='customer.firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='customer.lastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='customer.address.street']")
    WebElement address;

    @FindBy(xpath = "//input[@id='customer.address.city']")
    WebElement city;

    @FindBy(xpath = "//input[@id='customer.address.state']")
    WebElement state;

    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    WebElement zipCode;

    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
    WebElement phone;

    @FindBy(xpath = "//input[@id='customer.ssn']")
    WebElement ssn;

    @FindBy(xpath = "//input[@id='customer.username']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='customer.password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='repeatedPassword']")
    WebElement confirmedPassword;

    @FindBy(xpath = "//tbody/tr[13]/td[2]/input[1]")
    WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
}
