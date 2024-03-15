package pages.paraBankModules;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.functionalImportantDarVechi.PageObjects;

@Getter
public class AccountDetails extends PageObjects {

    @FindBy(xpath = "//h1[contains(text(),'Account Details')]")
    WebElement accountDetailsText;

    @FindBy(xpath = "//td[@id='accountId']")
    WebElement accountId;

    @FindBy(xpath = "//td[@id='accountType']")
    WebElement accountType;

    @FindBy(xpath = "//table[@id='accountTable']/tbody/tr/td")
    WebElement accountsTable;

    public AccountDetails(WebDriver driver) {
        super(driver);
    }
}
