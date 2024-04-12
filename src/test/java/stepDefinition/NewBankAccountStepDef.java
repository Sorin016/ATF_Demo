package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;


import static actions.Actions.*;
import static org.junit.Assert.assertEquals;
import static util.DataKey.*;
import static util.HighlightElement.highlightElement;
import static util.ScenarioContext.getData;
import static util.ScenarioContext.saveData;
import static util.WaitUtils.waitForRetry;

public class NewBankAccountStepDef extends AbstractStepDef {
    final static int TIME = 2000;
  
   @Given("User login with valid credentials {} and {}")
    public void loginWithValidCredentialsPassAndLog(String pass, String login) throws InterruptedException {
        isDisplayed(paraBankHomePage.getParaBankLogoOnTheHomePage());
        highlightElement(paraBankHomePage.getParaBankLogoOnTheHomePage(), driver);
        highlightElement(paraBankHomePage.getUserNameLogin(), driver);
        highlightElement(paraBankHomePage.getPasswordLogin(), driver);
        sendKey(paraBankHomePage.getUserNameLogin(), login);
        sendKey(paraBankHomePage.getPasswordLogin(), pass);
        click(paraBankHomePage.getLoginButton());
        assertEquals("Account Services", mainMeniuPage.getAccountServices().getText());
    }

    @When("User clicks on 'Open new accout'")
    public void clickOnOpenNewAccout() throws InterruptedException {
        highlightElement(mainMeniuPage.getOpenNewAccount(), driver);
        click(mainMeniuPage.getOpenNewAccount());
        assertEquals("Open New Account", mainMeniuPage.getOpenNewAccount().getText());
    }


    @When("User selects {} of account")
    public void selectTypeOfAccount(String type) throws InterruptedException {
        highlightElement(openNewAccountPage.getType(), driver);
        click(openNewAccountPage.getType());
        if (type.equals("CHECKING")) {
            click(openNewAccountPage.getCheckingAccount());
            saveData(CHECKING, openNewAccountPage.getCheckingAccount().getText());
        } else {
            click(openNewAccountPage.getSavingsAccount());
            saveData(SAVINGS, openNewAccountPage.getSavingsAccount().getText());
        }
        saveData(DEFAULT_ACCOUNT_ID, openNewAccountPage.getDefauldAccountID().getText());
        click(openNewAccountPage.getOpenNewAccountButton());
        waitForRetry(TIME);
        assertEquals("Account Opened!", openNewAccountPage.getAccountOpened().getText());
        assertEquals("Your new account number:", openNewAccountPage.getYourAccountNumberText().getText());
        saveData(NEW_ACCOUNT_ID, openNewAccountPage.getNewAccountID().getText());
    }

    @When("User opens new account details")
    public void openNewAccountDetails() throws InterruptedException {
        click(openNewAccountPage.getNewAccountID());
        highlightElement(accountDetailsPage.getAccountDetailsText(), driver);
        waitForRetry(TIME);
        assertEquals(getData(NEW_ACCOUNT_ID), accountDetailsPage.getAccountId().getText());
        if (accountDetailsPage.getAccountType().getText().equals(getData(SAVINGS))) {
            log.info("SAVINGS");
        } else log.info("CHECKING");
        log.info("New account id is " + accountDetailsPage.getAccountId().getText() +
                " New account type is " + accountDetailsPage.getAccountType().getText());
    }

    @When("Using new account transfer {} to another amount")
    public void usingNewAccountTransferAmountToAnotherAmount(String amount) throws InterruptedException {
        saveData(TRANSACTION_AMMOUNT, amount);
        click(mainMeniuPage.getTransferFunds());
        waitForRetry(TIME);
        highlightElement(mainMeniuPage.getTransferFunds(), driver);
        sendKey(transferFundsPage.getTransferFundsAmount(), amount);
        click(transferFundsPage.getFromAccountId());
        sendKey(transferFundsPage.getFromAccountId(), getData(DEFAULT_ACCOUNT_ID).toString());
        waitForRetry(TIME);
        click(transferFundsPage.getToAccountId());
        sendKey(transferFundsPage.getToAccountId(), getData(NEW_ACCOUNT_ID).toString());
        click(transferFundsPage.getTransferButton());
        log.info("from account " + getData(DEFAULT_ACCOUNT_ID).toString() +
                " to account " + getData(NEW_ACCOUNT_ID).toString());
    }


    @Then("User navigates and check that transfer was with success")
    public void navigateAndCheckThatTransferWasWithSuccess() throws InterruptedException {
        click(mainMeniuPage.getAccountsOverview());
        highlightElement(accountsOverviewPage.getAccountOverviewText(), driver);
        isDisplayed(accountDetailsPage.getAccountsTable());
        String newAccountId = getData(NEW_ACCOUNT_ID).toString();
        String transactionAmmount = getData(TRANSACTION_AMMOUNT).toString();
        waitForRetry(TIME);
        driver.findElement(By.xpath("//a[contains(text(),'" + newAccountId + "')]")).click();
        waitForRetry(TIME);
//        String link = "//a[contains(text(),".concat(getData(NEW_ACCOUNT_ID).toString());
//        List<WebElement> elems = (List<WebElement>) accountsOverviewPage.getAccountTable();
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

        if (accountDetailsPage.getTransactionsType().getText().contains("Funds Transfer Received") &&
                accountDetailsPage.getTransactionsType().getText().contains(transactionAmmount))
            log.info("Transaction is available in the table");
    }
}
