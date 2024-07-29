package org.getpostcreateupdatedelete;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PartialUpdateBookingTest extends BaseTest {
    @Test
    public void PartialUpdateBookingTest() {
        // Create Token
        //String token = createToken();




        // Create Reservation


       // int bookingId = createBookingId();

        // make request

        JSONObject body = new JSONObject();
        body.put("firstname", "XXXTTT");

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Cookie","token="+createToken())
                .body(body.toString())
                .when()
                .patch("https://restful-booker.herokuapp.com/booking/"+ createBookingId());

                response.prettyPrint();


        // Assertions
        Assertions.assertEquals("XXXTTT", response.jsonPath().getJsonObject("firstname"));


    }
}