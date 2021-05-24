package pages.easiyseleniumpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US12Page {
    public US12Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='round-tabs four']")
    public WebElement advancedLevelLink;
    @FindBy(xpath = "(//*[.='Dynamic Data Loading'])[5]")
    public WebElement dynamicDataLoading;
    @FindBy(xpath = "//button[@id='save']")
    public WebElement getNewUserLink;
    @FindBy(xpath = "//*[.=' loading...']")
    public WebElement loadingInformationText;
    @FindBy(xpath = "//div[@id='loading']/img")
    public WebElement profilePhoto;
    @FindBy(xpath = "//div[@id='loading']")
    public WebElement resultTexts;
}
