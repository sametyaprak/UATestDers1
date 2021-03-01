package pages.easiyseleniumpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AlertsPage {

    public AlertsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@href='./javascript-alert-box-demo.html'])[3]")
    public WebElement javaAlertsLink;
    @FindBy(xpath = "//button[@class='btn btn-default']")
    public WebElement clickMeButton;
    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    public List<WebElement> clickPromtBox;
    @FindBy(id = "confirm-demo")
    public WebElement youPressedCancelMessage;
    @FindBy(id = "prompt-demo")
    public WebElement dataControlPlace;


}
