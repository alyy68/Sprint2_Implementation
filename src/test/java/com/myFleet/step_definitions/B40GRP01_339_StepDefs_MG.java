package com.myFleet.step_definitions;

import com.myFleet.pages.ModulesPage_MG;
import com.myFleet.utilities.BrowserUtils;
import com.myFleet.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class B40GRP01_339_StepDefs_MG {


    ModulesPage_MG modulesPage = new ModulesPage_MG();

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) {
        Driver.getDriver().get("https://qa3.vytrack.com");
        modulesPage.login(username, password);
        BrowserUtils.waitFor(10);

    }
    @Then("the user should see the following modules:")
    public void the_user_should_see_the_following_modules(io.cucumber.datatable.DataTable dataTable) {

        List<String> expectedModules = dataTable.asList();

        List<String> actualModules = BrowserUtils.getElementsText(modulesPage.allModules);
        Assert.assertEquals("Modules do not match!",expectedModules, actualModules);

    }


}
