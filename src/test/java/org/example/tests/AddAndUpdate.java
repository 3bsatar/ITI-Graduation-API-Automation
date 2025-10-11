package org.example.tests;

import io.restassured.response.Response;
import org.example.apis.CreateBooking;
import org.example.apis.TokenApi;
import org.example.apis.UpdateBooking;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.BookingPojo;
import pojo.CreateTokenPojo;

import java.util.Random;

public class AddAndUpdate {

    @Test
    public void testCreateAndUpdateBooking() {

        CreateTokenPojo tokenData = new CreateTokenPojo();
        tokenData.setUsername("admin");
        tokenData.setPassword("password123");

        TokenApi tokenApi = new TokenApi();
        Response tokenResponse = tokenApi.createToken(tokenData);

        tokenResponse.prettyPrint();
        Assert.assertEquals(tokenResponse.statusCode(), 200);

        String token = tokenResponse.jsonPath().getString("token");
        System.out.println("Generated Token: " + token);

        String firstname = "User" + new Random().nextInt(1000);
        String lastname = "Tester";
        int price = new Random().nextInt(500) + 100;

        BookingPojo createBookingData = new BookingPojo(
                firstname,
                lastname,
                price,
                true,
                "2025-10-01",
                "2025-10-15",
                "Breakfast"
        );

        CreateBooking createBooking = new CreateBooking();
        Response createResponse = createBooking.createBooking(createBookingData);
        createResponse.prettyPrint();

        Assert.assertEquals(createResponse.statusCode(), 200);
        Assert.assertEquals(createResponse.jsonPath().getString("booking.firstname"), firstname);
        Assert.assertEquals(createResponse.jsonPath().getString("booking.lastname"), lastname);

        int bookingId = createResponse.jsonPath().getInt("bookingid");

        BookingPojo updateBookingData = new BookingPojo(
                "Mahmoud",
                lastname,
                price,
                true,
                "2025-10-01",
                "2025-10-15",
                "Dinner"
        );

        UpdateBooking updateBooking = new UpdateBooking();
        Response updateResponse = updateBooking.updateBooking(bookingId, updateBookingData, token);
        updateResponse.prettyPrint();

        Assert.assertEquals(updateResponse.statusCode(), 200);
        Assert.assertEquals(updateResponse.jsonPath().getString("firstname"), "James");
    }
}
