Feature: Edit car info icon
  Agile Story: As a user, I want to see edit car info icons from the Vehicles page.


  Background: User is already logged in


  @NS
  Scenario: Verify that users see “view, edit, delete” options when they hover the mouse over the 3 dots “…”
    Given the user logs in with username "user1" and password "UserUser123"
    And user presses "Vehicles" module under the "Fleet" tab
    Then user hovers the mouse over three dots of the first Item
    Then user should see view, edit, delete options

