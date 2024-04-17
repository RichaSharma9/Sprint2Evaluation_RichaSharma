@All
Feature: Check the Homeloans functionality

#THIS IS MANDETORY METHOD FOR EVERY SCENARIO
#IN THIS METHOD USER IS ON THE HOMEPAGE OF MAGICBRICKS
Background: 
    Given User is on the homepage of MagicBricks

#THIS METHOD IS USED TO VALIDATE THE HOMELOAN FUNCTIONALITY WITH VALID DETAILS
  @Homeloan
  Scenario Outline: To Check the homeloan calculator functionality with valid details
    When User is on the homeloans page
    When User enter the <Loan_Amount>, <Mobile>, <City>
    And Click on the check eligibility button
    Then User navigate to verification page

    Examples: 
      | Loan_Amount | Mobile     | City   |
      |     2000000 | 7489654824| Mumbai |


#THIS SCENARIO USED TO VALIDATE THE MONTHLY EMI CALCULATOR FUNCTIONALITY WITH VALID DETAILS
  @Valid_EMI
  Scenario: To check the EMI calculator functionality with valid details
    When User is on the EMI calculator page
    And User enter the details
      | 560000 | 7.5 |
      |54687383|6.6|
    And Click on the submit button
    Then Monthly EMI of user is visible on the page


#THIS SCENARIO IS USED TO VALIDATE MONTHLY EMI CALCULATOR WITH EMPTY LOAN AMOUNT FIELD
  @Invalid_EMI
  Scenario: To check the EMI calculator functionality with empty loan amount details
    When The user is on the EMI calculator page to estimate the monthly EMI
    And User enter the interest rate
      | 9.5 |
    And Click on the submit button for calculation
    Then an error message should generate for empty loan amount field


#THIS SCENARIO IS USED TO VALIDATE THE PREPAYMENT AMOUNT CALCULATOR WITH VALID DETAILS
  @Prepayment
  Scenario Outline: To check the Prepayment amount functionality
  When User is on the Homeloans calculation page 
  When User scroll down to the prepayment calculator 
  When Click on the calculator
  And Enter the details <Amount>, <Tenure>, <Interest> and <Installments>
  And Click on calculate button
  Then Calculated amount is displayed on the screen
  
  Examples:
  |Amount |Tenure|Interest|Installments|
  |123456|5     |7.8     |50          	|