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

public class AddAndUpdate extends BaseTest {

    @Test
    public void testCreateAndUpdateBooking() {
        // استخدم token مباشرة من BaseTest
        String firstname = "User" + new Random().nextInt(1000);
        String lastname = "Tester";
        int price = new Random().nextInt(500) + 100;

        BookingPojo createBookingData = new BookingPojo(
                firstname, lastname, price, true,
                "2025-10-01", "2025-10-15", "Breakfast"
        );

        CreateBooking createBooking = new CreateBooking();
        Response createResponse = createBooking.createBooking(createBookingData);
        Assert.assertEquals(createResponse.statusCode(), 200);

        int bookingId = createResponse.jsonPath().getInt("bookingid");
        System.out.println("🆕 Created booking ID: " + bookingId);

        // Update same booking
        BookingPojo updateBookingData = new BookingPojo(
                "Mahmoud", lastname, price, true,
                "2025-10-01", "2025-10-15", "Dinner"
        );

        UpdateBooking updateBooking = new UpdateBooking();
        Response updateResponse = updateBooking.updateBooking(bookingId, updateBookingData, token);

        Assert.assertEquals(updateResponse.statusCode(), 200);
        Assert.assertEquals(updateResponse.jsonPath().getString("firstname"), "Mahmoud");
        System.out.println("✅ Booking updated successfully!");
    }
}
