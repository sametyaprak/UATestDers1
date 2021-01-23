package pages.widget;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AccordionPage {
    public AccordionPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[.='Accordion'])[3]")
    public WebElement accordionPageLink;
    @FindBy(xpath = "//*[.='Customize icons']")
    public WebElement customizeIconsLink;
    @FindBy(xpath = "//*[.='Fill Space']")
    public WebElement fillSpaceLink;
    @FindBy(xpath = "//*[@role='tabpanel']")
    public List<WebElement> allText;
    @FindBy(xpath = "//h3[@role='tab']")
    public List<WebElement> allTabs;
    @FindBy(xpath = "//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")
    public WebElement clickToMoveArrow;
}
