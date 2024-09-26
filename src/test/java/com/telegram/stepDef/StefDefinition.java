package com.telegram.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ConfigReader;

public class StefDefinition {

private Response response;

private String token;
private String chatID;
private String message;




    @Given("user has telegram api token")
    public void user_has_telegram_api_token() {
        token= ConfigReader.readProperty("telegramToken");
        chatID=ConfigReader.readProperty("telegramChatID");
        message ="Hello from intellij";



    }
    @Then("user send message to the endpoint")
    public void user_send_message_to_the_endpoint() {
        response = RestAssured.given().baseUri("https://api.telegram.org").basePath("/bot" + token + "/sendMessage")
                .queryParam("chat_id", chatID).queryParam("text", message)
                .when().post().then().statusCode(200).extract().response();

    }
    @Then("user validates status code  {string}")
    public void user_validates_status_code(String statusCode) {
        Assert.assertEquals("failed to validate status code",Integer.parseInt(statusCode),response.getStatusCode());

    }
    @Then("message successfuly sent")
    public void message_successfuly_sent() {
      String actualText=  response.path("result.text");
      Assert.assertEquals(message,actualText);

    }














}
