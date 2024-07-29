package org.getpostcreateupdatedelete;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest extends BaseTest{
    @Test
    public void deleteBookingTest() {


        Response response  = given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token="+createToken())
                .when()
                .delete("https://restful-booker.herokuapp.com/booking/"+createBookingId());

        response.prettyPrint();
        response
                .then()
                        .statusCode(201);


    }
}
