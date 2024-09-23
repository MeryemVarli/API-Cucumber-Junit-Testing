package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HTTPRequests {

//create another get and it does not endpoint in case

    public static Response GET(String endPoint){

        return given().accept(ContentType.JSON).when().get(endPoint)
                .then().statusCode(200).extract().response();
    }


    //do the rest
    //do POST,PUT,DELETE and overload them as you need

    public static Response GET(){

        return given().accept(ContentType.JSON).when().get()
                .then().statusCode(200).extract().response();
    }




    public static Response GET(String tokenName,String token){

        return given().accept(ContentType.JSON)
                .header(tokenName,token)
                .when().get()
                .then().statusCode(200).extract().response();

        //tokenName in the propertie file as name
    }





    public static Response POST(String endpoint,String payloads){

        return given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(payloads)
                .when()
                .post(endpoint)
                .then().statusCode(200).extract().response();
}



//    public static Response POST(String endpoint,String file){
//        File file = new File()
//        return RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
//                .body(file)
//                .when()
//                .post(endpoint)
//                .then().statusCode(200).extract().response();
//    }









    public static Response POST(String endpoint){

        return given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .when()
                .post(endpoint)
                .then().statusCode(200).extract().response();
    }




    public static Response POST(){

        return given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .when()
                .post()
                .then().statusCode(200).extract().response();
    }




    public static Response POST(String endpoint, String tokenName, String token, String payloads){

        return   given().accept(ContentType.JSON)
                .header(tokenName, token)
                .contentType(ContentType.JSON)
                .body(payloads)
                .when()
                .post(endpoint)
                .then()
                .statusCode(200)
                .extract().response();

    }





}
