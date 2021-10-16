package com.taprojects.stepdefinitions;

import com.taprojects.utils.EndPoints;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

/**
 * @author <a href="juan1.hernandez@scotiabankcolpatria.com">Juan Diego Hernandez</a>
 * @version 1.0.0
 * @since 1.0.0
 **/
public class GetUserServicesStepDefinitions {
    ValidatableResponse response;

    @Before
    public void setUp() {
        RestAssured.baseURI = EndPoints.BASEURL;
    }

    @When("I send a request to the URL to get user details$")
    public void i_send_a_request_to_the_url_to_get_user_details() {
        response =
                RestAssured.given()
                        .contentType(ContentType.JSON)
                        .pathParam("employeeId", 1)
                        .when()
                        .get("/employee/{employeeId}").then();
    }

    @Then("the response will return all employed information$")
    public void the_response_will_return_all_employed_information(Map<String, String> data) {
        response.assertThat().statusCode(200);
        response.assertThat().body("data.employee_salary", equalTo(Integer.parseInt(data.get("employee_salary"))));
        response.assertThat().body("message", equalTo(data.get("message")));
    }
}