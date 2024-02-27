package pages.FunctionalImportantDarVechi;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ErrorLoginPage extends PageObjects {

    @FindBy(xpath = "//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")
    WebElement invalidPassword;

    public ErrorLoginPage(WebDriver driver){
        super(driver);
    }
}
