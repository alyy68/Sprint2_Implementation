package com.myFleet.pages;

import com.myFleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleContractsPage_MB extends BasePage {
    public VehicleContractsPage_MB() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//table[contains(@class,'grid')]")
    public WebElement gridTable;

    @FindBy(xpath = "//div[contains(@class,'flash-messages')]//div[contains(@class,'alert')]")
    public WebElement permissionMessage;

}
