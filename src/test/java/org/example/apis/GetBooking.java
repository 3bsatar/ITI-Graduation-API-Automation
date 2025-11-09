package org.example.apis;

import io.restassured.response.Response;
import org.example.base.BaseApi;

import static io.restassured.RestAssured.given;

public class GetBooking {
    private String endPoint = "/booking/";

    public Response getBookingById(int bookingId) {
        return given()
                .spec(BaseApi.getRequestSpec())
                .when()
                .get(endPoint + bookingId)
                .then()
                .extract().response();
    }
}
