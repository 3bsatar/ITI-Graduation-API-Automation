package org.example.apis;

import io.restassured.response.Response;
import org.example.base.BaseApi;
import pojo.BookingPojo;

import static io.restassured.RestAssured.given;

public class CreateBooking {

    private String endPoint = "/booking";

    public Response createBooking(BookingPojo bookingData) {
        return given()
                .spec(BaseApi.getRequestSpec())
                .body(bookingData)
                .when()
                .post(endPoint)
                .then()
                .extract().response();
    }
}
