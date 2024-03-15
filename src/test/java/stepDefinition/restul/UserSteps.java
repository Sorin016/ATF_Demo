package stepDefinition.restul;

import forDataTable.ErrorMessages;
import forDataTable.Store;
import forDataTable.UserInputFields;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinition.important.AbstractStepDef;
import util.ScenarioContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static actions.Actions.*;
import static org.junit.Assert.assertEquals;
import static util.DataKey.PASSWORD;
import static util.DataKey.USERNAME;
import static util.HighlightElement.highlightElement;
import static util.ScenarioContext.*;

public class UserSteps extends AbstractStepDef {
    private Store store;
    private List<UserInputFields> foundUserInputFields;

    @Given("User is on main home page")
    public void user_is_on_main_home_page() {
        isDisplayed(paraBankHomePage.getParaBankLogoOnTheHomePage());
        highlightElement(paraBankHomePage.getParaBankLogoOnTheHomePage(), driver);
    }

    @And("User clicks on 'Register' button")
    public void user_is_clicks_on_Register_button() throws InterruptedException {
        click(paraBankHomePage.getRegisterButtonOnHomePage());
        assertEquals("Signing up is easy!", registerPage.getSighUpIsEasyPhraseOnRegistPage().getText());
    }

    @Then("{} and {} is inserted")
    public void password_and_username_is_inserted(String password, String username) {
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
    public void user_inserts_the_few_fields(DataTable table) throws InterruptedException {
        store = new Store();
        foundUserInputFields = new ArrayList<>();
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
    public void not_all_mandatory_fields_are_inserted_error_appears(DataTable table) {
        store = new Store();
        foundUserInputFields = new ArrayList<>();
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            store.addErrorMessageValues(new ErrorMessages(columns.get("cityIsRequired"), columns.get("stateIsRequired"),
                    columns.get("zipCodeIsRequired"), columns.get("socialSecurityNumberIsRequired")));
            assertEquals(columns.get("cityIsRequired"), registerNewUserErrors.getCityEmptyError().getText());
            assertEquals(columns.get("stateIsRequired"), registerNewUserErrors.getStateEmptyError().getText());
            assertEquals(columns.get("zipCodeIsRequired"), registerNewUserErrors.getZipCodeEmptyError().getText());
            assertEquals(columns.get("socialSecurityNumberIsRequired"), registerNewUserErrors.getSsnEmptyError().getText());
        }
    }

    @Then("User inserts the rest of the mandatory fields")
    public void user_inserts_the_rest_of_the_mandatory_fields(DataTable table) throws InterruptedException {
        store = new Store();
        foundUserInputFields = new ArrayList<>();
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

    @Then("User succesfully register")
    public void user_succesfully_register() {
        assertEquals("Your account was created successfully. You are now logged in.",
                successfulRegistrecion.getAccountCreationWithSuccess().getText());
        String UserName = ScenarioContext.getData(USERNAME).toString();
        assertEquals(successfulRegistrecion.getWlecome().getText(), "Welcome " + UserName);
    }

    @And("User log-out")
    public void user_log_out() throws InterruptedException {
        click(mainMeniu.getLogOut());
        assertEquals("Customer Login", paraBankHomePage.getCustomerLogin().getText());
    }

}
