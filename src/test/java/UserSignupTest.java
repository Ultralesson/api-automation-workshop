import clients.UserClient;
import io.qameta.allure.*;
import models.response.SignupResponseModel;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Epic("User Management")
@Feature("User Registration")
public class UserSignupTest extends BaseAPITest {
    @Test
    @Story("Successful user registration")
    @Severity(SeverityLevel.CRITICAL)
    public void testSuccessfulUserRegistration() {
        // Arrange
        String email = UUID.randomUUID() + "@ultralesson.com";
        String password = "1234567890";

        // Act
        UserClient userClient = new UserClient();
        SignupResponseModel signupResponse = userClient.createUser(email, password);

        // Assert
        String emailFromResponse = signupResponse.getData().getUser().getEmail();
        String role = signupResponse.getData().getUser().getRole();
        String accessToken = signupResponse.getData().getSession().getAccessToken();

        assertEquals(emailFromResponse, email, "Emails should match");
        assertEquals(role, "authenticated", "Role should be authenticated");
        assertNotNull(accessToken, "Access token should not be null");

        // Asserting the status code
        assertEquals(signupResponse.getStatusCode(), 201, "Unexpected status code in the response. Expected: 201");
        assertEquals(signupResponse.getHeaders().get("Content-Type"),  "application/json; charset=utf-8", "Unexpected Content-Type header in the response. Expected: application/json; charset=utf-8");
        assertEquals(signupResponse.getHeaders().get("Server"), "Google Frontend", "Unexpected Server header in the response. Expected: Google Frontend");
    }
}
