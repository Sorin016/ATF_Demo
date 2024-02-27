package openCart;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.functionalImportantDarVechi.PageObjects;

@Getter
public class LoginPageOpencart extends PageObjects {

    @FindBy(xpath = "/html/body/main/div[2]/div/div/div/div[2]/div/div/form/div[1]/input")
    WebElement loginField;

    @FindBy(xpath = "/html/body/main/div[2]/div/div/div/div[2]/div/div/form/div[2]/input")
    WebElement passField;

    @FindBy(xpath = "/html/body/main/div[2]/div/div/div/div[2]/div/div/form/button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"logo\"]/a/img")
    WebElement opencartLogoFromLoginPage;

    public LoginPageOpencart(WebDriver driver) {
        super(driver);
    }
}
