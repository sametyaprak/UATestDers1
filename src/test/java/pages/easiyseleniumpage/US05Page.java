package pages.easiyseleniumpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US05Page {

    public US05Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[.='JQuery List Box'])[5]")
    public WebElement jqueryListBoxLink;
    @FindBy(xpath = "//select[@class='form-control pickListSelect pickData']")
    public WebElement leftDropbox;
    @FindBy(xpath = "//select[@class='form-control pickListSelect pickListResult']")
    public WebElement rightDropbox;
    @FindBy(xpath = "//button[@class='pAdd btn btn-primary btn-sm']")
    public WebElement addButton;
    @FindBy(xpath = "//select[@class='form-control pickListSelect pickData']/option")
    public List<WebElement> leftList;
    @FindBy(xpath = "(//select)[2]/option")
    public List<WebElement> rightList;
    @FindBy(xpath = "(//a[.='Data List Filter'])[3]")
    public WebElement dataListFilterLink;
    @FindBy(xpath = "//div[@class='info-block block-info clearfix']/span")
    public List<WebElement> emailsAndPhoneNumbers;
    @FindBy(xpath = "//div[@class='info-block block-info clearfix']")
    public List<WebElement> personsCard;
    @FindBy(id = "input-search")
    public WebElement dataInputBox;
    @FindBy(xpath = "//div[@class='info-block block-info clearfix']/h4")
    public List<WebElement> personsCardName;
    @FindBy(xpath = "(//*[.='File Download'])[5]")
    public WebElement fileDownloadLink;
    @FindBy(id = "textbox")
    public WebElement textBox;
    @FindBy(id = "textarea_feedback")
    public WebElement characterNumber;
    @FindBy(id = "create")
    public WebElement geerateFileButton;
    @FindBy(id = "link-to-download")
    public WebElement downloadLink;
}
