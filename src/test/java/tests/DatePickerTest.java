package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DatePickerPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class DatePickerTest {
    Actions actions = new Actions(Driver.getDriver());
    DatePickerPage page = new DatePickerPage();

    @BeforeMethod
    public void beforeMethod(){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.signInException();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        page.datePickerLink.click();
    }

    @Test
    public void animationsTest(){
        page.basicTabs.get(1).click();
        Driver.getDriver().switchTo().frame(1);
        Select dropbox = new Select(page.dateAnimationsDropbpx);
        for(int i=0;i<10;i++){
            dropbox.selectByIndex(i);
            Assert.assertFalse(dropbox.getFirstSelectedOption().getText().equals(null),"string is false");
        }
        dropbox.selectByIndex(3);
        page.dateSelectionBox.click();
        page.nextMonthTriangle.click();
        page.nextMonthTriangle.click();
        page.dayOfMonthList.get(20).click();
        Assert.assertTrue(page.dateSelectionBox.isDisplayed());
    }
    @Test
    public void displayMonthAndYearTest(){
        page.basicTabs.get(2).click();
        Driver.getDriver().switchTo().frame(2);
        page.dateSelectionBox.click();

        for(int i=0;i<12;i++){
            Select dropboxMonth = new Select(page.yearAndMonthDropboxes.get(0));
            dropboxMonth.selectByIndex(i);
        }
        for(int i=0;i<page.allYearsList.size();i++){
            Select dropboxYear = new Select(page.yearAndMonthDropboxes.get(1));
            ReusableMethods.waitFor(1);
            dropboxYear.selectByIndex(i);
        }
        System.out.println(page.allYearsList.size());
    }
}
