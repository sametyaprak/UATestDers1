package pages.easiyseleniumpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DropdownPage {
    public DropdownPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@id='at-cv-lightbox-close']")
    public WebElement alertClose;
    @FindBy(xpath = "//a[@id='btn_basic_example']")
    public WebElement startPractisingLink;
    @FindBy(xpath = "//*[.='Input Forms']")
    public WebElement inputForms;
    @FindBy(xpath = "(//a[.='Select Dropdown List'])[3]")
    public WebElement selectDropdownList;
    @FindBy(xpath = "(//div[@class='panel-heading'])[2]")
    public WebElement selectListDemoHeader;
    @FindBy(xpath = "//select[@id='select-demo']")
    public WebElement daysDropbox;
    @FindBy(xpath = "//p[@class='selected-value']")
    public WebElement selectedDayText;
    @FindBy(id = "multi-select")
    public WebElement cityesDropbox;
    @FindBy(id = "printMe")
    public WebElement printMeOne;
    @FindBy(id = "printAll")
    public WebElement printMeAll;
    @FindBy(xpath = "//p[@class='getall-selected']")
    public WebElement cityesResultText;
    @FindBy(xpath = "//option")
    public List<WebElement>allselectables;


}
