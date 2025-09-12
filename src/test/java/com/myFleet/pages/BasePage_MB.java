package com.myFleet.pages;

import com.myFleet.utilities.BrowserUtils;
import com.myFleet.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage_MB extends BasePage {

    public BasePage_MB() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void navigateToModuleMb(String tab, String module) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Actions actions = new Actions(Driver.getDriver());

        String tabLiXpath = "//li[contains(@class,'dropdown-level-1')][.//span[@class='title title-level-1' and normalize-space()='" + tab + "']]";
        String moduleXpath = "//span[@class='title title-level-2' and normalize-space()='" + module + "']";

        WebElement tabLi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tabLiXpath)));
        actions.moveToElement(tabLi).pause(Duration.ofMillis(300)).perform();

        WebElement moduleEl = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(moduleXpath)));
        try {
            moduleEl.click();
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", moduleEl);
        }

        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(10);

    }
}
