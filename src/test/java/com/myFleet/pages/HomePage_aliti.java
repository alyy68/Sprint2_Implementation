package com.myFleet.pages;

import com.myFleet.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage_aliti extends BasePage {

    public HomePage_aliti() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//li[@class='dropdown dropdown-level-1']/a/span)[1]")
    public WebElement fleetButton;

    @FindBy(xpath = "//span[text()='Vehicle Costs']")
    public WebElement vehicleCostsButton;

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

    @FindBy(xpath = "//div[text()='You do not have permission to perform this action.']")
    public WebElement message;

    @FindBy(xpath = "//button[@class='btn-primary']")
    public WebElement goBackButton;



}
