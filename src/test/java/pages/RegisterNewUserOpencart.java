package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class RegisterNewUserOpencart extends PageObjects{
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/a/span")
    WebElement accountButtonOnHomePage;

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/ul/li[1]/a")
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

    @FindBy(partialLinkText = "I have read and agree")
    WebElement iRead;




    public RegisterNewUserOpencart(WebDriver driver) {
        super(driver);
    }
}
