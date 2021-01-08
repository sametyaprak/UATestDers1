package pages.interaction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DraggablePage {

    public DraggablePage(){
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
    @FindBy(xpath = "//h2[.='Draggable']")
    public WebElement draggableLink;
    @FindBy(xpath = "(//div[@id='draggable'])[1]")
    public WebElement draggableBox;
    @FindBy(xpath = "//a[@href='#example-1-tab-2']")
    public WebElement constrainMovement;
    @FindBy(xpath = "//div[@id='draggable']")
    public WebElement draggableBox1;
    @FindBy(id = "draggable2")
    public WebElement draggableBox2;


}
