
import clients.CartClient;
import clients.ProductClient;
import clients.UserClient;
import models.response.AddItemToCartResponseModel;
import models.response.CreateCartResponseModel;
import models.response.ProductFetchResponseModel;
import models.response.SignupResponseModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;public class AddToCartTest extends BaseAPITest {

    @Test
    public void addItemToCart() {
        // Arrange
        UserClient userClient = new UserClient();
        ProductClient productClient = new ProductClient();
        CartClient cartClient = new CartClient();

        String email = UUID.randomUUID() + "@ultralesson.com";
        String passwordFromDataLoader = "1234567890";

        // Act

        // Create a new user and obtain the access token
        SignupResponseModel userSignupResponse = userClient.createUser(email, passwordFromDataLoader);
        String accessToken = userSignupResponse.getData().getSession().getAccessToken();

        // Fetch products to get a product ID
        ProductFetchResponseModel productFetchResponseModel = productClient.fetchProducts(accessToken);
        String productId = productFetchResponseModel.getProducts().get(0).getId();

        // Create a new cart and obtain the cart ID
        CreateCartResponseModel createCartResponseModel = cartClient.createCart(accessToken);
        String cartID = createCartResponseModel.getCartID();

        // Add an item to the cart and obtain the response model
        AddItemToCartResponseModel addItemToCartResponseModel = cartClient.addItemCart(productId, accessToken, cartID, 10);

        // Assert
        Assert.assertNotNull(addItemToCartResponseModel.getCartItemID());
        Assert.assertEquals(addItemToCartResponseModel.getProductID(), productId);
        Assert.assertEquals(addItemToCartResponseModel.getCartID(), cartID);
        Assert.assertEquals(addItemToCartResponseModel.getQuantity(), 10);
        Assert.assertEquals(addItemToCartResponseModel.getStatusCode(), 201);
    }
}