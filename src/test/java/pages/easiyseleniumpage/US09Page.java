package pages.easiyseleniumpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US09Page {

    public US09Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='round-tabs four']")
    public WebElement advancedLevelLink;
    @FindBy(xpath = "(//*[.='JQuery Download Progress bars'])[5]")
    public WebElement jqueryDownload;
    @FindBy(id = "downloadButton")
    public WebElement downloadButton;
    @FindBy(id = "progressbar")
    public WebElement progressbar;
    @FindBy(xpath = "//div[@aria-valuenow='100']")
    public WebElement progressBarVolume;
    @FindBy(xpath = "//*[.='Bootstrap Download Progress bar']")
    public WebElement bootstrapProgressBar;
    @FindBy(id = "cricle-btn")
    public WebElement circleButtonDownload;
    @FindBy(xpath = "//div[.='65%']")
    public WebElement percent65;
    @FindBy(xpath = "//div[.='100%']")
    public WebElement percent100;
    @FindBy(xpath = "//div[@class='percenttext']")
    public WebElement percentShow;
}
