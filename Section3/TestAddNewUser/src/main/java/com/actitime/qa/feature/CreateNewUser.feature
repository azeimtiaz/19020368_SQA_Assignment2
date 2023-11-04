Feature: As the admin I should be able to create a new user in Actitime

  @TC_002
  Scenario Outline: Successfully adding a new user
    Given User is logged in to the application
    And User is in the Users page
    When User clicks add new user button
    And User enters the firstname of new user as  "<firstName>"
    And User enters the lastname of new user as  "<lastName>"
    And User enters the email of new user as "<email>"
    And User clicks the submission button
    Then User should be created successfully with first name "<firstName>" and last name "<lastName>"
    Examples:
      | firstName | lastName | email |
      | Fathima | Azma | imtiaz.azma@gmail.com |