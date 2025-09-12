package com.myFleet.step_definitions;

import com.fasterxml.jackson.databind.ser.std.ClassSerializer;
import com.myFleet.pages.B40GRP01_347_CalendarPage_AlinaK;
import com.myFleet.pages.BasePage;
import com.myFleet.utilities.BrowserUtils;
import com.myFleet.utilities.Driver;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class B40GRP01_347_StepDefs_AlinaK {
    B40GRP01_347_CalendarPage_AlinaK b40GRP01347CalendarPage = new B40GRP01_347_CalendarPage_AlinaK();
    BasePage basePage=new BasePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


    @Given("Go to Calendar Events Page")
    public void goTo_AK() {
       basePage.navigateToModule("Activities", "Calendar Events");
       basePage.waitUntilLoaderScreenDisappear();
       b40GRP01347CalendarPage.createCalendarRepeat();
    }

    @Then("If enter {string} less than {int} —> users should see “The value have not to be  less than {int}.”")
    public void ifEnterLessThanUsersShouldSeeTheValueHaveNotToBeLessThan_AK(String number1, int minimum, int errorNum1) {
        b40GRP01347CalendarPage.inputField.sendKeys(Keys.BACK_SPACE);
        b40GRP01347CalendarPage.inputField.sendKeys(number1+Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(b40GRP01347CalendarPage.errorMessage));

        String actualMessage =b40GRP01347CalendarPage.errorMessage.getText();
        String expectedMessage = "The value have not to be less than " +errorNum1+".";

        if (Integer.valueOf(number1)<minimum){
            Assert.assertEquals(actualMessage,expectedMessage);
        }
    }


    @Then("If enter {string} more than {int} —> users should see “The value have not to be more than {int}.”")
    public void ifEnterMoreThanUsersShouldSeeTheValueHaveNotToBeMoreThan_AK(String number2, int maximum, int errorNum2) {
        b40GRP01347CalendarPage.inputField.sendKeys(Keys.BACK_SPACE);

        b40GRP01347CalendarPage.inputField.sendKeys(number2+Keys.ENTER);

        String actualMessage =b40GRP01347CalendarPage.errorMessage.getText();
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
