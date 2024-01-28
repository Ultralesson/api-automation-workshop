
import clients.CartClient;
import clients.ProductClient;
import clients.UserClient;
import models.response.AddItemToCartResponseModel;
import models.response.CreateCartResponseModel;
import models.response.ProductFetchResponseModel;
import models.response.SignupResponseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataLoader;

import java.util.UUID;public class AddToCartTest extends BaseAPITest {

    @Test
    public void addItemToCart() {
        // Arrange
        UserClient userClient = new UserClient();
        CartClient cartClient = new CartClient();

        String email = UUID.randomUUID() + "@ultralesson.com";
        String passwordFromDataLoader = DataLoader.getData("createCartData", "password");
        String productIDFromDataLoader = DataLoader.getData("createCartData", "product_id");
        int quantityFromDataLoader = Integer.parseInt (DataLoader.getData("createCartData", "quantity"));

        // Act
        // Create a new user and obtain the access token
        SignupResponseModel userSignupResponse = userClient.createUser(email, passwordFromDataLoader);
        String accessToken = userSignupResponse.getData().getSession().getAccessToken();

        // Create a new cart and obtain the cart ID
        CreateCartResponseModel createCartResponseModel = cartClient.createCart(accessToken);
        String cartID = createCartResponseModel.getCartID();

        // Add an item to the cart and obtain the response model
        AddItemToCartResponseModel addItemToCartResponseModel = cartClient.addItemCart(productIDFromDataLoader, accessToken, cartID, quantityFromDataLoader);

        // Assert
        Assert.assertNotNull(addItemToCartResponseModel.getCartItemID());
        Assert.assertEquals(addItemToCartResponseModel.getProductID(), productIDFromDataLoader);
        Assert.assertEquals(addItemToCartResponseModel.getCartID(), cartID);
        Assert.assertEquals(addItemToCartResponseModel.getQuantity(), 10);
        Assert.assertEquals(addItemToCartResponseModel.getStatusCode(), 201);
    }
}