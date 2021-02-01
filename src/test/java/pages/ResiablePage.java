package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ResiablePage {
    public ResiablePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[.='Resizable']")
    public WebElement resiableLink;
    @FindBy(xpath = "//*[.='Default functionality']")
    public WebElement defaultFunctionalityLink;
    @FindBy(xpath = "//div[@id='resizable']")
    public List<WebElement> resizableBoxDefaultFunctionality;
    @FindBy(xpath = "//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")
    public List<WebElement> resizableIcon;
    @FindBy(xpath = "//div[@id='resizable']")
    public WebElement resizableBoxMoveAssertionIndex;
    @FindBy(xpath = "//*[.='Animate']")
    public WebElement animeLink;
    @FindBy(xpath = "//div[@class='ui-resizable-helper']")
    public WebElement resizableHelper;

}
