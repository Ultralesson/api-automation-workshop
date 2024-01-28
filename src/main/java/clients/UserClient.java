package clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.SignupRequestModel;
import models.response.SignupResponseModel;
import utilities.ApiResponseDeserializer;
import utilities.EndpointsConfig;

public class UserClient {
    public SignupResponseModel createUser(String email, String password) {
        String userSignupResourceEndpoint = EndpointsConfig.getEndpoint("auth", "signUp");
        SignupRequestModel signupRequestModel = SignupRequestModel.builder()
                .email(email)
                .password(password)
                .build();


        Response signupResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(signupRequestModel)
                .post(userSignupResourceEndpoint);

        return ApiResponseDeserializer.deserializeResponse(signupResponse, SignupResponseModel.class);
    }
}
