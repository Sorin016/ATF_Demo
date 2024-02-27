package pages.Restul;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.FunctionalImportantDarVechi.PageObjects;
@Getter
public class AccountDetails extends PageObjects {

    @FindBy(xpath = "//h1[contains(text(),'Account Details')]")
    WebElement accountDetailsText;

    @FindBy(xpath = "//td[@id='accountId']")
    WebElement accountId;

    @FindBy(xpath = "//td[@id='accountType']")
    WebElement accountType;

    public AccountDetails(WebDriver driver) {
        super(driver);
    }
}
