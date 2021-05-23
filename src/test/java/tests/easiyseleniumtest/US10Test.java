package tests.easiyseleniumtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.easiyseleniumpage.AlertsPage;
import pages.easiyseleniumpage.DropdownPage;
import pages.easiyseleniumpage.US10Page;
import utilities.Driver;
import utilities.ReusableMethods;

public class US10Test {
    String url = "https://www.seleniumeasy.com/test/";
    DropdownPage dropdownTest = new DropdownPage();
    AlertsPage alertsPage = new AlertsPage();
    Actions actions = new Actions(Driver.getDriver());
    US10Page us10Page = new US10Page();
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
        us10Page.advancedLevelLink.click();
        ReusableMethods.waitFor(1);
    }
    @Test
    public void tc0901(){
        wrapUp();
        ReusableMethods.waitFor(1);
        us10Page.dragAndDropSlidersLink.click();
        ReusableMethods.waitFor(1);
        actions.clickAndHold(us10Page.actionForInput.get(0)).moveByOffset(-300,0).release().perform();
        Assert.assertEquals(us10Page.getDefaultValue10.getText(),"1");
    }
    @Test
    public void tc0902(){
        wrapUp();
        ReusableMethods.waitFor(1);
        us10Page.dragAndDropSlidersLink.click();
        for(int i=-100;i<100;i++){
            actions.clickAndHold(us10Page.actionForInput.get(2)).moveByOffset(i,0).release().perform();
            if(us10Page.greenResult.getText().equals("33")){
                break;
            }
        }
        Assert.assertEquals(us10Page.actionForInput.get(2).getAttribute("value"),"33");
    }
    @Test
    public void tc0903(){
        wrapUp();
        ReusableMethods.waitFor(1);
        us10Page.dragAndDropSlidersLink.click();
        ReusableMethods.waitFor(1);
        actions.clickAndHold(us10Page.actionForInput.get(5)).moveByOffset(300,0).release().perform();
        Assert.assertEquals(us10Page.redResult.getText(),"100");
    }
}
