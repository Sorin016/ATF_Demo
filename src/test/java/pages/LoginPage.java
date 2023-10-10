package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
     WebDriver driver;
     //By logins=By.id("\"ap_email\"");
    // By passwordLogin=By.xpath( "//*[@id=\"ap_password\"]");

    @FindBy(id = "\"ap_email\"")
    WebElement logins;

    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    WebElement passwordLogin;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void setLogin(String login){
        logins.sendKeys(login);
    }
    public void setPassword(String password) {
       passwordLogin.sendKeys(password);
    }

}
