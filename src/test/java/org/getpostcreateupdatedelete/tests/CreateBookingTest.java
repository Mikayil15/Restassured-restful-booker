package org.getpostcreateupdatedelete.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.getpostcreateupdatedelete.models.Booking;
import org.getpostcreateupdatedelete.models.BookingDates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingTest extends BaseTest {

    @Test
    public void createBookingTest() {



        // Calling request

        Response response = createBooking();

        Assertions.assertEquals("Laman", response.jsonPath().getJsonObject("booking.firstname"));




    }

    @Test
    public void createBookingWithPojo(){
        BookingDates bookingDates = new BookingDates("2024-08-02","2024-08-03");
        Booking booking = new Booking("Tamerlan","Ramazanov",169,false,bookingDates,"Phone");

        Response response = given(spec)
                .contentType(ContentType.JSON)
                .body(booking)
                .when()
                .post("/bookings");

        response
                .then()
                .statusCode(200);

    }
}