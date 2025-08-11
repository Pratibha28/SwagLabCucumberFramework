Feature: Validate Product detail page functionality


Background:
    Given I launch the browser and navigate to the login page
     When I log in using Excel credentials
   
 
 @sheet=ProductDetails  @productdetail
Scenario: Validate that open product detail page functionality from product listing
When  User is on product list page and click on product name
Then product detail page should be get open

 @sheet=ProductDetails 
Scenario: Validate add to cart functionality
When  User is on product list page and click on product name
And Add to cart product from product detail
Then the product should be add to cart successfully


 @sheet=ProductDetails 
Scenario: Validate removing a product from the cart
When  User is on product list page and click on product name
And Add to cart product from product detail
And removes the product from the cart using the Remove button on the product detail page
Then the product should be successfully removed from the cart

 @sheet=ProductDetails  @productdetail
Scenario: Validate back to product listing functionality
When  User is on product list page and click on product name
And  user redirected to product listing using back button
Then user should be redirected back to product listing screen
