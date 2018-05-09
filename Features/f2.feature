
 Feature: Test Assignment scenarios 
Scenario: Select dress change color and add to cart and verify card product
    Given Launch "chrome" browser and access "http://automationpractice.com/" 
    When User select the dress change the color and add to cart
    Then user should see the same product, color and quantity in cart summery page