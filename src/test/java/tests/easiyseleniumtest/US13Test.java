package tests.easiyseleniumtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.easiyseleniumpage.DropdownPage;
import pages.easiyseleniumpage.US13Page;
import utilities.Driver;
import utilities.ReusableMethods;

public class US13Test {
    String url = "https://www.seleniumeasy.com/test/";
    DropdownPage dropdownTest = new DropdownPage();
    Actions actions = new Actions(Driver.getDriver());
    US13Page us13Page = new US13Page();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);

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
        us13Page.advancedLevelLink.click();
        ReusableMethods.waitFor(1);
    }
    @Test
    void tc1101(){
        wrapUp();
        ReusableMethods.waitFor(1);
        us13Page.chartsDemoLink.click();
    }
}
