package tests.easiyseleniumtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.easiyseleniumpage.AlertsPage;
import pages.easiyseleniumpage.DropdownPage;
import pages.easiyseleniumpage.US10Page;
import pages.easiyseleniumpage.US11Page;
import utilities.Driver;
import utilities.ReusableMethods;

public class US11Test {
    String url = "https://www.seleniumeasy.com/test/";
    DropdownPage dropdownTest = new DropdownPage();
    Actions actions = new Actions(Driver.getDriver());
    US11Page us11Page = new US11Page();

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
        us11Page.advancedLevelLink.click();
        ReusableMethods.waitFor(1);
    }
    @Test
    void tc1101(){
        wrapUp();
        ReusableMethods.waitFor(1);
        us11Page.drangAndDropLink.click();
        ReusableMethods.waitFor(1);
        actions.clickAndHold(us11Page.draggableElements).perform();
        ReusableMethods.waitFor(1);
        actions.moveToElement(us11Page.dropArea).perform();
    }
}
