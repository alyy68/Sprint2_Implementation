@US4 @B40GRP01-342 @vehicleContracts
Feature: Access Vehicle Contracts page

  Background:
    Given user is on the login page

  # AC1: Store & Sales managers can access the Vehicle   Contracts page.
  @positive @smoke
  Scenario Outline: Managers can access Vehicle Contracts page
    When user logs in as "<role>"
    And user navigates to "Fleet" "Vehicle Contracts"
    Then page title should be "All - Vehicle Contract - Entities - System - Car - Entities - System"
    And url should contain "Extend_Entity_VehicleContract"
    And vehicle contracts grid should be visible

    Examples:
      | role          |
      | store_manager |
      | sales_manager |

  # AC2: Driver can NOT access the Vehicle Contracts  page and the app displays “You do not have permission to perform this action.”
  @negative
  Scenario: Driver cannot access Vehicle Contracts page
    When user logs in as "driver"
    And user navigates to "Fleet" "Vehicle Contracts"
    Then user should see "You do not have permission to perform this action." message

