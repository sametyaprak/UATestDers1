package tests;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SortablePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class SortableTest {
    Actions actions = new Actions(Driver.getDriver());
    SortablePage sortablePage = new SortablePage();

    @BeforeMethod
    public void beforeMethod(){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.signInException();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        sortablePage.sortableLink.click();
    }
    @Test
    public void defaultFunctionality(){
        Driver.getDriver().switchTo().frame(0);
        int y=6;
        for (int i=0;i<7;i++){
            actions.clickAndHold(sortablePage.itemsToMove.get(0)).perform();
            actions.moveToElement(sortablePage.itemsToMove.get(y),0,10).perform();
            actions.release().perform();
            Assert.assertEquals(Integer.parseInt(sortablePage.itemsToMove2.get(y).getText().substring(5))-1,i);
            y--;
        }
    }
    @Test
    public void connectLists(){
        sortablePage.connectListLink.click();
        Driver.getDriver().switchTo().frame(1);
        for(int i=0;i<5;i++){
            actions.clickAndHold(sortablePage.itemsToMove4.get(i)).perform();
            actions.moveToElement(sortablePage.itemsToMove3.get(i),0,10).perform();
            actions.release().perform();
        }
        Assert.assertTrue(sortablePage.listAllTexts.getText().isEmpty());
    }
    @Test
    public void displayAsGrid(){
        sortablePage.connectListLink.click();
        sortablePage.displayAsGridLink.click();
        Driver.getDriver().switchTo().frame(2);
            for (int i=0;i<4;i++){
                actions.clickAndHold(sortablePage.itemsToMove3.get(0)).perform();
                actions.moveToElement(sortablePage.itemsToMove3.get(3-i),10,0).perform();
                actions.release().perform();
                Assert.assertEquals(Integer.parseInt(sortablePage.itemsToMove3.get(3-i).getText()),i+1);
                actions.clickAndHold(sortablePage.itemsToMove3.get(4)).perform();
                actions.moveToElement(sortablePage.itemsToMove3.get(7-i),10,0).perform();
                actions.release().perform();
                Assert.assertEquals(Integer.parseInt(sortablePage.itemsToMove3.get(7-i).getText()),i+5);
                actions.clickAndHold(sortablePage.itemsToMove3.get(8)).perform();
                actions.moveToElement(sortablePage.itemsToMove3.get(11-i),10,0).perform();
                actions.release().perform();
                Assert.assertEquals(Integer.parseInt(sortablePage.itemsToMove3.get(11-i).getText()),i+9);
        }
    }

}
