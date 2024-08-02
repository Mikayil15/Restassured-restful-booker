package org.getpostcreateupdatedelete.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateBookingTest extends BaseTest {

    @Test
    public void UpdateBookingTest() {


        //Create Token


        // Step 2: Create Booking


         //Step 3: Make Request

        Response response = given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie", "token="+ createToken())
                .body(bookingObject("TestUpdatefn","TestIpdateLN" ,598, true ))
                .put("/booking/"+createBookingId());



        // Step 4: Assertion Test Yaz

        String firstName = response.jsonPath().getJsonObject("firstname");
        String lastName = response.jsonPath().getJsonObject("lastname");
        int totalPrice = response.jsonPath().getJsonObject("totalprice");
        boolean depositPaid = response.jsonPath().getJsonObject("depositpaid");


        Assertions.assertEquals("TestUpdatefn", firstName);
        Assertions.assertEquals("TestIpdateLN", lastName);
        Assertions.assertEquals(598, totalPrice);
        Assertions.assertEquals(true, depositPaid);
    }




}
