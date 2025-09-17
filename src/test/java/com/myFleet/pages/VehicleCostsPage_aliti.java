package com.myFleet.pages;

import com.myFleet.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class VehicleCostsPage_aliti {

    public VehicleCostsPage_aliti() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public List<String> loopForColumns() {
        List<WebElement> columnElements = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            WebElement column = Driver.getDriver().findElement(By.xpath("//table/thead//th[" + i + "]"));
            columnElements.add(column);
        }
        List<String> columnNames = new ArrayList<>();
        for (WebElement each : columnElements) {
            columnNames.add(each.getText());
        }
        return columnNames;
    }

    @FindBy(xpath = "//thead//input")
    public WebElement firstCheckbox;



    public boolean list() {
        List<WebElement> rows = Driver.getDriver().findElements(By.xpath("//table/tbody/tr//input"));
        for (WebElement each : rows) {
            if (!each.isSelected()) {
                return false;
            }
        }
        return true;
    }

}
