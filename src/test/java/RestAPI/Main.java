package RestAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.equalTo;

public class Main {
    public static final String mainPath = "https://reqres.in/";

    @Test
    public void test1() {
        Response response = RestAssured.get(mainPath.concat("api/users?page=2"));
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), SC_OK);
    }

    @Test
    public void test_2() {
        baseURI = "https://reqres.in/";
        given().
                get("api/users?page=2").
                then().
                statusCode(SC_OK).
                body("data[1].id", equalTo(8)).
                body("data[1].last_name", equalTo("Ferguson")).
                log().all();
    }

    @Test
    public void test_post() {
        baseURI = "https://reqres.in/api/";
        Map<String, String> map = new HashMap<>();
        JSONObject jsonObject = new JSONObject(map);
        jsonObject.put("nume", "sorin");
        jsonObject.put("job", "toster");
        System.out.println(jsonObject);
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                post("users").
                then().
                statusCode(SC_CREATED).
                log().all();
    }

    @Test
    public void test_put() {
        baseURI = "https://reqres.in/api/";
        Map<String, String> map = new HashMap<>();
        JSONObject jsonObject = new JSONObject(map);
        jsonObject.put("nume", "sorin");
        jsonObject.put("job", "toster");
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                put("users/2").
                then().
                statusCode(SC_OK).
                log().all();
    }

    @Test
    public void test_delete() {
        baseURI = "https://reqres.in/api/";
        when().
                delete("users/2").
                then().
                statusCode(SC_NO_CONTENT).
                log().all();
    }

    @Test
    public void test_Para() {
        baseURI = "https://parabank.parasoft.com";
        given().
                get("/parabank/register.htm").
                then().
                statusCode(SC_OK).
                log().all();
    }
}
