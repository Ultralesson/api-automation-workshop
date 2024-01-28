import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class UserSignupTest extends BaseAPITest {
    @Test
    public void testSuccessfulUserRegistration() {
        // Arrange
        String email = UUID.randomUUID() + "@ultralesson.com";
        String password = "1234567890";

        String userSignupResourceEndpoint = "/api/auth/signup";
        String userSignupRequestBody = String.format("{\"email\": \"%s\", \"password\": \"%s\"}", email, password);

        // Act
        Response signupResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(userSignupRequestBody)
                .post(userSignupResourceEndpoint);

        // Assert
        int statusCode = signupResponse.getStatusCode();
        String emailFromResponse = signupResponse.jsonPath().getString("data.user.email");
        String role = signupResponse.jsonPath().getString("data.user.role");
        String accessToken = signupResponse.jsonPath().getString("data.session.access_token");

        assertEquals(statusCode, 201, "Expected status code to be 201 for successful registered user");
        assertEquals(emailFromResponse, email, "Emails should match");
        assertEquals(role, "authenticated", "Role should be authenticated");
        assertNotNull(accessToken, "Access token should not be null");
    }
}
