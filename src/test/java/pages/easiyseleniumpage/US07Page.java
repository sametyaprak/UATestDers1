package pages.easiyseleniumpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US07Page {
    public US07Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='round-tabs four']")
    public WebElement advancedLevelLink;
    @FindBy(xpath = "(//*[.='Table Filter '])[5]")
    public WebElement tableFilterLink;
    @FindBy(xpath = "//div[@class='media']")
    public List<WebElement> allCards;
    @FindBy(xpath = "//button[@class='btn btn-warning btn-filter']")
    public WebElement orangeButton;
    @FindBy(xpath = "//i[@style='color:orange;']")
    public List<WebElement>orangeCards;
    @FindBy(xpath = "(//*[.='Table Sort & Search'])[5]")
    public WebElement tableSortSearch;
    @FindBy(xpath = "//select[@class='']")
    public WebElement pageDropbox;
    @FindBy(xpath = "//div[@id='example_info']")
    public WebElement pageDataInformation;
    @FindBy(xpath = "//*[.='Salary']")
    public WebElement salaryOrderLink;
    @FindBy(xpath = "//tbody/tr/td[6]")
    public List<WebElement>allSalaryData;
    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement>allCityData;


}
