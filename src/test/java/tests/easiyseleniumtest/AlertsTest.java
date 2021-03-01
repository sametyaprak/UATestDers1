package tests.easiyseleniumtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.easiyseleniumpage.AlertsPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class AlertsTest {

    String url = "https://www.seleniumeasy.com/test/";
    DropdownTest dropdownTest = new DropdownTest();
    AlertsPage alertsPage = new AlertsPage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void beforeTest(){
        Driver.getDriver().get(url);
        dropdownTest.alertClose.click();
    }

    public void wrapUp(){
        Driver.getDriver().get(url);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        dropdownTest.startPractisingLink.click();
        ReusableMethods.waitFor(1);
        dropdownTest.inputForms.click();
        ReusableMethods.waitFor(1);
        alertsPage.javaAlertsLink.click();
    }


    @Test
    public void TC0301 () {
        wrapUp();
    }
    @Test
    public void TC0302 () {
        wrapUp();
        ReusableMethods.waitFor(1);
        alertsPage.clickMeButton.click();
        ReusableMethods.waitFor(2);
        Assert.assertEquals("I am an alert box!", Driver.getDriver().switchTo().alert().getText());
        Driver.getDriver().switchTo().alert().accept();
    }
    @Test
    public void TC0303(){
        wrapUp();
        ReusableMethods.waitFor(1);
        alertsPage.clickPromtBox.get(0).click();
        Driver.getDriver().switchTo().alert().dismiss();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(alertsPage.youPressedCancelMessage.isDisplayed());
    }
    @Test
    public void TC0304(){
        String contolData = "samet";
        wrapUp();
        ReusableMethods.waitFor(1);
        alertsPage.clickPromtBox.get(1).click();
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().alert().sendKeys(contolData);
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertTrue(alertsPage.dataControlPlace.getText().contains(contolData));
    }
}
