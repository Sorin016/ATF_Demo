package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.WaitUtils;

@Getter
public class SearchForMensShoes extends PageObjects{
    @Getter
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[3]/div/h1")
    WebElement MenShoesText;

    @FindBy(xpath = "//*[@id=\"searchFilters\"]/div[1]/div[2]/section[2]/div[2]/ul/li[18]/a")
    WebElement MenShoesSize;


    public SearchForMensShoes(WebDriver driver) {
        super(driver);
    }
}
