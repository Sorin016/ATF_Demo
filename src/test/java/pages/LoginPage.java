package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver=null;
    private By login=By.xpath("//*[@id=\"ap_email\"]");
    private By password=By.xpath( "//*[@id=\"ap_password\"]");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void setLogin(String login){
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys(login);
    }
    public void setPassword(String password) {
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(password);
    }
}
