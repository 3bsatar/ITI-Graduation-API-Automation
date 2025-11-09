package org.example.tests;

import io.restassured.response.Response;
import org.example.apis.DeleteBooking;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBookingTest extends BaseTest{
    @Test(dependsOnMethods = "org.example.tests.GetBookingTest.testGetBookingById")
    public void testDeleteBooking() {
        int bookingId = AddBookingTest.bookingId;

        DeleteBooking deleteBooking = new DeleteBooking();
        Response response = deleteBooking.deleteBooking(bookingId, token);

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 201);
        System.out.println("🗑️ Booking deleted successfully!");
    }
}
