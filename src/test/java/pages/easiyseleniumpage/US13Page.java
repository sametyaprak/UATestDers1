package pages.easiyseleniumpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

    public class US13Page {
        public US13Page (){
            PageFactory.initElements(Driver.getDriver(),this);
        }
        @FindBy(xpath = "//span[@class='round-tabs four']")
        public WebElement advancedLevelLink;
        @FindBy(xpath = "(//*[.='Charts Demo'])[5]")
        public WebElement chartsDemoLink;
    }


