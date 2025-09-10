package com.myFleet.step_definitions;

import com.myFleet.pages.HomePage_ali;
import com.myFleet.utilities.BrowserUtils;
import com.myFleet.utilities.Driver;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class B40GRP01_351_StepDefs {

    HomePage_ali homePage = new HomePage_ali();

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
        Assert.assertEquals(expectedColumns, homePage.loopForColumns());
    }



}
