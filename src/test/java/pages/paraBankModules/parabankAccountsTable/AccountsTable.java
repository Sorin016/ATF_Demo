package pages.paraBankModules.parabankAccountsTable;

import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class AccountsTable {

    @FindBy(xpath = "//*[@id=\"accountTable\"]/tbody")
    private List<AccountTableRow> accountTableRows;

}

