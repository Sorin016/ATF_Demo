package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SuccessfulRegistrecionPage extends ObjectsPage {

    @FindBy(xpath = "//p[contains(text(),'Your account was created successfully. You are now')]")
    WebElement accountCreationWithSuccess;

    @FindBy(xpath = "//h1[contains(text(),'Welcome ')]")
    WebElement wlecome;

    public SuccessfulRegistrecionPage(WebDriver driver) {
        super(driver);
    }
}
