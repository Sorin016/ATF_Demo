package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AccountDetailsPage extends PageObjectsPage {

    @FindBy(xpath = "//h1[contains(text(),'Account Details')]")
    WebElement accountDetailsText;

    @FindBy(xpath = "//td[@id='accountId']")
    WebElement accountId;

    @FindBy(xpath = "//td[@id='accountType']")
    WebElement accountType;

    @FindBy(xpath = "//table[@id='accountTable']/tbody/tr/td")
    WebElement accountsTable;

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }
}
