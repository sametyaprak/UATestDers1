package tests.easiyseleniumtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.easiyseleniumpage.AlertsPage;
import pages.easiyseleniumpage.DropdownPage;
import pages.easiyseleniumpage.US08Page;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class US08Test {
    String url = "https://www.seleniumeasy.com/test/";
    DropdownPage dropdownTest = new DropdownPage();
    AlertsPage alertsPage = new AlertsPage();
    Actions actions = new Actions(Driver.getDriver());
    US08Page us08Page = new US08Page();

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
        us08Page.advancedLevelLink.click();
        ReusableMethods.waitFor(1);
    }
    @Test
    public void tc0801(){
        wrapUp();
        us08Page.tableDataDownload.click();
        ReusableMethods.waitFor(1);
        us08Page.dataSearchBox.sendKeys("2012");
        ReusableMethods.waitFor(2);
        Set<String>cityes = new HashSet<>();
        //us08Page.cityesColumn.stream().map(x-> x.getText()).forEach(x->cityes.add(x));
        us08Page.cityesColumn.stream().map(WebElement::getText).forEach(cityes::add);
        Assert.assertEquals(cityes.size(),4);
    }
    @Test
    public void tc0802(){
        wrapUp();
        us08Page.tableDataDownload.click();
        ReusableMethods.waitFor(1);
        us08Page.dataSearchBox.sendKeys("London");
        ReusableMethods.waitFor(2);
        us08Page.pdfButton.click();
        actions.sendKeys(Keys.ENTER).perform();
        File tempFile = new File("C:\\Users\\samet\\Downloads\\Selenium Easy - Download Table Data to CSV, Excel, PDF and Print.pdf");
        ReusableMethods.waitFor(1);
        Assert.assertTrue(tempFile.exists());
    }



}
