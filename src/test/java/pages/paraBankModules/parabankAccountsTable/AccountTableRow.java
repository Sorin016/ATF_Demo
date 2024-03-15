package pages.paraBankModules.parabankAccountsTable;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AccountTableRow {
    @FindBy(xpath = "/tr[1]/td[1]")
    WebElement firstElement;
    @FindBy(xpath = "/tr[1]/td[2]")
    WebElement secondElement;
    @FindBy(xpath = "/tr[1]/td[3]")
    WebElement thirdElement;
}
