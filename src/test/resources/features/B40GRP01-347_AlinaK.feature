Feature:  As a user, I should see error messages when I enter an invalid integer into the calendar repeat day input box.


  Scenario Outline:Verify that users see error messages when enter invalid integers.
    Given the user logged in as "<UserType>"
    When Go to Calendar Events Page
    When If enter "<Number1>" less than 1 —> users should see “The value have not to be  less than 1.”
    Examples:
      | UserType      | Number1 |
      | Driver        | -5      |
      | Sales Manager | -10     |
      | Store Manager | -2      |


  Scenario Outline:Verify that users see error messages when enter invalid integers.
    Given the user logged in as "<UserType>"
    When Go to Calendar Events Page
    Then If enter "<Number2>" more than 99 —> users should see “The value have not to be more than 99.”
    Examples:
      | UserType      | Number2 |
      | Driver        | 200     |
      | Sales Manager | 101     |
      | Store Manager | 3506    |


  @alina
  Scenario Outline:Verify that users does not see error messages when enter valid integers.
    Given the user logged in as "<UserType>"
    When Go to Calendar Events Page
    Then If enter "<Number>" message should be not displayed.
    Examples:
      | UserType      | Number |
      | Driver        | 1      |
      | Driver        | 55     |
      | Driver        | 99     |
      | Sales Manager | 1      |
      | Sales Manager | 55     |
      | Sales Manager | 99     |
      | Store Manager | 1      |
      | Store Manager | 55     |
      | Store Manager | 99     |




