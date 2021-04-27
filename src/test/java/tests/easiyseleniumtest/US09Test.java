package tests.easiyseleniumtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.easiyseleniumpage.AlertsPage;
import pages.easiyseleniumpage.DropdownPage;
import pages.easiyseleniumpage.US08Page;
import pages.easiyseleniumpage.US09Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.HashSet;
import java.util.Set;

public class US09Test {
    String url = "https://www.seleniumeasy.com/test/";
    DropdownPage dropdownTest = new DropdownPage();
    AlertsPage alertsPage = new AlertsPage();
    Actions actions = new Actions(Driver.getDriver());
    US09Page us09Page = new US09Page();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

    @BeforeTest
    public void beforeTest(){
        Driver.getDriver().get(url);
        try{
            dropdownTest.alertClose.click();
        }
        catch (Exception e){

        }
    }

    public void wrapUp(){
        Driver.getDriver().get(url);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        dropdownTest.startPractisingLink.click();
        ReusableMethods.waitFor(1);
        us09Page.advancedLevelLink.click();
        ReusableMethods.waitFor(1);
    }
    @Test
    public void tc0901(){
        wrapUp();
        ReusableMethods.waitFor(1);
        us09Page.jqueryDownload.click();
        ReusableMethods.waitFor(1);
        us09Page.downloadButton.click();
        wait.until(ExpectedConditions.attributeToBe(us09Page.progressbar,"aria-valuenow","100"));
        Assert.assertTrue(us09Page.progressBarVolume.isDisplayed());
    }
    @Test
    public void tc0902(){
        wrapUp();
        ReusableMethods.waitFor(1);
        us09Page.bootstrapProgressBar.click();
        ReusableMethods.waitFor(1);
        us09Page.circleButtonDownload.click();
        wait.until(ExpectedConditions.visibilityOf(us09Page.percent65));
        Assert.assertEquals(us09Page.percentShow.getText(), "65%");
        wait.until(ExpectedConditions.visibilityOf(us09Page.percent100));
        Assert.assertEquals(us09Page.percentShow.getText(), "100%");


    }


}
