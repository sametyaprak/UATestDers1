package tests.easiyseleniumtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.easiyseleniumpage.*;
import utilities.Driver;
import utilities.ReusableMethods;

public class US06Test {
    String url = "https://www.seleniumeasy.com/test/";
    DropdownPage dropdownTest = new DropdownPage();
    AlertsPage alertsPage = new AlertsPage();
    Actions actions = new Actions(Driver.getDriver());
    US04Page us04Page = new US04Page();
    US06Page us06Page = new US06Page();
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
        us06Page.advancedLevelLink.click();
        ReusableMethods.waitFor(1);
    }
    @Test
    public void TC0601(){
        wrapUp();
        us06Page.tablePaginationLink.click();
        Assert.assertEquals(us06Page.pageSelectionLinks.size()-2,3);
        Assert.assertTrue(us06Page.pageSelectionLinks.get(2).isEnabled());
        Assert.assertTrue(us06Page.pageSelectionLinks.get(3).isEnabled());
        Assert.assertTrue(us06Page.pageSelectionLinks.get(4).isEnabled());
        us06Page.pageSelectionLinks.get(2).click();
        Assert.assertTrue(us06Page.pageSelectionLinks.get(0).isEnabled());
        us06Page.pageSelectionLinks.get(1).click();
        Assert.assertEquals(us06Page.tableCells.size(),78);
    }
    @Test
    public void TC0602(){
        String arr = "# Task Assignee Status";
        wrapUp();
        us06Page.tableDataSearchLink.click();
        Assert.assertEquals(us06Page.textBox.getAttribute("placeholder"),"Filter by Task / Assignee / Status ");
        for (WebElement w : us06Page.tableHeaders)
        Assert.assertTrue(arr.contains(w.getText()));
        us06Page.textBox.sendKeys("Mike");
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us06Page.resultRow.getText().contains("Mike"));
    }

    @Test
    public void TC0603(){
        wrapUp();
        us06Page.tableDataSearchLink.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        for (int i=1;i<us06Page.inputTextBoxes.size();i++){
            Assert.assertFalse(us06Page.inputTextBoxes.get(i).isEnabled());
        }
        us06Page.filterLink.click();
        ReusableMethods.waitFor(1);
        for (WebElement w : us06Page.inputTextBoxes){
            Assert.assertTrue(w.isEnabled());
        }
        us06Page.inputTextBoxes.get(3).sendKeys("B");
        for(WebElement w : us06Page.result2){
            Assert.assertTrue(w.getText().startsWith("B"));
            System.out.println(w.getText());
            Assert.assertTrue(w.getText().contains("Brigade")||w.getText().contains("Byron") );
        }
    }

}
