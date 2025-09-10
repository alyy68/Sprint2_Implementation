package com.myFleet.step_definitions;

import com.myFleet.pages.BasePage_AN;
import com.myFleet.pages.CalendarEventsPage_AN;
import com.myFleet.pages.EventCreationPage_AN;
import com.myFleet.pages.LoginPage;
import com.myFleet.utilities.BrowserUtils;
import com.myFleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class B40GRP01_348_StepDefs_AN {
    BasePage_AN basePage_an = new BasePage_AN();
    CalendarEventsPage_AN calendarEventsPage_an = new CalendarEventsPage_AN();
    EventCreationPage_AN eventCreationPage_an = new EventCreationPage_AN();


    @Given("the user logged in with username as {string} and password as {string} and it's on the calendar event creation page")
    public void the_user_logged_in_with_username_as_and_password_as_and_it_s_on_the_calendar_event_creation_page(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
        basePage_an.waitUntilLoaderScreenDisappear();
        basePage_an.navigateToModule("Activities", "Calendar Events");
        /*
        //BrowserUtils.waitForClickablility(basePage_an.activitiesButton, 10);
        //basePage_an.activitiesButton.click();
        //BrowserUtils.waitForClickablility(basePage_an.calendarEventsButton, 10);
        //basePage_an.calendarEventsButton.click();
         */

    }

    @Then("user clicks on Create Calendar Event button")
    public void userClicksOnCreateCalendarEventButton() {
        //BrowserUtils.waitForClickablility(calendarEventsPage_an.eventCreationButton, 10);
        basePage_an.waitUntilLoaderScreenDisappear();
        calendarEventsPage_an.eventCreationButton.click();
        basePage_an.waitUntilLoaderScreenDisappear();
        //BrowserUtils.waitForClickablility(eventCreationPage_an.saveAndCloseButton, 10);
    }

    @And("user enters {string} into Description")
    public void user_enters_into_description(String textToEnter) {
        basePage_an.waitUntilLoaderScreenDisappear();
        Driver.getDriver().switchTo().frame(eventCreationPage_an.descriptionboxIframe);
        eventCreationPage_an.descitptionBoxText.click();  // in chrome works without this

        //JavaScript executor
        String spaceCorectedText = textToEnter.replace(" ", "&nbsp;");  //converting text to handle multiple space
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].innerHTML = arguments[1];", eventCreationPage_an.descitptionBoxText, spaceCorectedText); // setting/sending the text

        //eventCreationPage_an.descitptionBoxText.sendKeys(textToEnter);

    }


    @Then("user should see the {string} in the Description field")
    public void userShouldSeeTheInTheDescriptionField(String expectedEnteredText) {
        String actualEnteredText = eventCreationPage_an.descitptionBoxText.getText();
        System.out.println("actualEnteredText  = " + actualEnteredText);  // just for myself to be sure
        Assert.assertEquals(expectedEnteredText, actualEnteredText);
        Assert.assertTrue(eventCreationPage_an.descitptionBoxText.isDisplayed());
    }

        /* //another try
    @Then("user should see the entered text in the Description field")
    public void user_should_see_the_entered_text_in_the_description_field() {
        Assert.assertTrue(eventCreationPage_an.descitptionBoxText.isDisplayed());
    }
     */

}
