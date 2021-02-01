package tests;



import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DraggablePage;
import utilities.ConfigReader;

import utilities.Driver;
import utilities.ReusableMethods;

public class DraggableTest {

    DraggablePage pageElements = new DraggablePage();
    Actions action = new Actions(Driver.getDriver());

    @Test
    public void Test01defaultFunctionality (){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.signInException();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        pageElements.draggableLink.click();
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().frame(0);
        String valueBefore = pageElements.draggableBox.getAttribute("style");
        System.out.println(valueBefore);
        Assert.assertEquals(valueBefore,"position: relative;");
        action.clickAndHold(pageElements.draggableBox).perform();
        action.moveByOffset(100,150).perform();
        String valueAfter = pageElements.draggableBox.getAttribute("style");
        System.out.println(valueAfter);
        Assert.assertNotEquals(valueAfter,"position: relative;");
        Assert.assertTrue(valueAfter.contains("width"));
        Driver.getDriver().switchTo().defaultContent();
    }
    @Test
    public void Test02constrainMovement (){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.signInException();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        pageElements.draggableLink.click();
        ReusableMethods.waitFor(1);
        pageElements.constrainMovement.click();
        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.waitFor(2);
        action.clickAndHold(pageElements.draggableBox1).perform();
        action.moveByOffset(150,150).perform();
        action.release(pageElements.draggableBox1).perform();
        System.out.println(pageElements.draggableBox1.getAttribute("style"));
        Assert.assertTrue(pageElements.draggableBox1.getAttribute("style").contains("left: 0px"));
        action.clickAndHold(pageElements.draggableBox2).perform();
        action.moveByOffset(150,150).perform();
        action.release(pageElements.draggableBox2).perform();
        System.out.println(pageElements.draggableBox2.getAttribute("style"));
        Assert.assertTrue(pageElements.draggableBox2.getAttribute("style").contains("top: 0px"));
        Driver.getDriver().switchTo().defaultContent();
    }
    @Test
    public void Test03CursorStyle(){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.signInException();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        pageElements.draggableLink.click();
        ReusableMethods.waitFor(1);
        pageElements.curcorStyleLink.click();
        Driver.getDriver().switchTo().frame(2);
        action.clickAndHold(pageElements.cursorStyleBox1).perform();
        action.moveByOffset(100,100).perform();


    }

}
