package com.myFleet.step_definitions;

import com.myFleet.pages.HomePage_aliti;
import com.myFleet.pages.VehiclesPage_aliti;
import com.myFleet.utilities.BrowserUtils;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class B40GRP01_345_StepDefs_aliti {

    HomePage_aliti homePage = new HomePage_aliti();

    @When("user presses Vehicles module under Fleet tab")
    public void user_presses_vehicles_module_under_fleet_tab() {
        homePage.navigateToModule("Fleet", "Vehicles");
    }
    @When("user should see Vehicles page")
    public void user_should_see_vehicles_page() {
        BrowserUtils.waitForTitleContains("All");
        BrowserUtils.verifyTitle("All - Car - Entities - System - Car - Entities - System");
    }
    VehiclesPage_aliti vehiclesPage = new VehiclesPage_aliti();
    @Then("user should see all checkboxes is unchecked")
    public void user_should_see_all_checkboxes_is_unchecked() {
        Assert.assertTrue(BrowserUtils.isCheckboxesSelected(vehiclesPage.checkBox, false));
    }

    @And("user checks the first checkbox")
    public void userChecksTheFirstCheckbox() {
        vehiclesPage.firstCheckbox.click();
    }

    @Then("user should see all checkboxes is checked")
    public void userShouldSeeAllCheckboxesIsChecked() {
        BrowserUtils.isCheckboxesSelected(vehiclesPage.checkBox, true);
    }

    @Then("user should select any car")
    public void userShouldSelectAnyCar() {
        Assert.assertTrue(BrowserUtils.randomCheckbox(vehiclesPage.checkBox, 2));
    }
}
