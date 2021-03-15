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
import pages.easiyseleniumpage.US05Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.*;

public class US05Test {
    String url = "https://www.seleniumeasy.com/test/";
    DropdownPage dropdownTest = new DropdownPage();
    AlertsPage alertsPage = new AlertsPage();
    Actions actions = new Actions(Driver.getDriver());
    US04Page us04Page = new US04Page();
    US05Page us05Page = new US05Page();
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
    public void TC0501(){
        wrapUp();
        us05Page.jqueryListBoxLink.click();
        Select options = new Select(us05Page.leftDropbox);
        options.selectByVisibleText("Valentina");
        us05Page.addButton.click();
        options.selectByVisibleText("Giovanna");
        us05Page.addButton.click();
        options.selectByVisibleText("Helena");
        us05Page.addButton.click();
        options.selectByVisibleText("Lara");
        us05Page.addButton.click();
        options.selectByVisibleText("Julia");
        us05Page.addButton.click();
        Assert.assertEquals(us05Page.leftList.size(),10);
        Assert.assertEquals(us05Page.rightList.size(),5);
    }
    @Test
    public void TC0502(){
        wrapUp();
        us05Page.dataListFilterLink.click();
        Assert.assertEquals(us05Page.emailsAndPhoneNumbers.size()/2,us05Page.personsCard.size());
        us05Page.dataInputBox.sendKeys("Brian Hoyies");
        Assert.assertTrue(us05Page.personsCardName.get(3).getText().contains("Brian Hoyies"));
    }
    @Test
    public void TC0503() throws IOException {
        wrapUp();
        us05Page.fileDownloadLink.click();
        ReusableMethods.waitFor(2);
        us05Page.textBox.sendKeys("Selenium practice yapiyorum!");
        Assert.assertTrue(us05Page.characterNumber.getText().contains("472"));
        us05Page.geerateFileButton.click();
        us05Page.downloadLink.click();
        File file = new File("C:\\Users\\samet\\Downloads\\easyinfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        Assert.assertEquals(br.readLine(),"Selenium practice yapiyorum!");
    }
}

