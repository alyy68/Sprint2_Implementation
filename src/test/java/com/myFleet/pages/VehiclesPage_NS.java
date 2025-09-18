package com.myFleet.pages;

import com.myFleet.utilities.BrowserUtils;
import com.myFleet.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclesPage_NS extends BasePage{

    public VehiclesPage_NS(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//div[@class='more-bar-holder'])[1]")
    public WebElement firstThreeDots;

    @FindBy(xpath = "(//a[@title='View'])[1]")
    public WebElement viewOption;
    @FindBy (xpath = "(//a[@title='Edit'])[1]")
    public WebElement editOption;
    @FindBy(xpath = "(//a[@title='Delete'])[1]")
    public WebElement deleteOption;





}
