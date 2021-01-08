package pages.interaction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DroppablePage {
    public DroppablePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[.='Signin']")
    public WebElement signInLink;
    @FindBy(xpath = "(//input[@name='username'])[2]")
    public WebElement usernameEntry;
    @FindBy(xpath = "(//input[@name='password'])[2]")
    public WebElement passwordEntry;
    @FindBy(xpath = "(//input[@value='Submit'])[2]")
    public WebElement submitButton;
    @FindBy(xpath = "//h2[.='Droppable']")
    public WebElement dropablePageLink;
    @FindBy(xpath = "(//div[@id='draggable'])[1]")
    public WebElement dropableBox1;
    @FindBy(xpath = "//div[@id='droppable']")
    public WebElement dropableArea;
}
