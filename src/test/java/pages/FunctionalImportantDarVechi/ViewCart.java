package pages.FunctionalImportantDarVechi;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class ViewCart extends PageObjects{

    @FindBy(xpath = "//*[@id=\"root\"]/div[5]/div[2]/div/div[4]/button")
    WebElement addedToBagSighn;

    public ViewCart(WebDriver driver){
        super(driver);
    }
}
