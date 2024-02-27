package pages.FunctionalImportantDarVechi;

import org.openqa.selenium.WebDriver;

public class linkOfThewebsite {
    public final String LINK_TO_THE_PAGE="https://www.google.com/";
    WebDriver driver;
    public linkOfThewebsite(WebDriver driver){
        this.driver=driver;
    }
    public void linkToThePage(){
        driver.navigate().to("https://www.google.com/");
    }
}

