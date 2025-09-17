package com.myFleet.pages;

import com.myFleet.utilities.BrowserUtils;
import com.myFleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage_AlinaK extends BasePage {
    public CalendarPage_AlinaK() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@title='Create Calendar event']")
    public WebElement createButton;


    // @FindBy (xpath = "//input[contains(@id,'recurrence-repeat-view')]")
    // public WebElement repeatButton;


    @FindBy(xpath = "//input[@data-name='recurrence-repeat']")
    public WebElement repeatButton;

    @FindBy(xpath = "//input[@class='recurrence-subview-control__number'][1]")
    public WebElement inputField;

    @FindBy(xpath = "//span[contains(@id,'temp-validation-name')]")
    public WebElement errorMessage;


    public void createCalendarRepeat() {
        BrowserUtils.sleep(5);
        createButton.click();
        BrowserUtils.waitForClickablility(repeatButton, 5);
        repeatButton.click();

    }


}
