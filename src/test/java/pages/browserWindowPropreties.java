package pages;

import org.openqa.selenium.WebDriver;

public class browserWindowPropreties {
    WebDriver driver;
    public browserWindowPropreties(WebDriver driver){
        this.driver=driver;
    }
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }
    public void closeBrowser(){
        driver.close();
    }
    public void quitBrowser(){
        driver.quit();
    }
}
