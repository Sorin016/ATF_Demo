package pages.FunctionalImportantDarVechi;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Getter
public class SearchForMensShoes extends PageObjects{

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[3]/div/h1")
    WebElement menShoesText;

    @FindBy(xpath = "//*[@id=\"searchFilters\"]/div[1]/div[2]/section[2]/div[2]/ul/li[18]/a")
    WebElement menShoesSize;

    @FindBy(xpath = "//*[@id=\"searchFilters\"]/div[1]/div[2]/section[5]/div[2]/ul/li[1]/a")
    WebElement menShoesColor;

    @FindBy(xpath = "//*[@id=\"searchFilters\"]/div[1]/div[2]/section[6]/div[2]/ul/li[4]/a")
    WebElement menShoesPrice;

    @FindBy(id = "searchAll")
    WebElement serchAllTab;

    @FindBy(xpath = "//*[@id=\"searchForm\"]/button")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[3]/div/h1")
    WebElement mensShoesLogo;

    @FindBy(xpath = "//*[@id=\"products\"]/article[3]/a")
    WebElement theSelectedItemToBuy;

    @FindBy(xpath = "//*[@id=\"buyBoxForm\"]/div[2]/fieldset[1]/div/div[1]")
    WebElement theSizeInsideTheItemDescription;


    public SearchForMensShoes(WebDriver driver) {
        super(driver);
    }
}
