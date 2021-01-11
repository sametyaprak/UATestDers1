package pages.interaction;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ResiablePage {
    public ResiablePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
