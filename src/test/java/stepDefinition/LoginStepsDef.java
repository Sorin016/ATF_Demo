package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.LoginPage;
import util.WaitUtils;


//import static net.bytebuddy.matcher.ElementMatchers.is;
import static actions.Actions.click;
import static actions.Actions.sendKey;
import static org.hamcrest.Matchers.is;
import static util.WaitUtils.waitForRetry;

@Log4j2
public class LoginStepsDef extends AbstractStepDef {

    LoginPage loginPage;

    @Given("User open the browser")
    public void user_open_the_browser() {
        log.info("Are equals", homePageUrl, is(driver.getCurrentUrl()));
        Assert.assertThat("Are equals", homePageUrl, is(driver.getCurrentUrl()));
        WaitUtils.waitUnitCondition(driver.getCurrentUrl().equals(homePageUrl), 5);
        Thread.currentThread().getId();
    }

    @When("User is searching for website")
    public void user_is_on_the_login_page() {
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

    @When("User is on home page")
    public void user_is_on_home_page() {
        driver.findElement(By.xpath(
                "//*[@id=\"root\"]/div[1]/header/div[1]/a/picture/img")).isDisplayed();
    }

    @When("User is click on login icon")
    public void user_is_click_on_login_icon() throws InterruptedException {
        driver.findElement(By.xpath(
                "//*[@id=\"root\"]/div[1]/header/div[1]/div[3]/div[1]/a")).click();

        waitForRetry(200);
        driver.findElement(By.xpath(
                "//*[@id=\"authportal-main-section\"]/div[2]/div/div/form/div/div/div/h1")).isDisplayed();
    }

    @When("User insert the {} and {}")
    public void user_insert_the_password_and_login(String password, String login) {
//            driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("samsungG900");
//            driver.findElement(By.id("ap_email")).sendKeys("sorin.cucereavu@mail.ru");
//            driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
//        loginPage=new LoginPage(driver);
//        driver.findElement(loginPage.getLogin().sendKeys(login);
//        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(password);
//        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
        loginPage =new LoginPage(driver);
        sendKey(loginPage.getLogin(), login);
        sendKey(loginPage.getPasswordLogin(), password);
        waitForRetry(2000);
    }

    @Then("Login button is displayed and clicked")
    public void login_button_is_displayed_and_clicked() throws InterruptedException {
        click(loginPage.getSubmitButton());
        waitForRetry(2000);
    }
}