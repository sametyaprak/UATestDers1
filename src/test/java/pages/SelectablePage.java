package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SelectablePage {
    public SelectablePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[.='Selectable'])[3]")
    public WebElement selectableLink;
    @FindBy(xpath = "//li[@class='ui-widget-content ui-selectee']")
    public List<WebElement> selectableIcons;
    @FindBy(xpath = "//*[.='Display as grid']")
    public WebElement displayAsGridLink;
    @FindBy(xpath = "//li[@class='ui-state-default ui-selectee']")
    public List<WebElement> selectableNumberBox;
    @FindBy(xpath = "//*[.='Serialize']")
    public WebElement serializeLink;
    @FindBy(id = "select-result")
    public WebElement resultNumber;


}
