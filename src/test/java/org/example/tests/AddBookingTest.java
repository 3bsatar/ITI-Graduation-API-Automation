package org.example.tests;

import io.restassured.response.Response;
import org.example.apis.CreateBooking;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.BookingPojo;

import java.util.Random;

public class AddBookingTest extends BaseTest {

    public static int bookingId;
    public static String createdFirstName;  // لتخزين firstname
    public static String createdLastName;   // لتخزين lastname

    @Test
    public void testAddBooking() {
        String firstname = "User" + new Random().nextInt(1000);
        String lastname = "Tester";
        int price = new Random().nextInt(500) + 100;

        BookingPojo bookingData = new BookingPojo(
                firstname,
                lastname,
                price,
                true,
                "2025-10-01",
                "2025-10-15",
                "Breakfast"
        );

        CreateBooking createBooking = new CreateBooking();
        Response response = createBooking.createBooking(bookingData);

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), firstname);
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), lastname);

        bookingId = response.jsonPath().getInt("bookingid");
        createdFirstName = firstname;  // حفظ firstname
        createdLastName = lastname;    // حفظ lastname

        System.out.println("Created Booking ID: " + bookingId);
        System.out.println("Created Booking First Name: " + createdFirstName);
    }
}
