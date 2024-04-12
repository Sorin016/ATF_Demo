package stepDefinition;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static util.DataKey.*;
import static util.ScenarioContext.getData;
import static util.ScenarioContext.saveData;


public class RestAPIStepsDef {
    @When("User navigates to 'Register' page")
    public void navigatesToRegisterPage() {
        baseURI = "https://parabank.parasoft.com";
        given().get("/parabank/register.htm").then().statusCode(SC_OK).log().all();
    }

    @When("User logins with credentials {} and {}")
    public void loginWithCredentialsUsernameAndPassword(String username, String password) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://parabank.parasoft.com/parabank");
        requestSpecification.basePath("/login.htm");
        saveData(API_USERNAME, username);
        saveData(API_PASSWORD, password);
        requestSpecification.formParam("username", username);
        requestSpecification.formParam("password", password);
        Response response = requestSpecification.post();
        response = requestSpecification.auth().basic(getData(API_USERNAME).toString(), getData(API_PASSWORD).toString()).get();
        assertEquals(SC_OK, response.statusCode());
    }

    @When("User with {} open new account from {}")
    public void openNewAccountFromAccountId(int customerId, int accountFrom) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://parabank.parasoft.com/parabank");
        requestSpecification.basePath("/services_proxy/bank/createAccount?customerId=" + customerId + "&newAccountType=0&fromAccountId=" + accountFrom + "");
        Response response = requestSpecification.auth().basic(getData(API_USERNAME).toString(), getData(API_PASSWORD).toString()).get();
        requestSpecification.formParam("customerId", customerId);
        requestSpecification.formParam("newAccountType", 0);
        requestSpecification.formParam("fromAccountId", accountFrom);
        response = requestSpecification.post();
        assertEquals(SC_OK, response.statusCode());
    }

    @When("User sents a transaction from {} to {} with {}")
    public void sentTransactionFromAccountToReiverAccountWithAmount(String account, String reveiverAccount, String amount) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://parabank.parasoft.com/parabank");
        requestSpecification.basePath("/services_proxy/bank/transfer?fromAccountId=" + account + "" + "&toAccountId=" + reveiverAccount + "&amount=" + amount + "");
        Response response = requestSpecification.auth().basic(getData(API_USERNAME).toString(), getData(API_PASSWORD).toString()).get();
        requestSpecification.queryParam("fromAccountId", account);
        requestSpecification.queryParam("toAccountId", reveiverAccount);
        requestSpecification.queryParam("amount", amount);
        response = requestSpecification.post();
        System.out.println("The status received: " + response.getBody().asPrettyString());
        saveData(AMOUNT, amount);
        System.out.println(response.statusLine());
        assertEquals(SC_OK, response.statusCode());
        assertTrue(response.body().asString().contains(account));
    }

    @When("User check the transaction by {} and {}")
    public void selectCheckTheTransactionByAccountAndDate(String acount, String date) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://parabank.parasoft.com/parabank");
        requestSpecification.basePath("/services_proxy/bank/accounts/" + acount + "/transactions/onDate/" + date + "");
        Response response = requestSpecification.auth().basic(getData(API_USERNAME).toString(), getData(API_PASSWORD).toString()).get();
        System.out.println(response.statusLine());
        assertEquals(response.statusCode(), SC_OK);
        assertTrue(response.body().asString().contains(acount));
        assertTrue(response.body().asString().contains(getData(AMOUNT).toString()));
        response.then().log().all();
    }

}


