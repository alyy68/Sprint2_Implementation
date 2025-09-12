package com.myFleet.step_definitions;

import com.myFleet.pages.BasePage_AN;
import com.myFleet.pages.LoginPage;
import com.myFleet.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class B40GRP01_340_StepDefs_AN {
    BasePage_AN basePage_an = new BasePage_AN();


    @Given("the user logged in with username as {string} and password as {string} and it's on the main page")
    public void the_user_logged_in_with_username_as_and_password_as_and_it_s_on_the_main_page(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
        basePage_an.waitUntilLoaderScreenDisappear();
    }
    @When("user clicks on question mark icon")
    public void user_clicks_on_question_mark_icon() {
        basePage_an.questionIcon.click();
    }
    @Then("a new window should open with the Oroinc Documentation page")
    public void a_new_window_should_open_with_the_oroinc_documentation_page() {
       // BrowserUtils.switchToWindow("Welcome to Oro Documentation");  //the method works based on title
       // BrowserUtils.verifyURLContains("https://doc.oroinc.com/");
        BrowserUtils.switchWindowAndVerify("https://doc.oroinc.com/", "Welcome to Oro Documentation");
    }



}
