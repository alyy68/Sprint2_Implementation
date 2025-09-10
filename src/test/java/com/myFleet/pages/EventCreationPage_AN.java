package com.myFleet.pages;

import com.myFleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventCreationPage_AN {


    public EventCreationPage_AN() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement saveAndCloseButton;

    //this iframe ID is dynamic
    @FindBy(xpath = "//iframe[contains(@id,'oro_calendar_event_form_description-uid')]")
    public WebElement descriptionboxIframe;

    //@FindBy(xpath = "//body[@id='tinymce']")
    @FindBy(xpath = "//body[@class='mce-content-body ']")
    public WebElement descitptionBoxText;

    /* // just for test
    @FindBy(xpath = "//p")
    public WebElement descitptionBoxText2;
     */




}
