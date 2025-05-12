Feature: Validate product page functionality


Background:
    Given I launch the browser and navigate to the login page
   When I log in using Excel credentials
   
   @useCredentials 
    Scenario: Validate all the product name from the page
    When Get all the product name
    Then Validate all the product name 
    
    
    @useCredentials 
    Scenario: Validate all the product price  from the page
    When Get all the product price
    Then Validate all the product price 
    
    @useCredentials 
    Scenario: Verify that the 'Name: Z to A' sorting filter sorts products in descending alphabetical order
    When  apply the Name: Z to A sorting filter on the product listing page
    Then  should see all product names sorted in descending alphabetical order
    
     @useCredentials
    Scenario: Verify that the 'Price(low to high)' sorting filter sorts products in Asc alphabetical order
    When  apply the Price(low to high) sorting filter on the product listing page
    Then  should see all product price sorted in ascending order
    
    
       
     @useCredentials
    Scenario: Verify that the 'Price(high to low)' sorting filter sorts products in descending alphabetical order
    When  apply the Price(high to low) sorting filter on the product listing page
    Then  should see all product price sorted in descending order
    
    
    @useCredentials 
    Scenario: Verify add a product to the cart from the product listing page functionality
    When the user add a product to the cart from the product listing page
    Then the product should be successfully added to the cart
    
      @useCredentials @product
    Scenario: Verify remove the product from cart functionality from the product listing page 
    When the user add a product to the cart from the product listing page
    And  the user remove product from the product listing page
    Then the product should be successfully remove from the cart
