package stepDefinition.restul;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import stepDefinition.important.AbstractStepDef;

import static actions.Actions.*;
import static org.junit.Assert.assertEquals;
import static util.DataKey.*;
import static util.HighlightElement.highlightElement;
import static util.ScenarioContext.getData;
import static util.ScenarioContext.saveData;
import static util.WaitUtils.waitForRetry;

public class NewBankAccount extends AbstractStepDef {

    @Given("User login with valid credentials {} and {}")
    public void user_login_with_valid_credentials_pass_and_log(String pass, String login) throws InterruptedException {
        isDisplayed(paraBankHomePage.getParaBankLogoOnTheHomePage());
        highlightElement(paraBankHomePage.getParaBankLogoOnTheHomePage(), driver);
        highlightElement(paraBankHomePage.getUserNameLogin(), driver);
        highlightElement(paraBankHomePage.getPasswordLogin(), driver);
        sendKey(paraBankHomePage.getUserNameLogin(), login);
        sendKey(paraBankHomePage.getPasswordLogin(), pass);
        click(paraBankHomePage.getLoginButton());
        assertEquals("Account Services", mainMeniu.getAccountServices().getText());
    }

    @When("User clicks on 'Open new accout'")
    public void user_clicks_on_Open_new_accout() throws InterruptedException {
        highlightElement(mainMeniu.getOpenNewAccount(), driver);
        click(mainMeniu.getOpenNewAccount());
        assertEquals("Open New Account", mainMeniu.getOpenNewAccount().getText());
    }

    @When("User select {} of account")
    public void user_select_type_of_account(String type) throws InterruptedException {
        highlightElement(openNewAccount.getType(), driver);
        click(openNewAccount.getType());
        if (type.equals("CHECKING")) {
            click(openNewAccount.getCheckingAccount());
            saveData(CHECKING, openNewAccount.getCheckingAccount().getText());
        } else {
            click(openNewAccount.getSavingsAccount());
            saveData(SAVINGS, openNewAccount.getSavingsAccount().getText());
        }
        saveData(DEFAULT_ACCOUNT_ID, openNewAccount.getDefauldAccountID().getText());
        click(openNewAccount.getOpenNewAccountButton());
        waitForRetry(2000);
        assertEquals("Account Opened!", openNewAccount.getAccountOpened().getText());
        assertEquals("Your new account number:", openNewAccount.getYourAccountNumberText().getText());
        saveData(NEW_ACCOUNT_ID, openNewAccount.getNewAccountID().getText());
    }

    @When("User open new account details")
    public void user_open_new_account_details() throws InterruptedException {
        click(openNewAccount.getNewAccountID());
        highlightElement(accountDetails.getAccountDetailsText(), driver);
        waitForRetry(2000);
        assertEquals(getData(NEW_ACCOUNT_ID), accountDetails.getAccountId().getText());
        assertEquals(getData(SAVINGS), accountDetails.getAccountType().getText());
        log.info("New account id is " + accountDetails.getAccountId().getText() +
                " New account type is " + accountDetails.getAccountType().getText());
    }

    @When("Using new account transfer {} to another amount")
    public void using_new_account_transfer_amount_to_another_amount(String amount) throws InterruptedException {
        click(mainMeniu.getTransferFunds());
        waitForRetry(2000);
        highlightElement(mainMeniu.getTransferFunds(), driver);
        sendKey(transferFunds.getTransferFundsAmount(), amount);
        click(transferFunds.getFromAccountId());
        sendKey(transferFunds.getFromAccountId(), getData(DEFAULT_ACCOUNT_ID).toString());
        waitForRetry(1000);
        click(transferFunds.getToAccountId());
        sendKey(transferFunds.getToAccountId(), getData(NEW_ACCOUNT_ID).toString());
        click(transferFunds.getTransferButton());
        log.info("from account " + getData(DEFAULT_ACCOUNT_ID).toString() +
                " to account " + getData(NEW_ACCOUNT_ID).toString());
    }

    @Then("User navigate and check that transfer was with success")
    public void user_navigate_and_check_that_transfer_was_with_success() throws InterruptedException {
        click(mainMeniu.getAccountsOverview());
        highlightElement(accountsOverview.getAccountOverviewText(), driver);
        isDisplayed(accountDetails.getAccountsTable());
        String link = "//a[contains(text(),".concat(getData(NEW_ACCOUNT_ID).toString());
//        List<WebElement> elems = accountsOverview.getAccountTable();
//        for (WebElement rowElem : elems)
//        {
//            if(rowElem.getText().contains(getData(NEW_ACCOUNT_ID).toString()))
//            {
//                waitForRetry(5000);
//               driver.findElement(By.xpath("//table[@id='accountTable']/tbody/tr[1]/td[1]")).click();
//                waitForRetry(5000);
//               log.info("ESTEEEEEEEEEEEEEEEEEEEEEEEEEEE");
//            }
//            else
//                log.info("NIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
//        }
    }
}
