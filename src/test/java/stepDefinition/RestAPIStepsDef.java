package stepDefinition;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static stepDefinition.AbstractStepDef.homePageUrlForAPI;
import static util.DataKey.*;
import static util.ScenarioContext.getData;
import static util.ScenarioContext.saveData;


public class RestAPIStepsDef {
    public final static String BASE_URI = homePageUrlForAPI;
    public final static String TEST_DATA = "test";

    @When("User navigates to 'Register' page")
    public void navigatesToRegisterPage() {
        baseURI = BASE_URI;
        given().get("/register.htm").then().statusCode(SC_OK).log().all();
    }

    @When("User logins with credentials {} and {}")
    public void loginWithCredentialsUsernameAndPassword(String username, String password) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri(BASE_URI);
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
        requestSpecification.baseUri(BASE_URI);
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
        requestSpecification.baseUri(BASE_URI);
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

    @When("User checks the transaction by {} and {}")
    public void selectCheckTheTransactionByAccountAndDate(String acount, String date) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri(BASE_URI);
        requestSpecification.basePath("/services_proxy/bank/accounts/" + acount + "/transactions/onDate/" + date + "");
        Response response = requestSpecification.auth().basic(getData(API_USERNAME).toString(), getData(API_PASSWORD).toString()).get();
        System.out.println(response.statusLine());
        assertEquals(response.statusCode(), SC_OK);
        assertTrue(response.body().asString().contains(acount));
        assertTrue(response.body().asString().contains(getData(AMOUNT).toString()));
        response.then().log().all();
    }

    @When("User sends another {} Bill Pay via API call for {} and {}")
    public void sendBillPayViaAPI(String amount, String password, String username) {
        String accountId = (getData(FROM_ACCOUNT_ID_BILL_PAY)).toString();
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri(BASE_URI);
//        requestSpecification.basePath("/services_proxy/bank/billpay?accountId=" + accountId + "&amount=" + amount + "");
        requestSpecification.basePath("/services_proxy/bank/billpay?accountId=" + accountId + "&amount=" + amount + "");
//        requestSpecification.formParam("username", username);
//        requestSpecification.formParam("password", password);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("street", TEST_DATA);
        jsonObject.put("city", TEST_DATA);
        jsonObject.put("state", TEST_DATA);
        jsonObject.put("zipCode", 12345);
        requestSpecification.given().auth().basic(username, password);
//        Response response = requestSpecification.auth().basic(username, password);
//        System.out.println(response.statusLine());
        //  assertEquals(response.statusCode(), SC_OK);
//        requestSpecification.put("street", TEST_DATA);
//        requestSpecification.put("city", TEST_DATA);
//        requestSpecification.put("state", TEST_DATA);
//        requestSpecification.put("zipCode", 12345);
        Response response = requestSpecification.body(jsonObject.toJSONString()).get();
        assertTrue(response.body().asString().contains(amount));
        assertTrue(response.body().asString().contains(accountId));
        response.then().log().all();
    }

}


