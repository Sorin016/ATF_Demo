package pages.paraBankModules;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.functionalImportantDarVechi.PageObjects;


@Getter
public class ParaBankHomePage extends PageObjects {

    @FindBy(xpath = "//h2[contains(text(),'Customer Login')]")
    WebElement customerLogin;

    @FindBy(xpath = "//input[@name = 'username']")
    WebElement userNameLogin;

    @FindBy(xpath = "//input[@name = 'password']")
    WebElement passwordLogin;

    @FindBy(xpath = "//input[@value = 'Log In']")
    WebElement loginButton;

    @FindBy(xpath = "//img[contains(@title,'ParaBank')]")
    WebElement paraBankLogoOnTheHomePage;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement registerButtonOnHomePage;

    public ParaBankHomePage(WebDriver driver) {
        super(driver);
    }
}
