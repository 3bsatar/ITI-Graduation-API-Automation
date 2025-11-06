package org.example.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.apis.CreateToken;
import org.example.base.BaseApi;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.BookingPojo;
import pojo.CreateTokenPojo;
import pojo.GetAllIdsPojo;

import static io.restassured.RestAssured.given;

public class EndToEndFlow {

    private final CreateToken createTokenApi = new CreateToken();
    private final String baseUrl = "https://restful-booker.herokuapp.com";

    @Test
    public void endToEndFlow() {
        // ============================
        // Step 1️⃣: Generate Auth Token
        // ============================
        CreateTokenPojo tokenBody = new CreateTokenPojo();
        tokenBody.setUsername("admin");
        tokenBody.setPassword("password123");

        Response tokenResponse = given()
                .spec(BaseApi.getRequestSpec())
                .baseUri(baseUrl)
                .body(tokenBody)
                .when()
                .post(createTokenApi.getEndPoint())
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

        String token = tokenResponse.jsonPath().getString("token");
        Assert.assertNotNull(token, "❌ Token should not be null!");
        System.out.println("✅ Token created successfully: " + token);

        // ============================
        // Step 2️⃣: Create a Booking
        // ============================
        BookingPojo booking = new BookingPojo(
                "Mahmoud",
                "Mesalem",
                250,
                true,
                "2025-11-05",
                "2025-11-10",
                "Breakfast"
        );

        Response createBookingResponse = given()
                .contentType(ContentType.JSON)
                .baseUri(baseUrl)
                .body(booking)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

        int bookingId = createBookingResponse.jsonPath().getInt("bookingid");
        Assert.assertTrue(bookingId > 0, "❌ Booking ID should be valid!");
        System.out.println("✅ Booking created successfully. ID = " + bookingId);

        // ============================
        // Step 3️⃣: Update the Booking
        // ============================
        booking.setAdditionalneeds("Lunch");

        Response updateResponse = given()
                .contentType(ContentType.JSON)
                .cookie("token", token)
                .baseUri(baseUrl)
                .body(booking)
                .when()
                .put("/booking/" + bookingId)
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

        String updatedNeed = updateResponse.jsonPath().getString("additionalneeds");
        Assert.assertEquals(updatedNeed, "Lunch", "❌ Additional needs not updated!");
        System.out.println("✅ Booking updated successfully.");

        // ============================
        // Step 4️⃣: Get the Updated Booking
        // ============================
        Response getResponse = given()
                .baseUri(baseUrl)
                .when()
                .get("/booking/" + bookingId)
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

        BookingPojo fetchedBooking = getResponse.as(BookingPojo.class);
        Assert.assertEquals(fetchedBooking.getAdditionalneeds(), "Lunch", "❌ Data mismatch after update!");
        System.out.println("✅ Booking retrieved successfully and verified.");

        // ============================
        // Step 5️⃣: Get All Booking IDs
        // ============================
        Response allIdsResponse = given()
                .baseUri(baseUrl)
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .extract().response();

        GetAllIdsPojo[] ids = allIdsResponse.as(GetAllIdsPojo[].class);
        Assert.assertTrue(ids.length > 0, "❌ Booking list should not be empty!");
        System.out.println("✅ Retrieved " + ids.length + " booking IDs successfully.");

        System.out.println("🎉 End-to-End flow completed successfully!");
    }
}
