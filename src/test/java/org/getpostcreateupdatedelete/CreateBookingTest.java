package org.getpostcreateupdatedelete;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingTest extends BaseTest {

    @Test
    public void createBookingTest() {



        // Calling request

        Response response = createBooking();

        Assertions.assertEquals("Tural", response.jsonPath().getJsonObject("booking.firstname"));




    }
}
