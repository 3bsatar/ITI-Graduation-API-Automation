package org.example.tests;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.example.apis.CreateToken;
import org.example.base.BaseApi;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import pojo.CreateTokenPojo;

import java.util.HashMap;

public class EndToEndFlow {
    public CreateToken createTokenApi = new CreateToken();
    private final String url = "https://restful-booker.herokuapp.com" ;
    //"username" : "admin",
//    "password" : "password123"

    @Test
    public void getToken(){
        CreateTokenPojo body = createTokenApi.getTokenBody("admin","password123");

        Response resp = given().
                spec(BaseApi.getRequestSpec()).
                baseUri(url).
                body(body).
        when().
                post(createTokenApi.getEndPoint()).
        then().
                statusCode(200).
                log().body().
                extract().response();


        createTokenApi.setToken(resp.jsonPath().get("token"));
        System.out.print(createTokenApi.getToken());
    }

}
