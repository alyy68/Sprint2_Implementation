Feature:  As a user, I should see error messages when I enter an invalid integer into the calendar repeat day input box.

  @alina
  Scenario Outline:Verify that users see error messages when enter invalid integers.
    Given the user logged in as "<UserType>"
    Then the user logged in with username as "Login" and password as "Password"
    Then Go to Calendar Events Page
    Then If enter less than 1 —> users should see “The value have not to be  less than 1.”
    Then If enter more than 99 —> users should see “The value have not to be more than 99.”
    Examples:
      | UserType      |
      | Driver        |




