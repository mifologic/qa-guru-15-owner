package tests;

import config.ApiConfig;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApiTest {

    static ApiConfig config = ConfigFactory.create(ApiConfig.class);

    @Test
    public void getTokenAfterLogin() {

        String userData = "{\"email\": \"" + config.userEmail() + "\", \"password\": \"" + config.userPassword() + "\"}";

        given()
                .log().uri()
                .log().body()
                .body(userData)
                .contentType(ContentType.JSON)
                .when()
                .post(config.baseUrl() + "/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is(config.token()));
    }
}
