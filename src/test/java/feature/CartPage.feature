Feature: Validate the cart page functionality


Background:
    Given I launch the browser and navigate to the login page
   When I log in using Excel credentials
   And  User is on product list page and click on product name
   
  @cart
   Scenario: Validate that user is on cart page
   When open cart page from product detail
   Then Validate that cart page is get open
   
 
   Scenario: Validate that the correct product is added to the cart
    When Add to cart product from product detail
    And  open cart page from product detail
    Then the product title and price in the cart should match the selected product
   