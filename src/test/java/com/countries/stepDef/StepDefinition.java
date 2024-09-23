package com.countries.stepDef;

import endPoints.Countries;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ConfigReader;
import utils.HTTPRequests;

import java.util.List;

public class StepDefinition {

private Response response;
private String endPoint;



    @Given("user performs get request")
    public void user_performs_get_request() {
//    1.    Response countryResponse = RestAssured.given().accept(ContentType.JSON).when().get(ConfigReader.readProperty("countryEndpoint"))
//                .then().statusCode(200).extract().response();


//      2.  HTTPRequests.GET(ConfigReader.readProperty("countryEndpoint"));


       response = HTTPRequests.GET(Countries.endPoint);


    }
    @Then("user validates capital as {string}")
    public void user_validates_capital_as(String capital) {
     List<String> actualCapital= response.path("find {it.name.common=='United Kingdom'}.capital") ;
        Assert.assertEquals("failed to validate capital",capital,actualCapital.get(0));
        System.out.println(actualCapital);

    }
    @Then("user validates currency name as {string}")
    public void user_validates_currency_name_as(String currencyName) {
      String actualCurrency=  response.path("find {it.name.common=='United Kingdom'}.currencies.GBP.name");
       Assert.assertEquals("failed to validate currency",currencyName,actualCurrency);
    }
    @Then("user validates status code as {string}")
    public void user_validates_status_code_as(String statusCode) {
      Assert.assertEquals(Integer.parseInt(statusCode),response.getStatusCode());

    }





















}
