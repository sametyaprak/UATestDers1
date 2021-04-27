package pages.easiyseleniumpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US10Page {
    public US10Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='round-tabs four']")
    public WebElement advancedLevelLink;
    @FindBy(xpath = "(//*[.='Drag & Drop Sliders'])[5]")
    public WebElement dragAndDropSlidersLink;
    @FindBy(xpath = "//output[@id='range']")
    public WebElement getDefaultValue10;
    @FindBy(xpath = "//input[@type='range']")
    public List<WebElement>actionForInput;
    @FindBy(xpath = "//output[@id='rangeSuccess']")
    public WebElement greenResult;
    @FindBy(xpath = "//output[@id='rangeDanger']")
    public WebElement redResult;


}
