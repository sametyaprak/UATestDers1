package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AutoCompletePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.HashSet;
import java.util.Set;

public class AutoCompleteTest {

    AutoCompletePage autoCompletePage = new AutoCompletePage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void beforeMethod() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation"));
        ReusableMethods.signInException();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        autoCompletePage.autoCompleteLink.click();
    }
    @Test
    public void defaultFuncionality() {
        Set<String> myAllData = new HashSet<>();
        Driver.getDriver().switchTo().frame(0);
        for (int i = 97; i < 123; i++) {
            autoCompletePage.textBox1.sendKeys((char) i + "");
            ReusableMethods.waitFor(1);
            for (WebElement w : autoCompletePage.listOfAllData) {
                if (!w.getText().equals("")) {
                    Assert.assertTrue(w.getText().contains((char) i + "")
                            || w.getText().contains((char) (i - 32) + ""));
                    myAllData.add(w.getText());
                }
            }
            autoCompletePage.textBox1.clear();
        }
            System.out.println(myAllData);
            System.out.println(myAllData.size());
        }
    }
