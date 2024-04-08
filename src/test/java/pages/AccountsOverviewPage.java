package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AccountsOverviewPage extends PageObjectsPage {

    @FindBy(xpath = "//h1[contains(text(),'Accounts Overview')]")
    WebElement accountOverviewText;

    @FindBy(xpath = "//a[contains(text(),'18450')]")
    WebElement ourAccount;

    @FindBy(xpath = "//*[@id=\"accountTable\"]/tbody")
    WebElement accountTable;

    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
    }
}
