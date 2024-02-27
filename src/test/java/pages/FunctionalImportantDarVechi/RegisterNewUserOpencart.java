package pages.FunctionalImportantDarVechi;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class RegisterNewUserOpencart extends PageObjects{
    @FindBy(partialLinkText = "My Account")
    WebElement accountButtonOnHomePage;

    @FindBy(partialLinkText = "Register")
    WebElement registerButonOnHomePage;

    @FindBy(name ="firstname")
    WebElement firstNameField;

    @FindBy(name = "lastname")
    WebElement lastNameField;

    @FindBy(name="email")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButtonOnRegisterPage;

    @FindBy(name = "newsletter")
    WebElement newsLetterButton;

    @FindBy(name="agree")
    WebElement agreeButton;




    public RegisterNewUserOpencart(WebDriver driver) {
        super(driver);
    }
}
