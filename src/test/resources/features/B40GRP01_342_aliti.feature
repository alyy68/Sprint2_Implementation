@ali
Feature: As a user, I want to access to Vehicle Contracts page

  Background: For all scenarios user is logged in and it's on home page


  Scenario Outline: Verify that Store managers and Sales managers can access the Vehicle   Contracts page.
    Given the user logged in as "<userType>"
    When user presses Vehicles Contracts module under Fleet tab
    Then user should see Vehicles Contracts page

    Examples:
      | userType      |
      | store manager |
      | sales manager |

  Scenario: Verify that Drivers can NOT access the Vehicle Contracts  page and the app displays
  “You do not have permission to perform this action.”
    Given the user logged in as "driver"
    When user presses Vehicles Contracts module under Fleet tab
    Then user should see “You do not have permission to perform this action.” message displayed
