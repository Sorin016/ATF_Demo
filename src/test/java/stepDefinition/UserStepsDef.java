package stepDefinition;

import forDataTable.ErrorMessages;
import forDataTable.Store;
import forDataTable.UserInputFields;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import util.ScenarioContext;

import java.util.List;
import java.util.Map;

import static actions.Actions.*;
import static org.junit.Assert.assertEquals;
import static util.DataKey.PASSWORD;
import static util.DataKey.USERNAME;
import static util.HighlightElement.highlightElement;
import static util.ScenarioContext.*;

public class UserStepsDef extends AbstractStepDef {
    private Store store;

    @Given("User is on main home page")
    public void displaingMainHomePage() {
        isDisplayed(paraBankHomePage.getParaBankLogoOnTheHomePage());
        highlightElement(paraBankHomePage.getParaBankLogoOnTheHomePage(), driver);
    }

    @Then("{} and {} is inserted")
    public void insertPasswordAndUsername(String password, String username) {
        highlightElement(registerPage.getUserName(), driver);
        highlightElement(registerPage.getPassword(), driver);
        highlightElement(registerPage.getConfirmedPassword(), driver);
        saveData(USERNAME, username);
        saveData(PASSWORD, password);
        sendKey(registerPage.getUserName(), username);
        sendKey(registerPage.getPassword(), password);
        sendKey(registerPage.getConfirmedPassword(), password);
    }

    @Then("User inserts the few fields")
    public void insertTheFewFields(DataTable table) throws InterruptedException {
        store = new Store();
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            store.addInputFieldsValue(new UserInputFields(columns.get("lastName"), columns.get("address"), columns.get("city"), columns.get("state"),
                    columns.get("zipCode"), columns.get("phone"), columns.get("ssn")));
            highlightElement(registerPage.getFirstName(), driver);
            highlightElement(registerPage.getLastName(), driver);
            highlightElement(registerPage.getAddress(), driver);
            highlightElement(registerPage.getCity(), driver);
            highlightElement(registerPage.getState(), driver);
            highlightElement(registerPage.getZipCode(), driver);
            highlightElement(registerPage.getPhone(), driver);
            highlightElement(registerPage.getSsn(), driver);
            String userName = getData(USERNAME).toString();
            sendKey(registerPage.getFirstName(), userName);
            sendKey(registerPage.getLastName(), columns.get("lastName"));
            sendKey(registerPage.getAddress(), columns.get("address"));
            click(registerPage.getRegisterButton());
            assertEquals("Signing up is easy!", registerPage.getSighUpIsEasyPhraseOnRegistPage().getText());
        }
    }

    @And("Not all mandatory fields are inserted error appears")
    public void displaingNotAllMandatoryFieldsAreInsertedError(DataTable table) {
        store = new Store();
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            store.addErrorMessageValues(new ErrorMessages(columns.get("cityIsRequired"), columns.get("stateIsRequired"),
                    columns.get("zipCodeIsRequired"), columns.get("socialSecurityNumberIsRequired")));
            assertEquals(columns.get("cityIsRequired"), registerNewUserErrorsPage.getCityEmptyError().getText());
            assertEquals(columns.get("stateIsRequired"), registerNewUserErrorsPage.getStateEmptyError().getText());
            assertEquals(columns.get("zipCodeIsRequired"), registerNewUserErrorsPage.getZipCodeEmptyError().getText());
            assertEquals(columns.get("socialSecurityNumberIsRequired"), registerNewUserErrorsPage.getSsnEmptyError().getText());
        }
    }

    @Then("User inserts the rest of the mandatory fields")
    public void insertsTheRestOfTheMandatoryFields(DataTable table) throws InterruptedException {
        store = new Store();
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            store.addInputFieldsValue(new UserInputFields(columns.get("lastName"), columns.get("address"), columns.get("city"), columns.get("state"),
                    columns.get("zipCode"), columns.get("phone"), columns.get("ssn")));
            sendKey(registerPage.getCity(), columns.get("city"));
            sendKey(registerPage.getState(), columns.get("state"));
            sendKey(registerPage.getZipCode(), columns.get("zipCode"));
            sendKey(registerPage.getPhone(), columns.get("phone"));
            sendKey(registerPage.getSsn(), columns.get("ssn"));
            String password = getData(PASSWORD).toString();
            sendKey(registerPage.getPassword(), password);
            sendKey(registerPage.getConfirmedPassword(), password);
            click(registerPage.getRegisterButton());
        }
    }

    @Then("User registers with {}")
    public void  registerNewUser(String result) {
        if(result.contains("success")){
        assertEquals("Your account was created successfully. You are now logged in.",
                successfulRegistrecionPage.getAccountCreationWithSuccess().getText());
        String UserName = ScenarioContext.getData(USERNAME).toString();
        assertEquals(successfulRegistrecionPage.getWlecome().getText(), "Welcome " + UserName);
    }
        else {
            assertEquals("This username already exists.",
                    registerNewUserErrorsPage.getDublicateUserErrorMessage().getText());
            highlightElement(registerNewUserErrorsPage.getDublicateUserErrorMessage(),driver);
        }
    }


    @Then("User log-out")
    public void logOut() throws InterruptedException {
        click(mainMeniuPage.getLogOut());
        assertEquals("Customer Login", paraBankHomePage.getCustomerLogin().getText());
    }

}
