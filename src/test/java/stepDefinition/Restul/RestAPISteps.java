package stepDefinition.Restul;

import io.cucumber.java.en.When;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;


public class RestAPISteps {
    @When("User navigate to 'Register' page")
    public void user_navigate_to_Register_page() {
        baseURI = "https://parabank.parasoft.com";
        given().
                get("/parabank/register.htm").
                then().
                statusCode(SC_OK).
                log().all();
    }

}
