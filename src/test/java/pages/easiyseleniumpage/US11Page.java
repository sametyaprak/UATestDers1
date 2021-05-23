package pages.easiyseleniumpage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US11Page {

    public US11Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='round-tabs four']")
    public WebElement advancedLevelLink;
    @FindBy(xpath = "(//a[.='Drag and Drop'])[3]")
    public WebElement drangAndDropLink;
    @FindBy(xpath = "//div[@id='todrag']/span")
    public WebElement draggableElements;
    @FindBy(xpath = "//div[@id='mydropzone']")
    public WebElement dropArea;
    @FindBy(xpath = "//div[@id='droppedlist']/span")
    public List<WebElement>allDroppedItems;
}
