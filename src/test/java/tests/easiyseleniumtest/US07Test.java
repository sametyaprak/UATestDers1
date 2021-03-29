package tests.easiyseleniumtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.easiyseleniumpage.*;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US07Test {
    String url = "https://www.seleniumeasy.com/test/";
    DropdownPage dropdownTest = new DropdownPage();
    AlertsPage alertsPage = new AlertsPage();
    Actions actions = new Actions(Driver.getDriver());
    US07Page us07Page = new US07Page();
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
        us07Page.advancedLevelLink.click();
        ReusableMethods.waitFor(1);
    }
    @Test
    public void tc0701(){
        wrapUp();
        us07Page.tableFilterLink.click();
        ReusableMethods.waitFor(1);
        Assert.assertEquals(us07Page.allCards.size(),5);
        us07Page.orangeButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertEquals(us07Page.orangeCards.size(),2);
    }
    @Test
    public void tc0702(){
        wrapUp();
        us07Page.tableSortSearch.click();
        ReusableMethods.waitFor(1);
        Select dropbox = new Select(us07Page.pageDropbox);
        dropbox.selectByVisibleText("100");
        Assert.assertEquals(us07Page.pageDataInformation.getText(),"Showing 1 to 32 of 32 entries");
    }
    @Test
    public void tc0703(){
        wrapUp();
        us07Page.tableSortSearch.click();
        ReusableMethods.waitFor(1);
        Select dropbox = new Select(us07Page.pageDropbox);
        dropbox.selectByVisibleText("100");
        us07Page.salaryOrderLink.click();
        ReusableMethods.waitFor(1);
        us07Page.salaryOrderLink.click();
        List<Integer>allSalaryList = new ArrayList<>();
        for(WebElement w:us07Page.allSalaryData){
            int salary = Integer.parseInt(w.getText().substring(1,w.getText().length()-2).replace(",",""));
            if(salary>200000)
            allSalaryList.add(salary);
        }
        Assert.assertEquals(allSalaryList.size(),18);
        List<String>allCityData = new ArrayList<>();
        for(WebElement w:us07Page.allCityData){
            if(w.getText().equals("Tokyo")){
                allCityData.add(w.getText());
            }
        }
        Assert.assertEquals(allCityData.size(),4);

    }
}
