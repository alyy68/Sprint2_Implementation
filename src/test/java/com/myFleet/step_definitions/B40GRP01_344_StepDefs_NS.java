package com.myFleet.step_definitions;


import com.myFleet.pages.BasePage;
import com.myFleet.pages.VehiclesPage_NS;

import com.myFleet.utilities.BrowserUtils;

import com.myFleet.utilities.Driver;
import io.cucumber.java.en.*;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


import javax.swing.*;


public class B40GRP01_344_StepDefs_NS {
    BasePage basePage = new BasePage();
    Actions actions = new Actions(Driver.getDriver());

    VehiclesPage_NS vehiclesPage_ns = new VehiclesPage_NS();

    @Given("user presses {string} module under the {string} tab")
    public void userPressesModuleUnderTheTab(String module, String tab) {
        basePage.navigateToModule(tab,module);
    }
    @Then("user hovers the mouse over three dots of the first Item")
    public void userHoversTheMouseOverThreeDotsOfTheFirstItem() throws InterruptedException {
        Thread.sleep(10000);
        BrowserUtils.hover(vehiclesPage_ns.firstThreeDots);

    }
    @Then("user should see view, edit, delete options")
    public void user_should_see_view_edit_delete_options() {
        BrowserUtils.sleep(10);
        Assert.assertTrue(vehiclesPage_ns.viewOption.isDisplayed());
        Assert.assertTrue(vehiclesPage_ns.editOption.isDisplayed());
        Assert.assertTrue(vehiclesPage_ns.deleteOption.isDisplayed());


    }





}
