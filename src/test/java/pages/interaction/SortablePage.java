package pages.interaction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SortablePage {
    public SortablePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[.='Sortable'])[3]")
    public WebElement sortableLink;
    @FindBy(xpath = "//span[@class='ui-icon ui-icon-arrowthick-2-n-s']")
    public List<WebElement> itemsToMove;
    @FindBy(xpath = "//li[@class='ui-state-default ui-sortable-handle']")
    public List<WebElement> itemsToMove2;

    @FindBy(xpath = "//*[.='Connect Lists']")
    public WebElement connectListLink;
    @FindBy(xpath = "//li[@class='ui-state-default ui-sortable-handle']")
    public List<WebElement> itemsToMove3;
    @FindBy(xpath = "//li[@class='ui-state-highlight ui-sortable-handle']")
    public List<WebElement> itemsToMove4;
    @FindBy(id = "sortable2")
    public WebElement listAllTexts;
    @FindBy(xpath = "//*[.='Display as grid']")
    public WebElement displayAsGridLink;
}
