package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class RegisterNewUserErrorsPage extends ObjectsPage {

    @FindBy(xpath = "//span[@id='customer.address.city.errors']")
    WebElement cityEmptyError;

    @FindBy(xpath = "//span[@id='customer.address.state.errors']")
    WebElement stateEmptyError;

    @FindBy(xpath = "//span[@id='customer.address.zipCode.errors']")
    WebElement zipCodeEmptyError;

    @FindBy(xpath = "//span[@id='customer.ssn.errors']")
    WebElement ssnEmptyError;

    public RegisterNewUserErrorsPage(WebDriver driver) {
        super(driver);
    }
}
