
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

 Background:
 Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive Test of submitting the order
    Given Logged in with username  <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER."  message is displayed on Confirmation page
    Examples: 
      | name                | password   |productName|
      | kiranblrj@gmail.com | Hokko@1234|ZARA COAT 3|
      
