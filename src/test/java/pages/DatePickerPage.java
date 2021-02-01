package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DatePickerPage {
    public DatePickerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[.='Datepicker'])[3]")
    public WebElement datePickerLink;
    @FindBy(xpath = "//a[@target='_self']")
    public List<WebElement> basicTabs;
    @FindBy(id = "anim")
    public WebElement dateAnimationsDropbpx;
    @FindBy(id = "datepicker")
    public WebElement dateSelectionBox;
    @FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
    public WebElement nextMonthTriangle;
    @FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-w']")
    public WebElement previousMonthTriangle;
    @FindBy(xpath = "//a[@class='ui-state-default']")
    public List<WebElement> dayOfMonthList;
    @FindBy(xpath = "//select[@data-event='change']")
    public List<WebElement> yearAndMonthDropboxes;
    @FindBy(xpath = "//select[@class='ui-datepicker-year']/option")
    public List<WebElement> allYearsList;
}
