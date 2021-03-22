package tests.otherstests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.otherspage.SelectablePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class SelectableTest {

    SelectablePage selectablePage = new SelectablePage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void beforeMethod() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.signInException();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        selectablePage.selectableLink.click();
    }

    @Test
    public void defaultFunctionality() {
        Driver.getDriver().switchTo().frame(0);
        for (WebElement w : selectablePage.selectableIcons) {
            w.click();
            Assert.assertEquals(w.getAttribute("class"), "ui-widget-content ui-selectee ui-selected");
            Assert.assertEquals(w.getCssValue("background-color"), "rgba(243, 152, 20, 1)");
        }
    }

    @Test
    public void displayAsGrid() {
        selectablePage.displayAsGridLink.click();
        Driver.getDriver().switchTo().frame(1);
        for (WebElement w : selectablePage.selectableNumberBox) {
            w.click();
            Assert.assertEquals(w.getAttribute("class"), "ui-state-default ui-selectee ui-selected");
            Assert.assertEquals(w.getCssValue("background-color"), "rgba(243, 152, 20, 1)");
        }
    }

    @Test
    public void serialize() {
        selectablePage.serializeLink.click();
        Driver.getDriver().switchTo().frame(2);
        int result =1;
        for (WebElement w : selectablePage.selectableIcons) {
            w.click();
            Assert.assertEquals(w.getAttribute("class"), "ui-widget-content ui-selectee ui-selected");
            Assert.assertEquals(w.getCssValue("background-color"), "rgba(243, 152, 20, 1)");
            Assert.assertEquals(Integer.parseInt(selectablePage.resultNumber.getText().substring(1)),result);
            result++;
        }
    }
}
