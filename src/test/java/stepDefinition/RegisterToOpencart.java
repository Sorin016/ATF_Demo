package stepDefinition;

import io.cucumber.java.en.When;
import openCart.LoginPageOpencart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.TreeMap;

import static actions.Actions.*;
import static util.WaitUtils.waitForRetry;

public class RegisterToOpencart extends AbstractStepDef {
    @When("User is click on opencart register button")
    public void user_is_click_on_opencart_register_button() throws InterruptedException {
        click(registerNewUserOpencart.getAccountButtonOnHomePage());
        click(registerNewUserOpencart.getRegisterButonOnHomePage());
    }

    @When("User inserts {} and {} and {} and {}")
    public void user_inserts_the_password_and_login(String firstName, String lastName, String email, String password) throws InterruptedException {
        loginPageOpencart = new LoginPageOpencart(driver);
        sendKey(registerNewUserOpencart.getFirstNameField(), firstName);
        sendKey(registerNewUserOpencart.getLastNameField(), lastName);
        sendKey(registerNewUserOpencart.getEmailField(), email);
        sendKey(registerNewUserOpencart.getPasswordField(), password);
//        isDisplayed(registerNewUserOpencart.getIRead());
        Thread.sleep(3000);
        click(registerNewUserOpencart.getContinueButtonOnRegisterPage());
        Thread.sleep(2000);
//        driver.findElement(By.name("email")).getAttribute("Please fill out this field");
    }
}
