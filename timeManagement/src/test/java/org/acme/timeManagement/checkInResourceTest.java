package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class checkInResourceTest {

    @Test
    public void testCheckInEndpoint() {
        given()
          .when().post("/checkIn")
          .then()
             .statusCode(401);
    }

}
