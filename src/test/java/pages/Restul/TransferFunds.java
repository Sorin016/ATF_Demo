package pages.Restul;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.FunctionalImportantDarVechi.PageObjects;

@Getter
public class TransferFunds extends PageObjects {
    @FindBy(xpath = "//input[@id='amount']")
    WebElement transferFundsAmount;

    @FindBy(xpath = "//select[@id='fromAccountId']")
    WebElement fromAccountId;

    @FindBy(xpath = "//select[@id='toAccountId']")
    WebElement toAccountId;

    @FindBy(xpath = "//input[@value='Transfer']")
    WebElement transferButton;

    public TransferFunds(WebDriver driver) {
        super(driver);
    }
}