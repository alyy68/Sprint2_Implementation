package com.myFleet.step_definitions;

import com.myFleet.pages.CalendarEventsPage_AN;
import com.myFleet.pages.CalendarPage_AlinaK;
import com.myFleet.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class B40GRP01_346_StepDefs_AlinaK {
    CalendarPage_AlinaK calendarPageAlinaK = new CalendarPage_AlinaK();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @Then("Field is showing there is {string} number by default")
    public void field_is_showing_there_is_number_by_default_AK(String expectedNum) {
        String actualNum = calendarPageAlinaK.inputField.getAttribute("value");
        Assert.assertTrue(actualNum.equals(expectedNum));

    }


    @When("User clear field")
    public void user_clear_field_AK() {
        calendarPageAlinaK.inputField.sendKeys(Keys.BACK_SPACE,Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOf(calendarPageAlinaK.errorMessage));


    }

    @Then("User must see error message {string}")
    public void user_must_see_error_message_AK(String expMessage) {
        String actualMessage =calendarPageAlinaK.errorMessage.getText();
        Assert.assertTrue(actualMessage.equals(expMessage));

    }


}
