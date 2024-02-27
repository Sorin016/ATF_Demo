package pages.paraBankModules.parabankAccountsTable;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AccountsTableHeader {
    @FindBy(xpath = "//*[@id=\"accountTable\"]/thead/tr/th[1]")
    WebElement accountTableAmount;

    @FindBy(xpath = "//*[@id=\"accountTable\"]/thead/tr/th[2]")
    WebElement accountTableBalance;

    @FindBy(xpath = "//*[@id=\"accountTable\"]/thead/tr/th[3]")
    WebElement accountTableAvailableAmount;
}
