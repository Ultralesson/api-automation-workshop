package clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserClient {
    public Response createUser(String email, String password) {
        String userSignupResourceEndpoint = "/api/auth/signup";
        String userSignupRequestBody = String.format("{\"email\": \"%s\", \"password\": \"%s\"}", email, password);

        Response signupResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(userSignupRequestBody)
                .post(userSignupResourceEndpoint);

        return signupResponse;
    }
}
