Feature: Login functionality

 Background:
    Given I launch the browser and navigate to the login page
    
    
@sheet=Credentials  @login
   Scenario: Test login with multiple credentials
    When I log in using Excel credentials
    Then I validate the login result
    
    
    
@sheet=InvalidCredentials @login
Scenario: Test login with invalid crdential
When Entered invalid username & password
Then Validate the error message