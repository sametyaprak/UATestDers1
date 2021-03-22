package pages.easiyseleniumpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US06Page {

    public US06Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='round-tabs four']")
    public WebElement advancedLevelLink;
    @FindBy(xpath = "(//*[.='Table Pagination'])[5]")
    public WebElement tablePaginationLink;
    @FindBy(xpath = "(//*[.='Table Data Search'])[5]")
    public WebElement tableDataSearchLink;
    @FindBy(xpath = "//ul[@id='myPager']/li/a")
    public List<WebElement>pageSelectionLinks;
    @FindBy(xpath = "//*[.='Table cell']")
    public List<WebElement> tableCells;
    @FindBy(xpath = "//input[@id='task-table-filter']")
    public WebElement textBox;
    @FindBy(xpath = "(//thead/tr)[1]/th")
    public List<WebElement> tableHeaders;
    @FindBy(xpath = "(((//tbody)[1]/tr)[2]/td)[3]")
    public WebElement resultRow;
    @FindBy(xpath = "//input[@class='form-control']")
    public List<WebElement> inputTextBoxes;
    @FindBy(xpath = "//span[@class='glyphicon glyphicon-filter']")
    public WebElement filterLink;
    @FindBy(xpath = "(//tbody)[2]")
    public List<WebElement> results;
}
