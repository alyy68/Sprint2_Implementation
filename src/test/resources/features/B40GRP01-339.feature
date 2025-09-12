Feature: As a user, I should be accessing all the main modules of the app.



  Background: The user is already logged in and can access all the main modules on the page

  @merve
    Scenario Outline: Verify that Store and Sales managers see 8 module names
      When the user logs in with username "<username>" and password "<password>"
      Then the user should see the following modules:
        | <module1> |
        | <module2> |
        | <module3> |
        | <module4> |
        | <module5> |
        | <module6> |
        | <module7> |
        | <module8> |


       Examples:

        | role           | username         | password     |  module1    | module2 | module3  | module4 | module5   | module6   | module7            | module8 |
        | Store Manager  | storemanager51   | UserUser123  |  Dashboards | Fleet   | Customers| Sales   | Activities| Marketing | Reports & Segments | System  |
        | Sales Manager  | salesmanager101  | UserUser123  |  Dashboards | Fleet   | Customers| Sales   | Activities| Marketing | Reports & Segments | System  |


    @merve
    Scenario Outline: Verify that Drivers see 4 module names
      When the user logs in with username "<username>" and password "<password>"
      Then the user should see the following modules:
      | <module1> |
      | <module2> |
      | <module3> |
      | <module4> |

      Examples:
       | role   | username     | password    | module1 | module2   | module3   | module4 |
       | Driver | user1        | UserUser123 | Fleet   | Customers | Activities| System  |







