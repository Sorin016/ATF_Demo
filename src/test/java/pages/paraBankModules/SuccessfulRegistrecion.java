package pages.paraBankModules;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.functionalImportantDarVechi.PageObjects;


@Getter
public class SuccessfulRegistrecion extends PageObjects {

    @FindBy(xpath = "//p[contains(text(),'Your account was created successfully. You are now')]")
    WebElement accountCreationWithSuccess;

    @FindBy(xpath = "//h1[contains(text(),'Welcome ')]")
    WebElement wlecome;

    public SuccessfulRegistrecion(WebDriver driver) {
        super(driver);
    }
}
