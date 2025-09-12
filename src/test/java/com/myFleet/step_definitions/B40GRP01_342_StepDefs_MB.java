package com.myFleet.step_definitions;

import com.myFleet.pages.BasePage;
import com.myFleet.pages.BasePage_MB;
import com.myFleet.pages.LoginPage;
import com.myFleet.pages.VehicleContractsPage_MB;
import com.myFleet.utilities.BrowserUtils;
import com.myFleet.utilities.ConfigurationReader;
import com.myFleet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class B40GRP01_342_StepDefs_MB {

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user logs in as {string}")
    public void user_logs_in_as(String role) {

        LoginPage loginPage = new LoginPage();
        String u = ConfigurationReader.getProperty(role + "_username");
        String p = ConfigurationReader.getProperty(role + "_password");
        loginPage.login(u, p);
    }

    @When("user navigates to {string} {string}")
    public void user_navigates_to(String tab, String module) {
        BasePage_MB basePageMb = new BasePage_MB();
        basePageMb.navigateToModuleMb(tab, module);
        BrowserUtils.waitForPageToLoad(10);

    }


    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.titleContains("Vehicle Contract"));
        String actual = Driver.getDriver().getTitle().trim();


        String relaxed = expectedTitle.replaceFirst("^All\\s+-\\s+", "");
        boolean ok = actual.equals(expectedTitle) || actual.equals(relaxed);
        Assert.assertTrue("Title mismatch! Expected either:\n" +
                expectedTitle + "\nOR\n" + relaxed + "\nbut was:\n" + actual, ok);


        WebElement h1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h1[@class='oro-subtitle' and normalize-space()='All Vehicle Contract']")));
        Assert.assertTrue("H1 header not visible!", h1.isDisplayed());
    }

    @Then("url should contain {string}")
    public void url_should_contain(String expectedPart) {
        String url = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue("URL does not contain expected part. Actual: " + url, url.contains(expectedPart));

    }

    VehicleContractsPage_MB vehicleContractsPageMb = new VehicleContractsPage_MB();

    @Then("vehicle contracts grid should be visible")
    public void vehicle_contracts_grid_should_be_visible() {
        BrowserUtils.waitForVisibility(vehicleContractsPageMb.gridTable, 10);
        Assert.assertTrue("Grid is not visible!", vehicleContractsPageMb.gridTable.isDisplayed());
    }

    @Then("user should see {string} message")
    public void user_should_see_message(String expectedMsg) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(12));

        By flash = By.xpath("//div[contains(@class,'flash-messages')]//div[contains(@class,'alert')]");
        By body = By.tagName("body");
        boolean ok = false;

        try {
            ok = wait.until(ExpectedConditions.textToBePresentInElementLocated(flash, expectedMsg));
        } catch (TimeoutException ignored) {
        }

        if (!ok) {
            ok = wait.until(driver ->
                    driver.getTitle().contains("403")
                            || driver.getPageSource().contains(expectedMsg)
            );
        }
        Assert.assertTrue("403/permission beklenen metin görünmedi!", ok);


        By goBack = By.xpath(
                "//a[normalize-space()='Click to go back' or contains(.,'go back')]"
                        + "|//button[normalize-space()='Click to go back' or contains(.,'go back')]"
        );
        try {
            WebElement btn = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(goBack));
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", btn);
            try {
                btn.click();
            } catch (Exception e) {
                ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", btn);
            }
        } catch (TimeoutException ignored) {

        }

    }
}