package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccordionPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;


public class AccordionTest {

    AccordionPage accordionPage = new AccordionPage();
    Actions actions = new Actions(Driver.getDriver());
    String data1 = "Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.";
    String data2 = "Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.";
    String data3 = "Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.\n" +
            "List item one\n" +
            "List item two\n" +
            "List item three";
    String data4 = "Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est.\n" +
            "Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.";

    static List<String> expectedTestData = new ArrayList<>();


    @BeforeMethod
    public void beforeMethod(){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.signInException();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        accordionPage.accordionPageLink.click();
    }
    @Test
    public void customizeIcons(){
        accordionPage.customizeIconsLink.click();
        expectedTestData.add(data1);
        expectedTestData.add(data2);
        expectedTestData.add(data3);
        expectedTestData.add(data4);
        Driver.getDriver().switchTo().frame(1);
        int i =0;
        for(WebElement w : accordionPage.allTabs){
            w.click();
            ReusableMethods.waitFor(1);
            Assert.assertEquals(accordionPage.allText.get(i).getText(),expectedTestData.get(i));
            i++;
        }

    }
    @Test
    public void fillSpace(){
        accordionPage.fillSpaceLink.click();
        expectedTestData.add(data1);
        expectedTestData.add(data2);
        expectedTestData.add(data3);
        expectedTestData.add(data4);
        Driver.getDriver().switchTo().frame(2);
        //actions.click(accordionPage.clickToMoveArrow).perform();
        ReusableMethods.waitFor(1);
        actions.clickAndHold(accordionPage.clickToMoveArrow).perform();
        actions.moveByOffset(600,0).release().build().perform();
        actions.release().build().perform();
        ReusableMethods.waitFor(1);
        int i =0;
        for(WebElement w : accordionPage.allTabs){
            w.click();
            ReusableMethods.waitFor(1);
            System.out.println(accordionPage.allText.get(i).getText());
            System.out.println(expectedTestData.get(i));
            Assert.assertTrue(accordionPage.allText.get(i).getText().contains(expectedTestData.get(i).substring(0,20)));
            i++;
        }

    }
}
