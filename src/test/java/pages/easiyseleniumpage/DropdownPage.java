package pages.easiyseleniumpage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.easiyseleniumtest.DropdownTest;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DropdownPage {

    String url = "https://www.seleniumeasy.com/test/";
    DropdownTest dropdownTest = new DropdownTest();
    Actions actions = new Actions(Driver.getDriver());
    List<String> days = new ArrayList<>(Arrays.
            asList("","Sunday","Monday","Tuesday", "Wednesday", "Thursday","Friday","Saturday" ));
    List<String> cityes = new ArrayList<>(Arrays.
            asList("California","Florida","New Jersey", "New York", "Ohio","Texas","Pennsylvania","Washington" ));

    public void wrapUp(){
        Driver.getDriver().get(url);
        dropdownTest.alertClose.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        dropdownTest.startPractisingLink.click();
        ReusableMethods.waitFor(1);
        dropdownTest.inputForms.click();
        ReusableMethods.waitFor(1);
        dropdownTest.selectDropdownList.click();
    }

    @Test
    public void TC02001(){
        wrapUp();
        Assert.assertEquals(dropdownTest.selectListDemoHeader.getText(),"Select List Demo");
        Assert.assertTrue(dropdownTest.selectListDemoHeader.isDisplayed());
    }
    @Test
    public void TC02002(){
        wrapUp();
        Select options = new Select(dropdownTest.daysDropbox);
        for (int i=0;i<cityes.size();i++){
            ReusableMethods.waitFor(1);
            options.selectByIndex(i);
            Assert.assertTrue(dropdownTest.selectedDayText.getText().contains(days.get(i)));
        }
    }
    @Test
    public void TC02003(){
        wrapUp();
        Select options = new Select(dropdownTest.cityesDropbox);
        for (int i=0;i<cityes.size();i++){
            ReusableMethods.waitFor(1);
            options.selectByIndex(i);
            dropdownTest.printMeOne.click();
            Assert.assertTrue(dropdownTest.cityesResultText.getText().contains(cityes.get(i)));
        }
    }


    @Test
    public void TC02004(){
        wrapUp();
        Select options = new Select(dropdownTest.cityesDropbox);
        for (int i=0;i<cityes.size();i++){
            ReusableMethods.waitFor(1);
//            actions.clickAndHold(dropdownTest.allselectables.get(8));
//            actions.clickAndHold(dropdownTest.allselectables.get(9+i));
            dropdownTest.printMeAll.click();
            //Assert.assertTrue(dropdownTest.cityesResultText.getText().contains(cityes.get(i)));
        }
    }


}
