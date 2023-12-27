package pages;

import io.cucumber.core.stepexpression.ExpressionArgument;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPageOpencart extends PageObjects {
    @FindBy(xpath = "/html/body/nav/div[2]/div[2]/ul/li[2]/div/a/span")
    public
    WebElement myAccountButton;

    @FindBy(xpath = "/html/body/nav/div[2]/div[2]/ul/li[2]/div/ul/li[2]/a")
    WebElement loginButtonOnHomePage;

    @FindBy(xpath = "/html/body/main/div[2]/div/div/div/div[2]/div/div/form/div[1]/input")
    WebElement loginField;

    @FindBy(xpath = "/html/body/main/div[2]/div/div/div/div[2]/div/div/form/div[2]/input")
    WebElement passField;

    @FindBy(xpath = "/html/body/main/div[2]/div/div/div/div[2]/div/div/form/button")
    WebElement loginButton;

    @FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/div[2]/form/div/div[1]/a/img")
    WebElement iphoneItemOnHomePage;

    @FindBy(xpath = "//*[@id=\"logo\"]/a/img")
    WebElement opencartLogoFromLoginPage;

    //iphone images start
    @FindBy(xpath = "/html/body/main/div[2]/div/div[1]/div[1]/div[1]/div/a/img")
    WebElement firstIphoneImage;

    @FindBy(xpath = "/html/body/div[2]/div/button[2]")
    WebElement clickNextImage;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/button")
    WebElement closeImage;
    //iphone images finish

    @FindBy(className = "/html/body/main/div[2]/div/div[1]/ul/li[2]/a")
    WebElement reviewButtonssss;

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

    @FindBy (xpath = "/html/body/main/div[2]/div/div[1]/div[1]/div[2]/div[1]/form/div/button")
    WebElement addToCartButton;


    public LoginPageOpencart(WebDriver driver) {
        super(driver);
    }
}
