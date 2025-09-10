package com.myFleet.step_definitions;

import com.myFleet.pages.B40GRP01_347_CalendarPage;
import com.myFleet.pages.BasePage;
import com.myFleet.utilities.BrowserUtils;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.remote.Browser;

public class B40GRP01_347_StepDefs {
    B40GRP01_347_CalendarPage b40GRP01347CalendarPage=new B40GRP01_347_CalendarPage();

    @Given("Go to Calendar Events Page")
    public void goTo() {
        BrowserUtils.sleep(5);
        b40GRP01347CalendarPage.navigateToModule("Activities","Calendar Events");
    }

    @Then("If enter less than {int} —> users should see “The value have not to be  less than {int}.”")
    public void if_enter_less_than_users_should_see_the_value_have_not_to_be_less_than(Integer int1, Integer int2) {

    }
    @Then("If enter more than {int} —> users should see “The value have not to be more than {int}.”")
    public void if_enter_more_than_users_should_see_the_value_have_not_to_be_more_than(Integer int1, Integer int2) {

    }
}
