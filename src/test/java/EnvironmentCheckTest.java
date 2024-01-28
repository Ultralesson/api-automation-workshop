import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Epic("System Health Checks")
@Feature("Environment Verification")
public class EnvironmentCheckTest extends BaseAPITest {

    @Test
    @Story("Health Check of the Environment")
    @Severity(SeverityLevel.BLOCKER)
    public void testEnvironmentSetup() {
        String healthCheckResourceEndpoint = "/health-check";
        Response response = given()
                .when()
                .get(healthCheckResourceEndpoint);
        int statusCode = response.getStatusCode();
        String message = response.jsonPath().getString("message");

        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(message, "ok");
    }
}