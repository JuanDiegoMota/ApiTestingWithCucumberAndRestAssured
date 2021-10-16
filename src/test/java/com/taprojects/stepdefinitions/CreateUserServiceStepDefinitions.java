package com.taprojects.stepdefinitions;

import com.taprojects.utils.EndPoints;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="juan1.hernandez@scotiabankcolpatria.com">Juan Diego Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
public class CreateUserServiceStepDefinitions {
    Response response;
    Map<String, String> userInfo;

    @Before
    public void setUp() {
        RestAssured.baseURI = EndPoints.BASEURL;
        userInfo = new HashMap<>();
    }

    @When("I send a request to the URL to create user")
    public void i_send_a_request_to_the_url_to_create_user(Map<String, String> data) {
        userInfo = data;
        response =
                RestAssured.given().log().all()
                        .contentType(ContentType.JSON)
                        .and()
                        .body(data)
                        .when()
                        .post("/create")
                        .then().log().all()
                        .extract().response();
    }

    @Then("the response will return for created user was (.*)$")
    public void the_response_will_return_for_created_user(String message) {
        assertEquals(200, response.statusCode());
        assertEquals(userInfo.get("name"), response.jsonPath().getString("data.name"));
        assertEquals(message, response.jsonPath().getString("status"));
        assertEquals(userInfo.get("salary"), response.jsonPath().get("data.salary"));
        assertEquals(userInfo.get("age"), response.jsonPath().get("data.age"));
    }
}