package pages.easiyseleniumpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US04Page {

    public US04Page (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='round-tabs three']")
    public WebElement intermediateLevel;
    @FindBy(xpath = "(//a[.='Ajax Form Submit'])[3]")
    public WebElement ajaxFormSubmitLink;
    @FindBy(id = "title")
    public WebElement nameTextBox;
    @FindBy(id = "description")
    public WebElement commentTextBox;
    @FindBy(id = "btn-submit")
    public WebElement submitButton;
    @FindBy(xpath = "//div[@id='submit-control']")
    public WebElement submitControlText;
    @FindBy(xpath = "(//a[.='JQuery Select dropdown'])[3]")
    public WebElement jquerySelectDropdown;
    @FindBy(id = "country")
    public WebElement selectCountryDropdown;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement multipleSelectTextBox;
    @FindBy(xpath = "//select[@class='js-example-disabled-results select2-hidden-accessible']")
    public WebElement dropdownUSTeritories;
    @FindBy(id = "files")
    public WebElement relatedOptionsDropdown;
    @FindBy(xpath = "(//a[.='Bootstrap List Box'])[3]")
    public WebElement bootstrapLink;
    @FindBy(xpath = "//li[@class='list-group-item']")
    public List<WebElement> allSelectableItems;
    @FindBy(xpath = "//button[@class='btn btn-default btn-sm move-left']")
    public WebElement moveLeftArrow;
    @FindBy(xpath = "//button[@class='btn btn-default btn-sm move-right']")
    public WebElement moveRightArrow;
    @FindBy(xpath = "//li[@class='list-group-item active']")
    public List<WebElement> activeSelectedItemsList;








}

