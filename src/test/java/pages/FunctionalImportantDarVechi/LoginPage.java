package pages.FunctionalImportantDarVechi;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
@Setter
public class LoginPage extends PageObjects {

//    @FindBy(xpath = "//input[@name='email'")
//    WebElement login;
    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    WebElement login;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordLogin;

//    @FindBy(xpath = "//input[@id='sighInSubmit']")
//    WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"signInSubmit\"]")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"authportal-main-section\"]/div[2]/div/div/form/div/div/div/h1")
    WebElement sighInTextOnLoginPage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
