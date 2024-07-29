package org.getpostcreateupdatedelete;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingByIdTest extends BaseTest {

    @Test
    public void getBookingById() {



        Response response = given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/" +createBookingId());
        response
                .then()

                .statusCode(200);
        response.prettyPrint();

       String firstname = response.jsonPath().getString("firstname");
       String totalprice = response.jsonPath().getString("totalprice");

        Assertions.assertEquals("319", totalprice);


    }
}
