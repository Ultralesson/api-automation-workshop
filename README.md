# Add to Cart Test Case

The `6-add-to-cart-test-case` branch introduces testing functionality for a shopping cart feature within our API Automation Workshop. We expand our client layer to include the product and cart domains, allowing us to simulate a user adding items to their shopping cart.

## What We Achieve

- **Expanded Client Layer**: We implement `ProductClient` and `CartClient` classes to handle fetching products and manipulating the shopping cart.
- **Complex Test Scenario**: Our test simulates a complete user flow: user sign-up, fetching products, creating a cart, and adding an item to the cart.
- **Comprehensive Assertions**: We verify the full sequence of API calls, ensuring each step behaves as expected, including the final addition of a product to the cart.

## Implementation Details

- **ProductClient**: Fetches a list of products from the API and deserializes the response into `ProductFetchResponseModel`.
- **CartClient**: Handles creating a new cart and adding items to it, with responses deserialized into `CreateCartResponseModel` and `AddItemToCartResponseModel`, respectively.
- **AddToCartTest**: Orchestrates the flow of creating a user, obtaining product information, creating a cart, and adding an item to it, followed by relevant assertions.

## How to Run This Test

1. Switch to the `6-add-to-cart-test-case` branch.
2. Ensure your testing environment is set up according to earlier branches.
3. Run the `AddToCartTest` using your IDE or via the terminal:

   ```shell
   ./gradlew test --tests "AddToCartTest.addItemToCart"
   ```