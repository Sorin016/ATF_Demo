package pages.FunctionalImportantDarVechi;


import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class GoogleSearchForWebsite extends PageObjects {
    @FindBy(xpath = "//*[@id=\"APjFqb\"]")
    WebElement websiteIsPresenOnGoogleSearch;

    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/div/span/a/h3")
    WebElement websiteIsPresenOnGoogleSearchAfterSerching;

    @FindBy(xpath = "//*[@id=\"APjFqb\"]")
    WebElement sada;


    //Opencart
    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/div/span/a/h3")
    WebElement opencartWebsiteIsPresenOnGoogleSearchAfterSerching;
    public GoogleSearchForWebsite(WebDriver driver){
        super(driver);
    }
}
