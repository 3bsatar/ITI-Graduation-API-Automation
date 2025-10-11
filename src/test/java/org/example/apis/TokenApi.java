package org.example.apis;

import io.restassured.response.Response;
import org.example.base.BaseApi;
import pojo.CreateTokenPojo;

import static io.restassured.RestAssured.given;

public class TokenApi {
    private String endPoint = "/auth";

    public Response createToken(CreateTokenPojo tokenData) {
        return given()
                .spec(BaseApi.getRequestSpec())
                .body(tokenData)
                .when()
                .post(endPoint)
                .then()
                .extract().response();
    }
}
