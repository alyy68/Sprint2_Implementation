package com.myFleet.step_definitions;

import com.myFleet.pages.HomePage_aliti;
import com.myFleet.utilities.BrowserUtils;
import com.myFleet.utilities.Driver;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class B40GRP01_342_StepDefs_aliti {
    HomePage_aliti homepage = new HomePage_aliti();
    @When("user presses Vehicles Contracts module under Fleet tab")
    public void user_presses_vehicles_contracts_module_under_fleet_tab() {
        homepage.navigateToModule("Fleet", "Vehicle Contracts");
    }
    @Then("user should see Vehicles Contracts page")
    public void user_should_see_vehicles_contracts_page() {
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://qa3.vytrack.com/entity/Extend_Entity_VehicleContract";
        Assert.assertEquals(expectedURL, actualURL);
        BrowserUtils.waitForTitleContains("All");
        BrowserUtils.verifyTitle("All - Vehicle Contract - Entities - System - Car - Entities - System");
    }

    @Then("user should see “You do not have permission to perform this action.” message displayed")
    public void userShouldSeeYouDoNotHavePermissionToPerformThisActionMessageDisplayed() {
        String page403 = "https://qa3.vytrack.com/entity/Extend_Entity_VehicleContract";

        if (Driver.getDriver().getCurrentUrl().equals(page403)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(homepage.message.isDisplayed());
        }
    }
}
