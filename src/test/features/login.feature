Feature: Verify login feature

  @login @smoke @regression
  Scenario: verify login with valid username and password

    Given i am on home page "https://www.saucedemo.com/" with title  "Swag Labs"
    When i enter username "standard_user" and password "secret_sauce"
    When i click on login button
    Then i should get re-directed to products page with Heading "PRODUCTS"

  @login @regression
  Scenario: verify login with invalid username and password

    Given i am on home page "https://www.saucedemo.com/" with title  "Swag labs"
    When i enter username "standerd_userw" and password "testX"
    When i click on login button
    Then i should not be allowed login instead " Epic sadface: You can only access '/cart.html' when you are logged in."

  @login @regression
  Scenario: verify login with  no  username and password

    Given i am on home page "https://www.saucedemo.com/" with title  "Swag labs"
    When i click on login button
    Then  i should not be allowed login instead "Epic sadface: Username is required"