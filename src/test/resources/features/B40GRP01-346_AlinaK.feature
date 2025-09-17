
Feature: US8- As a user, I want to create a recurring(repetitive) calendar event.


  Scenario Outline: Verify that users see the number “1” by default in the Repeat Every input option.
    Given the user logged in as "<UserType>"
    When Go to Calendar Events Page
    Then Field is showing there is "1" number by default
    Examples:
      | UserType      |
      | Driver        |
      | Sales Manager |
      | Store Manager |


  @alina2
  Scenario Outline: Verify that users see the number “1” by default in the Repeat Every input option.
    Given the user logged in as "<UserType>"
    When Go to Calendar Events Page
    When User clear field
    Then User must see error message "This value should not be blank."
    Examples:
      | UserType      |
      | Driver        |
      | Sales Manager |
      | Store Manager |