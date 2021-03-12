package tests.easiyseleniumtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.easiyseleniumpage.AlertsPage;
import pages.easiyseleniumpage.DropdownPage;
import pages.easiyseleniumpage.US04Page;
import utilities.Driver;
import utilities.ReusableMethods;

public class US04Test {

    String url = "https://www.seleniumeasy.com/test/";
    DropdownPage dropdownTest = new DropdownPage();
    AlertsPage alertsPage = new AlertsPage();
    Actions actions = new Actions(Driver.getDriver());
    US04Page us04Page = new US04Page();
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
        us04Page.intermediateLevel.click();
        ReusableMethods.waitFor(1);
    }

    @Test
    public void TC0401 () {
        wrapUp();
        us04Page.ajaxFormSubmitLink.click();
        us04Page.nameTextBox.sendKeys("merhaba");
        us04Page.commentTextBox.sendKeys("burasi comment textbox");
        us04Page.submitButton.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(us04Page.submitControlText.getText().contains("Form submited Successfully!"));
    }
    @Test
    public void TC0402 () {
        wrapUp();
        us04Page.jquerySelectDropdown.click();
        Select options = new Select(us04Page.selectCountryDropdown);
        options.selectByVisibleText("United States of America");
        Assert.assertEquals(options.getFirstSelectedOption().getText(),"United States of America");
        us04Page.multipleSelectTextBox.sendKeys("Michigan");
        actions.sendKeys(Keys.ENTER).perform();
        Select options2 = new Select(us04Page.dropdownUSTeritories);
        options2.selectByIndex(5);
        Assert.assertEquals(options2.getFirstSelectedOption().getText(),"Virgin Islands");
        Select options3 = new Select(us04Page.relatedOptionsDropdown);
        options3.selectByIndex(4);
        Assert.assertEquals(options3.getFirstSelectedOption().getText(),"Java");
    }
    @Test
    public void TC0403 () {
        wrapUp();
        us04Page.bootstrapLink.click();
        us04Page.allSelectableItems.get(0).click();
        us04Page.moveRightArrow.click();
        ReusableMethods.waitFor(1);
        us04Page.allSelectableItems.get(4).click();
        us04Page.activeSelectedItemsList.get(1).click();
        us04Page.moveLeftArrow.click();
        us04Page.activeSelectedItemsList.get(0).click();
        Assert.assertEquals(us04Page.allSelectableItems.get(0).getText(),"Dapibus ac facilisis in");
        Assert.assertEquals(us04Page.allSelectableItems.get(9).getText(),"bootstrap-duallist");

    }



}
