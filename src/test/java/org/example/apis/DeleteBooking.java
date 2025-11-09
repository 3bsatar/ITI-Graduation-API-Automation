package org.example.apis;

import io.restassured.response.Response;
import org.example.base.BaseApi;

import static io.restassured.RestAssured.given;

public class DeleteBooking {
    private String endPoint = "/booking/";

    public Response deleteBooking(int bookingId, String token) {
        return given()
                .spec(BaseApi.getRequestSpec())
                .header("Cookie", "token=" + token)
                .when()
                .delete(endPoint + bookingId)
                .then()
                .extract().response();
    }
}
