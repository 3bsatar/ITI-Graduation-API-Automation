package org.example.tests;

import io.restassured.response.Response;
import org.example.apis.UpdateBooking;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.BookingPojo;

public class UpdateBookingTest extends BaseTest {

    @Test(dependsOnMethods = "org.example.tests.AddBookingTest.testAddBooking")
    public void testUpdateBooking() {
        int bookingId = AddBookingTest.bookingId;

        BookingPojo updatedData = new BookingPojo(
                "Mahmoud",
                "Mesalem",
                300,
                true,
                "2025-10-01",
                "2025-10-15",
                "Dinner"
        );

        UpdateBooking updateBooking = new UpdateBooking();
        Response response = updateBooking.updateBooking(bookingId, updatedData, token);

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("firstname"), "Mahmoud");
        Assert.assertEquals(response.jsonPath().getString("additionalneeds"), "Dinner");
    }
}
