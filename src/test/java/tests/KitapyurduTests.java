package tests;

import org.testng.annotations.Test;
import pages.KitapyurduPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class KitapyurduTests {

    KitapyurduPages pages = new KitapyurduPages(Driver.getDriver());
    @Test
    public void deneme(){
        Driver.getDriver().get(ConfigReader.getProperty("google"));
        ReusableMethods.waitFor(5);
        Driver.getDriver().switchTo().frame(0);
        pages.ichStimmeZu.click();
    }

}
