package com.myFleet.step_definitions;

import com.myFleet.pages.CalendarPage_AlinaK;
import com.myFleet.pages.BasePage;
import com.myFleet.utilities.BrowserUtils;
import com.myFleet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class B40GRP01_347_StepDefs_AlinaK {
    CalendarPage_AlinaK calendarPageAlinaK = new CalendarPage_AlinaK();
    BasePage basePage=new BasePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


    @Given("Go to Calendar Events Page")
    public void goTo_AK() {
       basePage.navigateToModule("Activities", "Calendar Events");
       basePage.waitUntilLoaderScreenDisappear();
       calendarPageAlinaK.createCalendarRepeat();
    }

    @Then("If enter {string} less than {int} —> users should see “The value have not to be  less than {int}.”")
    public void ifEnterLessThanUsersShouldSeeTheValueHaveNotToBeLessThan_AK(String number1, int minimum, int errorNum1) {
        calendarPageAlinaK.inputField.sendKeys(Keys.BACK_SPACE);
        calendarPageAlinaK.inputField.sendKeys(number1+Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(calendarPageAlinaK.errorMessage));

        String actualMessage = calendarPageAlinaK.errorMessage.getText();
        String expectedMessage = "The value have not to be less than " +errorNum1+".";

        if (Integer.valueOf(number1)<minimum){
            Assert.assertEquals(actualMessage,expectedMessage);
        }
    }


    @Then("If enter {string} more than {int} —> users should see “The value have not to be more than {int}.”")
    public void ifEnterMoreThanUsersShouldSeeTheValueHaveNotToBeMoreThan_AK(String number2, int maximum, int errorNum2) {
        calendarPageAlinaK.inputField.sendKeys(Keys.BACK_SPACE);

        calendarPageAlinaK.inputField.sendKeys(number2+Keys.ENTER);

        String actualMessage = calendarPageAlinaK.errorMessage.getText();
        String expectedMessage = "The value have not to be more than " +errorNum2+".";

        if (Integer.valueOf(number2)>maximum){
            Assert.assertEquals(actualMessage,expectedMessage);
        }
    }

    @Then("If enter {string} message should be not displayed.")
    public void ifEnterMessageShouldBeNotDisplayed_AK(String number) {
        BrowserUtils.verifyElementNotDisplayed(By.xpath("//span[contains(@id,'temp-validation-name')]") );

    }
}
