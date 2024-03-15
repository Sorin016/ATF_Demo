package stepDefinition.important;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import openCart.LoginPageOpencart;
import util.WaitUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static actions.Actions.*;
import static org.hamcrest.Matchers.is;
import static util.WaitUtils.waitForRetry;
import static io.restassured.RestAssured.given;


import static org.hamcrest.Matchers.is;

public class LoginToOpencart extends AbstractStepDef {

    @Given("User open the browser to find site")
    public void user_open_the_browser_for_opencart() {
        // log.info("Are equals", homePageUrl, is(driver.getCurrentUrl()));
        Assert.assertThat("Are equals", homePageUrl, is(driver.getCurrentUrl()));
        WaitUtils.waitUnitCondition(driver.getCurrentUrl().equals(homePageUrl), 5);
        Thread.currentThread().getId();
    }

    @When("User is on page home")
    public void user_is_on_home_page() throws IOException {
        isDisplayed(homePage.getHomePageLogoOpencart());
    }

    @When("User is click on opencart login icon")
    public void user_is_click_on_opencart_login_icon() throws InterruptedException {
        loginPageOpencart = new LoginPageOpencart(driver);
        click(opencartHomePage.getMyAccountButton());
        waitForRetry(2000);
        isDisplayed(opencartHomePage.getMyAccountButton());
        click(opencartHomePage.getLoginButtonOnHomePage());
        waitForRetry(2000);
        isDisplayed(opencartHomePage.getLoginButtonOnHomePage());
    }

    @When("User insert {} and {}")
    public void user_insert_the_password_and_login(String password, String login) {
        loginPageOpencart = new LoginPageOpencart(driver);
        sendKey(loginPageOpencart.getLoginField(), login);
        sendKey(loginPage.getPasswordLogin(), password);
        waitForRetry(2000);
    }

    @Then("Login button is clicked and displayed")
    public void login_button_is_displayed_and_clicked() throws InterruptedException {
        isDisplayed(loginPageOpencart.getLoginButton());
        click(loginPageOpencart.getLoginButton());
        waitForRetry(2000);
    }


    @When("Click on the first item")
    public void click_on_the_first_item_API() throws InterruptedException {
        isDisplayed(opencartHomePage.getIphoneItemOnHomePage());
        click(opencartHomePage.getIphoneItemOnHomePage());
    }

    @When("User is redirect to homepage")
    public void user_is_redirect_to_homepage() throws InterruptedException {
        isDisplayed(loginPageOpencart.getOpencartLogoFromLoginPage());
        click(loginPageOpencart.getOpencartLogoFromLoginPage());
    }

    @When("User see the item imeges")
    public void user_see_the_item_imeges() throws InterruptedException {
        isDisplayed(iponeProductOpencart.getFirstIphoneImage());
        click(iponeProductOpencart.getFirstIphoneImage());
        waitForRetry(1000);
        for (int i = 0; i <= 5; i++) {
            click(iponeProductOpencart.getClickNextImage());
            waitForRetry(1000);
        }
        click(iponeProductOpencart.getCloseImage());
    }

    @When("Leave a review from {} for the selected item")
    public void leave_a_review_for_the_selected_item(String login) throws InterruptedException {
        waitForRetry(10000);
        //isDisplayed(loginPageOpencart.getReviewButtonssss());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3500)", "");
        click(iponeProductOpencart.getReviewButtonssss());
//        isDisplayed(loginPageOpencart.getWriteAReviewArea());
//        click(loginPageOpencart.getYourNameFromReviewArea());
//        sendKey(loginPageOpencart.getYourNameFromReviewArea(),login);
//        click(loginPageOpencart.getYourReviewFromReviewArea());
//        sendKey(loginPageOpencart.getYourReviewFromReviewArea(),"acest produs contine plasare de reclama");
//        click(loginPageOpencart.getReviewItemReviewArea());
//        click(loginPageOpencart.getContinueReviewArea());
    }

    @When("Add the item in cart")
    public void add_the_item_in_cart() throws InterruptedException {
        RestAssured.baseURI = "https://demo.opencart.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/index.php?route=product/product&language=en-gb&product_id=40");
        ResponseBody body = response.getBody();
        String bodyAsString = body.prettyPrint();
        System.out.println(bodyAsString);
        response.then().statusCode(200);
        Assert.assertEquals(String.valueOf(bodyAsString.contains("Success: You have added")), "Success: You have added", "Success: You have added");
    }

}