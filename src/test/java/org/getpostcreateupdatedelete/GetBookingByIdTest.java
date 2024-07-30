package org.getpostcreateupdatedelete;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingByIdTest extends BaseTest {

    @Test
    public void getBookingById() {



        Response response = given(spec)
                .when()
                .get("/booking/" +createBookingId());
        response
                .then()

                .statusCode(200);


       String firstname = response.jsonPath().getString("firstname");
       String totalprice = response.jsonPath().getString("totalprice");

        Assertions.assertEquals("319", totalprice);


    }
}
