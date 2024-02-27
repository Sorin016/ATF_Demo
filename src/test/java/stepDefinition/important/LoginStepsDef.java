package stepDefinition.important;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import pages.functionalImportantDarVechi.GoogleSearchForWebsite;
import pages.functionalImportantDarVechi.LoginPage;
import util.PropretyLoader;
import util.ScenarioContext;
import util.WaitUtils;
import  static io.restassured.RestAssured.*;
import static actions.Actions.*;
import static org.hamcrest.Matchers.is;
import static rest.ApiEndpoint.*;
import static util.DataKey.EMAIL;
import static util.DataKey.PASSWORD;
import static util.WaitUtils.waitForRetry;
import static org.apache.http.HttpStatus.*;
import static io.restassured.RestAssured.given;


@Log4j2
public class LoginStepsDef extends AbstractStepDef {

    LoginPage loginPage;
    GoogleSearchForWebsite googleSearchForWebsite;

    LoginToOpencart loginToOpencart;
    static final String prop= PropretyLoader.loadProperty("homePage6PMApi");

    @Given("User open the browser")
    public void user_open_the_browser() {
        log.info("Are equals", homePageUrl, is(driver.getCurrentUrl()));
        Assert.assertThat("Are equals", homePageUrl, is(driver.getCurrentUrl()));
        WaitUtils.waitUnitCondition(driver.getCurrentUrl().equals(homePageUrl), 5);
        Thread.currentThread().getId();
    }

    @When("User is searching for website")
    public void user_is_on_the_login_page() throws InterruptedException {
        googleSearchForWebsite = new GoogleSearchForWebsite(driver);
        isDisplayed(googleSearchForWebsite.getWebsiteIsPresenOnGoogleSearch());
        sendKey(googleSearchForWebsite.getWebsiteIsPresenOnGoogleSearch(), "6pm");

        driver.findElement(By.xpath(
                "//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);

//        sendKey(googleSearchForWebsite.getSada());
        waitForRetry(2000);
        isDisplayed(googleSearchForWebsite.getWebsiteIsPresenOnGoogleSearch());
        click(googleSearchForWebsite.getWebsiteIsPresenOnGoogleSearchAfterSerching());
    }

    @When("User is on home page")
    public void user_is_on_home_page() {
        isDisplayed(homePage.getHomePageLogo());
    }

    @When("User is click on login icon")
    public void user_is_click_on_login_icon() throws InterruptedException {
        loginPage = new LoginPage(driver);
        scrollUp(driver);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", homePage.getHomePageLogoOpencart());
    }

    @When("User insert the {} and {}")
    public void user_insert_the_password_and_login(String password, String login) {
        loginPage = new LoginPage(driver);
        sendKey(loginPage.getLogin(), login);
        sendKey(loginPage.getPasswordLogin(), password);
        waitForRetry(2000);
    }

    @Then("Login button is displayed and clicked")
    public void login_button_is_displayed_and_clicked() throws InterruptedException {
        click(loginPage.getSubmitButton());
        waitForRetry(2000);
    }
    @When("User populate the {} with correct {}")
    public void user_populate_with_correct_values(String field, String value) {
        loginPage = new LoginPage(driver);
        if (field.equals("login")) {
            sendKey(loginPage.getLogin(), value);
            waitForRetry(2000);
        } else {
            sendKey(loginPage.getPasswordLogin(), value);
            waitForRetry(2000);
        }
    }

    @When("User populate the {} with wrong {}")
    public void user_populate_the_wrong_value(String field, String value) {
        loginPage = new LoginPage(driver);
        if (field.equals("password")) {
            sendKey(loginPage.getLogin(), value);
            waitForRetry(2000);
        } else {
            sendKey(loginPage.getPasswordLogin(), value);
            waitForRetry(2000);
        }
    }
    @When("The error message appears")
    public void the_error_message_appears() {
        waitForRetry(2000);
        Assert.
                assertEquals(errorLoginPage.getInvalidPassword().
                        getText(), "Your password is incorrect");
        log.info(" mesajul a fost true");
    }
    @Test
    @When("User navigate to the home page")
    public void user_navigate_to_the_home_page_API(){
        baseURI="https://www.6pm.com/";
        given().get("/c/bags").then().statusCode(200)
                .log().all();
    }
@Test
    @When("User navigate to login page and login")
    public void user_navigate_to_login_page_and_login_API(){
        given().
                get(prop+SHOES).
                then().
                statusCode(SC_OK);
    }
    @When("User was redirect from login page to homepage")
    public void  User_was_redirect_from_login_page_to_homepage(){

    }


    @When("Select the item and add the item to the cart")
    public void Select_the_item_and_add_the_item_to_the_cart_API(){

    }



    @When("User enter the pass and log")
    public void user_enter_the_password_and_login() {
        loginPage = new LoginPage(driver);
        String login=ScenarioContext.getData(EMAIL).toString();
        String password=ScenarioContext.getData(PASSWORD).toString();
        sendKey(registerNewUserOpencart.getEmailField(), login);
        sendKey(registerNewUserOpencart.getPasswordField(),password);
        waitForRetry(2000);
    }
}