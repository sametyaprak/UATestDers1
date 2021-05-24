package tests.easiyseleniumtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.easiyseleniumpage.DropdownPage;
import pages.easiyseleniumpage.US12Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.HashSet;
import java.util.Set;

public class US12Test {
    String url = "https://www.seleniumeasy.com/test/";
    DropdownPage dropdownTest = new DropdownPage();
    Actions actions = new Actions(Driver.getDriver());
    US12Page us12Page = new US12Page();
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
        us12Page.advancedLevelLink.click();
        ReusableMethods.waitFor(1);
    }
    @Test
    void tc1101(){
        wrapUp();
        ReusableMethods.waitFor(1);
        us12Page.dynamicDataLoading.click();
        us12Page.getNewUserLink.click();
        wait.until(ExpectedConditions.visibilityOf(us12Page.profilePhoto));
        ReusableMethods.waitFor(2);
        Assert.assertTrue(us12Page.profilePhoto.isDisplayed());
    }
    @Test
    void tc1102(){
        wrapUp();
        ReusableMethods.waitFor(1);
        us12Page.dynamicDataLoading.click();
        us12Page.getNewUserLink.click();
        wait.until(ExpectedConditions.visibilityOf(us12Page.profilePhoto));
        ReusableMethods.waitFor(2);
        Assert.assertTrue(us12Page.resultTexts.getText().contains("First Name"));
        Assert.assertTrue(us12Page.resultTexts.getText().contains("Last Name"));
    }
    @Test
    void tc1103(){
        wrapUp();
        ReusableMethods.waitFor(1);
        us12Page.dynamicDataLoading.click();
        Set<String>allNames = new HashSet<>();
        for(int i=0;i<3;i++){
            us12Page.getNewUserLink.click();
            wait.until(ExpectedConditions.visibilityOf(us12Page.profilePhoto));
            ReusableMethods.waitFor(2);
            String data = us12Page.resultTexts.getText().substring(us12Page.resultTexts.getText().indexOf("First"),
                    us12Page.resultTexts.getText().indexOf("Last"));
            allNames.add(data.trim().substring(13));
        }
        Assert.assertEquals(allNames.size(),3);
    }
}
