Feature: Login functionality

 Background:
    Given I launch the browser and navigate to the login page
    
    
@useCredentials @login
   Scenario: Test login with multiple credentials
    When I log in using Excel credentials
    Then I validate the login result
    
    
    
@useInvalidCredentials @login
Scenario: Test login with invalid crdential
When Entered invalid username & password
Then Validate the error message