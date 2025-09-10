Feature:  As a user, (Store and Sales managers) I want to manage filters on the Vehicle Costs page.
  (Web table and checkbox)

  Background: For all scenarios user is logged in and it's on home page

  @ali
  Scenario Outline: Verify that users see 3 columns on the Vehicle Costs page.
    Given the user logged in as "<userType>"
    When user presses Vehicles Costs module under Fleet tab
    And user should see Vehicles Costs page
    Then user should see three columns
      | TYPE        |
      | TOTAL PRICE |
      | DATE        |

    Examples:
      | userType      |
      | store manager |
      | sales manager |