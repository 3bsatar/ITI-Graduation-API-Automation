package org.example.tests;

import io.restassured.response.Response;
import org.example.apis.GetBooking;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookingTest extends BaseTest {

    @Test(dependsOnMethods = "org.example.tests.AddBookingTest.testAddBooking")
    public void testGetBookingById() {
        int bookingId = AddBookingTest.bookingId;

        GetBooking getBooking = new GetBooking();
        Response response = getBooking.getBookingById(bookingId);
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);

        String expectedFirstName = AddBookingTest.createdFirstName;
        String expectedLastName = AddBookingTest.createdLastName;

        Assert.assertEquals(response.jsonPath().getString("firstname"), expectedFirstName);
        Assert.assertEquals(response.jsonPath().getString("lastname"), expectedLastName);

        System.out.println("📦 Booking retrieved successfully!");
    }

    @Test(dependsOnMethods = "org.example.tests.UpdateBookingTest.testUpdateBooking")
    public void testGetBookingAfterUpdate() {
        int bookingId = AddBookingTest.bookingId;

        GetBooking getBooking = new GetBooking();
        Response response = getBooking.getBookingById(bookingId);
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("firstname"), "Mahmoud");
        Assert.assertEquals(response.jsonPath().getString("lastname"), "Mesalem");
        Assert.assertEquals(response.jsonPath().getString("additionalneeds"), "Dinner");

        System.out.println("📦 Booking retrieved after update successfully!");
    }
}
