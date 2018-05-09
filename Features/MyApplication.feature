

Feature: Test Assignment scenarios
  I want to use this template for my feature file
 
 Scenario: validate invalid email address 
    Given Open "chrome" browser and launch "http://automationpractice.com/" address
    When user enter the invalid email address "abc"
    Then user should get an error message

  
  Scenario: Data driving validate successful registration
   Given Open "chrome" and start "http://automationpractice.com/"
   When user enter valid "madhurinasare321@rediffmail.com" and click on Create account button
   And User enters Details to Registration
      | firstName | lastName | password  | addressfirstName | addresslastName | company        | address1   | address2   | city    | postcode | mobile       | alias         |
    | Sunil     | Mehta    | sm2012    | sunil            | Mehta           | Infosys Limited| Plot No 20 | Street 125 | Fremont | 41525    | +1 524789654 | Same As Above |
    Then User should be able to register successfully   
      
  Scenario: Verify summer dress display on mouseover in Megamenu
    Given Open "chrome" and access the "http://automationpractice.com/"
    When user mousehover on dress
    Then User should able to see Summer dress and click on it

  Scenario: Verify Product grid after sorting
    Given Open "chrome"  and access "http://automationpractice.com/"
    When User navigate to Summer dresses and select Price Lowest first in sort by
    Then user should see the product as per selected sorting order


  Scenario: Select dress change color and add to cart and verify card product
    Given Launch "chrome" browser and access "http://automationpractice.com/" 
    When User select the dress change the color and add to cart
    Then user should see the same product, color and quantity in cart summery page
