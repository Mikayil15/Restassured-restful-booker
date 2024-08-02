package org.getpostcreateupdatedelete.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    @Test
    public void getBooking_with_firstname_filter_test(){
        // Yeni rezervasyon
       int bookingId = createBookingId();;

        // Cagrimiza Qeury Parametresi ekle

        spec.queryParam("firstname", "Laman");
        spec.queryParam("lastname","Samadov");

        //Cagriyi gerceklisir
        Response response  = given(spec)
                .when()
                .get("/booking");

        //Assertion yaz
        response
                .then()
                .statusCode(200);

        List<Integer> filter = response.jsonPath().getList("bookingid");
        Assertions.assertTrue(filter.contains(bookingId));

    }
}
