package org.getpostcreateupdatedelete;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetAllBookingTest extends BaseTest {


    @Test
    public void gettAllBookingTest(){

        given(spec)
                .when()
                .get("/booking")
                .then()
                .statusCode(200);

    }
}
