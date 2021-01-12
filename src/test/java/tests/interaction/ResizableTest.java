package tests.interaction;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.interaction.ResiablePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class ResizableTest {
    ResiablePage resiablePage = new ResiablePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void defaultFuncionality (){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.signInException();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        resiablePage.resiableLink.click();
        resiablePage.defaultFunctionalityLink.click();
        Driver.getDriver().switchTo().frame(0);
        Assert.assertEquals(resiablePage.resizableBoxDefaultFunctionality.get(0).getAttribute("class"),"ui-widget-content ui-resizable");
        Assert.assertFalse(resiablePage.resizableBoxDefaultFunctionality.get(0).getAttribute("style").contains("width"));
        actions.clickAndHold(resiablePage.resizableIcon.get(0)).perform();
        actions.moveByOffset(200,100).perform();
        Assert.assertEquals(resiablePage.resizableBoxMoveAssertionIndex.getAttribute("style"),"width: 350px; height: 250px;");
        Assert.assertTrue(resiablePage.resizableBoxDefaultFunctionality.get(0).getAttribute("style").contains("width"));
        actions.release();
    }
    @Test
    public void animate(){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.signInException();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        resiablePage.resiableLink.click();
        resiablePage.animeLink.click();
        Driver.getDriver().switchTo().frame(1);
        Assert.assertEquals(resiablePage.resizableBoxDefaultFunctionality.get(0).getAttribute("class"),"ui-widget-content ui-resizable");
        Assert.assertFalse(resiablePage.resizableBoxDefaultFunctionality.get(0).getAttribute("style").contains("width"));
        actions.clickAndHold(resiablePage.resizableIcon.get(0)).perform();
        actions.moveByOffset(200,200).perform();
        Assert.assertTrue(resiablePage.resizableHelper.isDisplayed());
        Assert.assertFalse(resiablePage.resizableBoxDefaultFunctionality.get(0).getAttribute("style").contains("width"));
        actions.click(resiablePage.resizableBoxDefaultFunctionality.get(0)).perform();
        Assert.assertEquals(resiablePage.resizableBoxDefaultFunctionality.get(0).getAttribute("class"),"ui-widget-content ui-resizable");
    }


}
