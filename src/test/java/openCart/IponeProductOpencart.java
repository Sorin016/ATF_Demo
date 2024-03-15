package openCart;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.functionalImportantDarVechi.PageObjects;

@Getter
public class IponeProductOpencart extends PageObjects {

    //iphone images start
    @FindBy(xpath = "/html/body/main/div[2]/div/div[1]/div[1]/div[1]/div/a/img")
    WebElement firstIphoneImage;

    @FindBy(xpath = "/html/body/div[2]/div/button[2]")
    WebElement clickNextImage;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/button")
    WebElement closeImage;
    @FindBy(className = "/html/body/main/div[2]/div/div[1]/ul/li[2]/a")
    WebElement reviewButtonssss;
    //iphone images finish
    @FindBy(xpath = "/html/body/main/div[2]/div/div[1]/div[2]/div[2]/form/h2")
    WebElement writeAReviewArea;
    @FindBy(xpath = "/html/body/main/div[2]/div/div[1]/div[2]/div[2]/form/div[2]/input")
    WebElement yourNameFromReviewArea;
    @FindBy(xpath = "/html/body/main/div[2]/div/div[1]/div[2]/div[2]/form/div[3]/textarea")
    WebElement yourReviewFromReviewArea;
    @FindBy(xpath = "/html/body/main/div[2]/div/div[1]/div[2]/div[2]/form/div[4]/div[1]/input[4]")
    WebElement reviewItemReviewArea;
    @FindBy(xpath = "/html/body/main/div[2]/div/div[1]/div[2]/div[2]/form/div[5]/div/button")
    WebElement continueReviewArea;
    @FindBy(xpath = "/html/body/main/div[2]/div/div[1]/div[1]/div[2]/div[1]/form/div/button")
    WebElement addToCartButton;

    public IponeProductOpencart(WebDriver driver) {
        super(driver);
    }
}
