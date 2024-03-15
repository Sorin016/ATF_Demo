package pages.paraBankModules;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.functionalImportantDarVechi.PageObjects;

@Getter
public class AccountsOverview extends PageObjects {

    @FindBy(xpath = "//h1[contains(text(),'Accounts Overview')]")
    WebElement accountOverviewText;

    @FindBy(xpath = "//a[contains(text(),'18450')]")
    WebElement ourAccount;

    @FindBy(xpath = "//*[@id=\"accountTable\"]/tbody")
    WebElement accountTable;

    public AccountsOverview(WebDriver driver) {
        super(driver);
    }
}
