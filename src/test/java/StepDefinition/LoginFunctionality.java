package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;


public class LoginFunctionality {
    WebDriver driver=null;
    LoginPage logins=new LoginPage(driver);


    @Given("User open the browser")
    public void user_open_the_browser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
        }

    @When("user is searching for website")
    public void user_is_on_the_login_page() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).isDisplayed();
        System.out.println(1);
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("6pm");
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);

        System.out.println(2);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/div/span/a/h3")).isDisplayed();
        System.out.println(3);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();
        System.out.println(4);

    }
    @And("user is on home page")
    public void user_is_on_home_page(){
       if( driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div[1]/a/picture/img")).isDisplayed());
        System.out.println("correct");
    }

    @And("user is click on login icon")
    public void user_is_click_on_login_icon() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/header/div[1]/div[3]/div[1]/a")).click();

        Thread.sleep(2000);
        //sigh in present
        driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/form/div/div/div/h1")).isDisplayed();
    }

    @And("user insert the {} and {}")
    public void user_insert_the_password_and_login(String password,String login) throws InterruptedException {
        logins.setLogin(login);
        logins.setPassword(password);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).sendKeys(Keys.ENTER);
    }


    @Then("login button is displayed")
    public void login_button_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
    driver.close();
    driver.quit();
    }
}