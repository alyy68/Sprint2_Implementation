Feature: As a user (Sales and Store manager),
  I should be able to select any vehicle  from the Vehicles page (web table)

  Background: For all scenarios user is logged in and it's on home page

  Scenario Outline: Verify that once the users launch on the Vehicles page,
  the users can see all the checkboxes as unchecked.
    Given the user logged in as "<userType>"
    When user presses Vehicles module under Fleet tab
    And user should see Vehicles page
    Then user should see all checkboxes is unchecked

    Examples:
      | userType      |
      | store manager |
      | sales manager |

  Scenario Outline: Verify that users can check the first checkbox to select all the cars
    Given the user logged in as "<userType>"
    When user presses Vehicles module under Fleet tab
    And user should see Vehicles page
    And user checks the first checkbox
    Then user should see all checkboxes is checked

    Examples:
      | userType      |
      | store manager |
      | sales manager |

  Scenario Outline: Verify that users can select any car
    Given the user logged in as "<userType>"
    When user presses Vehicles module under Fleet tab
    And user should see Vehicles page
    Then user should select any car

    Examples:
      | userType      |
      | store manager |
      | sales manager |