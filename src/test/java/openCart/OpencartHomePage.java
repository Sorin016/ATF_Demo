package openCart;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.functionalImportantDarVechi.PageObjects;

@Getter
public class OpencartHomePage extends PageObjects {
    @FindBy(xpath = "/html/body/nav/div[2]/div[2]/ul/li[2]/div/a/span")
    public
    WebElement myAccountButton;

    @FindBy(xpath = "/html/body/nav/div[2]/div[2]/ul/li[2]/div/ul/li[2]/a")
    WebElement loginButtonOnHomePage;

    @FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/div[2]/form/div/div[1]/a/img")
    WebElement iphoneItemOnHomePage;

    public OpencartHomePage(WebDriver driver) {
        super(driver);
    }

}

