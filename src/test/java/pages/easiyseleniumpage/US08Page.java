package pages.easiyseleniumpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US08Page {

    public US08Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='round-tabs four']")
    public WebElement advancedLevelLink;
    @FindBy(xpath = "(//*[.='Table Data Download'])[5]")
    public WebElement tableDataDownload;
    @FindBy(xpath = "//input[@type='search']")
    public WebElement dataSearchBox;
    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement>cityesColumn;
    @FindBy (xpath = "//a[@class='dt-button buttons-pdf buttons-html5']")
    public WebElement pdfButton;
}
