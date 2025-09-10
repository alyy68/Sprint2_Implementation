package com.myFleet.step_definitions;

import com.myFleet.pages.B40GRP01_347_CalendarPage;
import com.myFleet.pages.BasePage;
import com.myFleet.utilities.BrowserUtils;
import com.myFleet.utilities.Driver;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class B40GRP01_347_StepDefs {
    B40GRP01_347_CalendarPage b40GRP01347CalendarPage = new B40GRP01_347_CalendarPage();
    BasePage basePage=new BasePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


    @Given("Go to Calendar Events Page")
    public void goTo() {
       basePage.navigateToModule("Activities", "Calendar Events");
       basePage.waitUntilLoaderScreenDisappear();
       b40GRP01347CalendarPage.createCalendarRepeat();
    }

    @Then("If enter {string} less than {int} —> users should see “The value have not to be  less than {int}.”")
    public void ifEnterLessThanUsersShouldSeeTheValueHaveNotToBeLessThan(String number, int minimum, int errorMessage) {
        b40GRP01347CalendarPage.inputField.sendKeys(Keys.BACK_SPACE);
        b40GRP01347CalendarPage.inputField.sendKeys(number+Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(b40GRP01347CalendarPage.errorMessage));

        String actualMessage =b40GRP01347CalendarPage.errorMessage.getText();
        String expectedMessage = "The value have not to be less than " +errorMessage+".";

        if (Integer.valueOf(number)<minimum){
            Assert.assertEquals(actualMessage,expectedMessage);
        }
    }


    @Then("If enter {string} more than {int} —> users should see “The value have not to be more than {int}.”")
    public void ifEnterMoreThanUsersShouldSeeTheValueHaveNotToBeMoreThan(String number, int maximum, int errorMessage) {
        b40GRP01347CalendarPage.inputField.sendKeys(Keys.BACK_SPACE);

        b40GRP01347CalendarPage.inputField.sendKeys(number+Keys.ENTER);

        String actualMessage =b40GRP01347CalendarPage.errorMessage.getText();
        String expectedMessage = "The value have not to be more than " +errorMessage+".";

        if (Integer.valueOf(number)>99){
            Assert.assertEquals(actualMessage,expectedMessage);
        }
    }
}
