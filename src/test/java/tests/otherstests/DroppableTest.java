package tests.otherstests;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.otherspage.DroppablePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class DroppableTest {

    DroppablePage droppablePage = new DroppablePage();
    Actions action = new Actions(Driver.getDriver());

   @Test
    public void dropableDefaultFunctionality (){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.signInException();
        ReusableMethods.waitFor(2);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        droppablePage.dropablePageLink.click();
        Driver.getDriver().switchTo().frame(0);
        Assert.assertEquals(droppablePage.dropableArea.getText(),"Drop here");
        action.clickAndHold(droppablePage.dropableBox1).perform();
        action.moveToElement(droppablePage.dropableArea).perform();
        action.release(droppablePage.dropableBox1).perform();
        Assert.assertEquals(droppablePage.dropableArea.getText(),"Dropped!");
    }
}
