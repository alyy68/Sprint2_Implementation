package com.myFleet.pages;

import com.myFleet.utilities.BrowserUtils;
import com.myFleet.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehiclesPage_aliti {

    public VehiclesPage_aliti() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String checkBox = "//table//tbody/tr//input";

    @FindBy(xpath = "//table/thead//input")
    public WebElement firstCheckbox;







}
