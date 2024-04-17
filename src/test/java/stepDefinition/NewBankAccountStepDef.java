package stepDefinition;

import forDataTable.BillPay;
import forDataTable.Store;
import forDataTable.UserInputFields;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.ElementHighlight;


import java.util.Collections;
import java.util.List;
import java.util.Map;

import static actions.Actions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static util.DataKey.*;
import static util.HighlightElement.highlightElement;
import static util.ScenarioContext.getData;
import static util.ScenarioContext.saveData;
import static util.WaitUtils.waitForRetry;

public class NewBankAccountStepDef extends AbstractStepDef {
    final static int TIME = 2000;
    private Store store;

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

    @When("User clicks on {}")
    public void clickOnOpenNewAccout(String type) throws InterruptedException {
        if (type.contains("Register")) {
            click(paraBankHomePage.getRegisterButtonOnHomePage());
            assertEquals("Signing up is easy!", registerPage.getSighUpIsEasyPhraseOnRegistPage().getText());
        } else if (type.contains("Open new accout")) {
            highlightElement(mainMeniuPage.getOpenNewAccount(), driver);
            click(mainMeniuPage.getOpenNewAccount());
            assertEquals("Open New Account", mainMeniuPage.getOpenNewAccount().getText());
        } else if (type.contains("Bill Pay")) {
            highlightElement(mainMeniuPage.getBillPay(), driver);
            click(mainMeniuPage.getBillPay());
            assertEquals("Bill Payment Service", billPaymentPage.getBillPaymentText().getText());
            saveData(FROM_ACCOUNT_ID_BILL_PAY, billPaymentPage.getBillpayeeFromAccountId().getText().trim());
        }
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


    @Then("User navigates and check that {} was with success")
    public void navigateAndCheckThatEventWasWithSuccess(String eventType) throws InterruptedException {
        click(mainMeniuPage.getAccountsOverview());
        highlightElement(accountsOverviewPage.getAccountOverviewText(), driver);
        isDisplayed(accountDetailsPage.getAccountsTable());
        if (eventType.contains("transfer")) {
            String newAccountId = getData(NEW_ACCOUNT_ID).toString();
            String transactionAmmount = getData(TRANSACTION_AMMOUNT).toString();
            waitForRetry(TIME);
            driver.findElement(By.xpath("//a[contains(text(),'" + newAccountId + "')]")).click();
            waitForRetry(TIME);
            if (accountDetailsPage.getTransactionsType().getText().contains("Funds Transfer Received") &&
                    accountDetailsPage.getTransactionsType().getText().contains(transactionAmmount))
                log.info("Transaction is available in the table");
        } else if (eventType.contains("bill pay")) {
            waitForRetry(TIME);
//            driver.findElement(By.xpath("//a[contains(text(),'" + getData(FROM_ACCOUNT_ID_BILL_PAY).toString() + "')]")).click();
            clickK("//a[contains(text(),'" + getData(FROM_ACCOUNT_ID_BILL_PAY).toString() + "')]");
            waitForRetry(TIME);
            if (accountDetailsPage.getTransactionsType().getText().contains("Bill Payment to"))
                log.info("Bill Payment is available in the table");
        }
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
    }


    @Then("User inserts the mandatory fields")
    public void insertsTheMandatoryFields(DataTable table) throws InterruptedException {
        store = new Store();
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            store.addAllFieldsForBillPay(new BillPay(columns.get("payeeName"), columns.get("address"), columns.get("city"), columns.get("state"),
                    columns.get("zipCode"), columns.get("phone"), columns.get("account"), columns.get("verifyAccount"), columns.get("amount")));
            sendKey(billPaymentPage.getBillPayeeNameField(), columns.get("payeeName"));
            sendKey(billPaymentPage.getBillPayeeAddressField(), columns.get("address"));
            sendKey(billPaymentPage.getBillPayeeCityField(), columns.get("city"));
            sendKey(billPaymentPage.getBillpayeeStateField(), columns.get("state"));
            sendKey(billPaymentPage.getBillPayeeZipCodeField(), columns.get("zipCode"));
            sendKey(billPaymentPage.getBillPayeePhoneField(), columns.get("phone"));
            sendKey(billPaymentPage.getBillPayeeAccountNumberField(), columns.get("account"));
            sendKey(billPaymentPage.getBillPayeeVerifyAccountNumberField(), columns.get("verifyAccount"));
            sendKey(billPaymentPage.getBillPayeeAmount(), columns.get("amount"));
            click(billPaymentPage.getBillpayeeSendPaymentButton());
            waitForRetry(TIME);
            ElementHighlight elementHighlight = (element, driver) -> {
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border: 3px solid red;');", element);
            };
            elementHighlight.highlightElement(billPaymentCompletePage.getBillPaymentCompleteText(), driver);
            elementHighlight.highlightElement(billPaymentCompletePage.getBillPaymentFromAccount(), driver);
            elementHighlight.highlightElement(billPaymentCompletePage.getBillPaymentFromAmount(), driver);
            assertEquals(billPaymentCompletePage.getBillPaymentFromAmount().getText(), "$" + columns.get("amount"));
            assertTrue(billPaymentCompletePage.getBillPaymentFromAccount().getText(),
                    getData(FROM_ACCOUNT_ID_BILL_PAY).toString().contains(billPaymentCompletePage.getBillPaymentFromAccount().getText()));
        }
    }
}
