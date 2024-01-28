import clients.UserClient;
import io.restassured.response.Response;
import models.response.SignupResponseModel;
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
    }
}
