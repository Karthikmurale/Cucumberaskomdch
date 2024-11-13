@ask
Feature: Automating the Ecommerce Website called askomdch
  Verifyint and validating the test cases

  @CartValidation
  Scenario: Adding a product in to the cart1
    Given User landed in the store page
    And User add "Blue Tshirt" product in to the cart
    Then User validates the Product "Blue Tshirt" and count "1"
    Then User place order and verify the details
    |First name|Stephen|
    |Last name|Hawkins|
    |Company|TCS|
    |Country|India|
    |Street Address|water street|
    |City|Chennai|
    |Zip Code|600127|
    |Email|Take2ers@gmail.com|
		|State|Tamil Nadu|
		And User capture the id and validate the message "Thank you. Your order has been received." 

 #@ProductValidation
  #Scenario: Adding a product in to the cart2
    #Given User landed in the store page
    #And User add "Blue Tshirt" product in to the cart
    #Then User validates the Product "Blue Tshirt" and count "1"
    #Then User place order and verify the details
    #|First name|Stephen|
    #|Last name|Hawkins|
    #|Company|TCS|
    #|Country|India|
    #|Street Address|water street|
    #|City|Chennai|
    #|Zip Code|600127|
    #|Email|Take2ers@gmail.com|
#		|State|Tamil Nadu|
#		And User capture the id and validate the message "Thank you. Your order has been received." 
