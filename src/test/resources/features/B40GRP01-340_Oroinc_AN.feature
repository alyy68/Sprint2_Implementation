Feature: Users should access to the Oroinc Documentation page


  User Story:
  As a user, I should access to the Oroinc Documentation page. (Window handle)
  Users are: Truck Driver, Sales Manager, Store Manager
  The Oroinc Documentation page is URL is: https://doc.oroinc.com/


  Background: User is already logged in

  @wipAN1
  Scenario Outline: Verify that users access to the Oroinc Documentation page by clicking the question mark icon.
    Given the user logged in with username as "<user>" and password as "UserUser123" and it's on the main page
    When user clicks on question mark icon
    Then a new window should open with the Oroinc Documentation page

    Examples:
      | user            |
      | user1           |
      | salesmanager101 |
      | storemanager85  |