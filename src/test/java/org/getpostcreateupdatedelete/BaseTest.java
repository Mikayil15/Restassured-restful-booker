package org.getpostcreateupdatedelete;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class BaseTest {

    RequestSpecification spec;

    @BeforeEach
    public void setup(){
         spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .build();

    }

    protected int createBookingId(){

        Response response = createBooking();
        return response.jsonPath().getJsonObject("bookingid");
    }

    protected Response createBooking(){
        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON).
                body(bookingObject("Laman","Samadov" ,657, false )).
                post("/booking");


        response.then().statusCode(200);
    return response;
    }

    protected String bookingObject(String firstName, String lastName, int totalPrice, boolean depositPaid){
        JSONObject body = new JSONObject();
        body.put("firstname", firstName);
        body.put("lastname", lastName);
        body.put("totalprice", totalPrice);
        body.put("depositpaid", depositPaid);

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "01-01-2004");
        bookingDates.put("checkout", "01-01-2005");

        body.put("bookingdates", bookingDates);
        body.put("additionalneeds", "Coffee");

        return body.toString();


    }

    protected String createToken(){
        JSONObject body = new JSONObject();
        body.put("username", "admin");
        body.put("password", "password123");

        Response response = given(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(body.toString())
                .post("/auth");



        return response.getBody().jsonPath().getString("token");



    }

}
