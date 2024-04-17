package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class BillPaymentCompletePage extends PageObjectsPage{
    @FindBy (xpath = "//h1[normalize-space()='Bill Payment Complete']")
    WebElement billPaymentCompleteText;

    @FindBy (xpath = "//span[@id='amount']")
    WebElement billPaymentFromAmount;

    @FindBy (xpath = "//span[@id='fromAccountId']")
    WebElement billPaymentFromAccount;


    public BillPaymentCompletePage(WebDriver driver) {
        super(driver);
    }
}
