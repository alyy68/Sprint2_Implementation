package com.myFleet.step_definitions;

import com.myFleet.pages.HomePage_aliti;
import com.myFleet.pages.VehicleCostsPage_aliti;
import com.myFleet.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class B40GRP01_351_StepDefs_aliti {

    HomePage_aliti homePage = new HomePage_aliti();
    VehicleCostsPage_aliti vehicleCosts = new VehicleCostsPage_aliti();

    @When("user presses Vehicles Costs module under Fleet tab")
    public void userPressesVehiclesCostsModuleUnderFleetTab() {
        homePage.navigateToModule("Fleet", "Vehicle Costs");
    }

    @When("user should see Vehicles Costs page")
    public void user_should_see_vehicles_costs_page() {
        BrowserUtils.waitForTitleContains("All");
        BrowserUtils.verifyTitleContains("Vehicle Costs");
    }

    @Then("user should see three columns")
    public void user_should_see_three_columns(List<String> expectedColumns) {
        Assert.assertEquals(expectedColumns, vehicleCosts.loopForColumns());
    }

    @Then("user should select first checkbox")
    public void userShouldSelectFirstCheckbox() {
        vehicleCosts.firstCheckbox.click();
    }

    @Then("user should see all checkboxes is selected")
    public void userShouldSeeAllCheckboxesIsSelected() {
        Assert.assertTrue(vehicleCosts.list());
    }
}
