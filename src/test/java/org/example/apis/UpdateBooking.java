package org.example.apis;

import io.restassured.response.Response;
import org.example.base.BaseApi;
import pojo.BookingPojo;

import static io.restassured.RestAssured.given;

public class UpdateBooking {

    private String endPoint = "/booking/";

    public Response updateBooking(int bookingId, BookingPojo bookingData, String token) {
        return given()
                .spec(BaseApi.getRequestSpec())
                .header("Cookie", "token=" + token)
                .body(bookingData)
                .when()
                .put(endPoint + bookingId)
                .then()
                .extract().response();
    }
}
