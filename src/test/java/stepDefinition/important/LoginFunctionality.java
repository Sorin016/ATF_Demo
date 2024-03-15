package stepDefinition.important;

import actions.Actions;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import static util.WaitUtils.waitForRetry;


public class LoginFunctionality extends AbstractStepDef {

//    @Given("User open the browser")
//    public void user_open_the_browser() {
////        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
////        driver=new ChromeDriver();
//        driver.navigate().to("https://www.google.com/");
////        driver.manage().window().maximize();
////       browserWindowPropretiess.maximizeWindow();
//    }

    @When("user is searching for website")
    public void user_is_on_the_login_page(){
        driver.findElement(By.xpath(
                "//*[@id=\"APjFqb\"]")).isDisplayed();
        driver.findElement(By.xpath(
                "//*[@id=\"APjFqb\"]")).sendKeys("6pm");
        driver.findElement(By.xpath(
                "//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);
        waitForRetry(2000);
        driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/div/span/a/h3")).isDisplayed();
        driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();
    }

    @When("user is on home page")
    public void user_is_on_home_page() {
        driver.findElement(By.xpath(
                "//*[@id=\"root\"]/div[1]/header/div[1]/a/picture/img")).isDisplayed() ;

    }

    @When("user is click on login icon")
    public void user_is_click_on_login_icon() throws InterruptedException {
        driver.findElement(By.xpath(
                "//*[@id=\"root\"]/div[1]/header/div[1]/div[3]/div[1]/a")).click();
        waitForRetry(2000);
        driver.findElement(By.xpath(
                "//*[@id=\"authportal-main-section\"]/div[2]/div/div/form/div/div/div/h1")).isDisplayed();
    }

    @When("user insert the {} and {}")
    public void user_insert_the_password_and_login(String password, String login) throws InterruptedException {
        // intrebare de ce daca creezi obiectul logins inafara metodei, si o faci globala nu merge programul iar daca o initializezi aici in metoda merge
        Actions.sendKey(loginPage.getLogin(),login);
        Actions.sendKey(loginPage.getPasswordLogin(),password);
    }
}