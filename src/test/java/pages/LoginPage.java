package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class LoginPage extends PageObjects {
    @Getter
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

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
