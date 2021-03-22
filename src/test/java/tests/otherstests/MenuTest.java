package tests.otherstests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.otherspage.MenuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class MenuTest {

    MenuPage menuPage = new MenuPage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void beforeMethod() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.signInException();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        menuPage.menuLink.click();
    }

    @Test
    public void defaultFunctionality() {
        Driver.getDriver().switchTo().frame(0);
        actions.clickAndHold(menuPage.allHoverElements.get(0)).perform();
        Assert.assertEquals(menuPage.allItems.get(1).getCssValue("background-color"), "rgba(218, 218, 218, 1)");
    }

    @Test
    public void menuWithSubMenu() {
        menuPage.menuWithSubmenuLink.click();
        Driver.getDriver().switchTo().frame(1);
//        actions.moveToElement(menuPage.allHovers.get(0)).perform();
//        System.out.println(menuPage.allHovers.get(0).getText());
//        actions.moveToElement(menuPage.allHovers.get(1)).perform();
//        System.out.println(menuPage.allHovers.get(1).getText());
//        actions.moveToElement(menuPage.allHovers.get(1)).moveToElement(menuPage.allHovers.get(2)).perform();
//        System.out.println(menuPage.allHovers.get(1).getText());
        int arr1[] = {0, 1, 6, 7, 12, 17};
        WebElement arr2[] = {menuPage.submenu1, menuPage.submenu2, menuPage.submenu3, menuPage.submenu4};
        int arr3[] = {1, 7, 12};

        for (int i = 0; i < arr1.length; i++) {
            actions.moveToElement(menuPage.allHovers.get(arr1[i])).perform();
        }
        for (int i = 0; i < arr3.length; i++) {
            ReusableMethods.waitFor(2);
            actions.moveToElement(menuPage.allHovers.get(arr3[i])).perform();
            for (int j = 0; j < arr2.length; j++) {
                ReusableMethods.waitFor(3);
                actions.moveToElement(menuPage.allHovers.get(arr3[i])).moveToElement(arr2[j]).perform();
            }
        }

    }
}
