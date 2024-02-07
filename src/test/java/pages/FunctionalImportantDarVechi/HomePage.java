package pages.FunctionalImportantDarVechi;


import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage extends PageObjects {
    //6pm
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/div[1]/a/picture/img")
    WebElement homePageLogo;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/div[1]/div[3]/div[1]/a")
    WebElement loginButtonOnHomePage;


    //Opencar
    @FindBy(xpath = "//*[@id=\"logo\"]/a/img")
    WebElement homePageLogoOpencart;

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
