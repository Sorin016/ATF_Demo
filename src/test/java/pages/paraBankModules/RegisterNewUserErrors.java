package pages.paraBankModules;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.functionalImportantDarVechi.PageObjects;
@Getter
public class RegisterNewUserErrors extends PageObjects {

    @FindBy(xpath = "//span[@id='customer.address.city.errors']")
    WebElement cityEmptyError;

    @FindBy(xpath = "//span[@id='customer.address.state.errors']")
    WebElement stateEmptyError;

    @FindBy(xpath = "//span[@id='customer.address.zipCode.errors']")
    WebElement zipCodeEmptyError;

    @FindBy(xpath = "//span[@id='customer.ssn.errors']")
    WebElement ssnEmptyError;


    public RegisterNewUserErrors(WebDriver driver) {
        super(driver);
    }
}
