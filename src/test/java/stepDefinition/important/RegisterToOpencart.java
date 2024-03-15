package stepDefinition.important;

import io.cucumber.java.en.When;
import openCart.LoginPageOpencart;
import org.openqa.selenium.*;

import java.io.IOException;

import static actions.Actions.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static util.DataKey.EMAIL;
import static util.DataKey.PASSWORD;
import static util.HighlightElement.highlightElement;
import static util.ScenarioContext.*;
import static util.WaitUtils.*;


public class RegisterToOpencart extends AbstractStepDef {
    @When("User is click on opencart register button")
    public void user_is_click_on_opencart_register_button() throws InterruptedException {
        click(registerNewUserOpencart.getAccountButtonOnHomePage());
        highlightElement(registerNewUserOpencart.getAccountButtonOnHomePage(),driver);
        Thread.sleep(5000);
        click(registerNewUserOpencart.getRegisterButonOnHomePage());
    }

    @When("User inserts {} and {} and {} and {}")
    public void user_inserts_the_password_and_login(String firstName, String lastName, String email, String password) throws InterruptedException, IOException {
        loginPageOpencart = new LoginPageOpencart(driver);
        sendKey(registerNewUserOpencart.getFirstNameField(), firstName);
        highlightElement(registerNewUserOpencart.getFirstNameField(),driver);
        sendKey(registerNewUserOpencart.getLastNameField(), lastName);
        sendKey(registerNewUserOpencart.getEmailField(), email);
        sendKey(registerNewUserOpencart.getPasswordField(), password);
        waitForRetry(2000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", registerNewUserOpencart.getContinueButtonOnRegisterPage());
        waitForRetry(2000);
        saveData(PASSWORD,password);
    }

    @When("An error message appear that say that {} format is incorect")
    public void an_error_message_appear_that_say_that_format_is_incorect(String email) {
        WebElement invalidInput = driver.findElement(By.cssSelector("input:invalid"));
        assertTrue(invalidInput.isDisplayed());
        String updatedEmail = email.substring(0, 15) + '@' + email.substring(15);
        String password=registerNewUserOpencart.getPasswordField().toString();
        waitForRetry(1000);
        registerNewUserOpencart.getEmailField().clear();
        sendKey(registerNewUserOpencart.getEmailField(), updatedEmail);
        scrollDown(driver);
        saveData(EMAIL,updatedEmail);
    }

    @When("User click on newslatter button and Private Policy checkbox")
    public void user_click_on_newslatter_button_and_Private_Policy_checkbox(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", registerNewUserOpencart.getNewsLetterButton());
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", registerNewUserOpencart.getAgreeButton());
        waitForRetry(2000);
    }

}
