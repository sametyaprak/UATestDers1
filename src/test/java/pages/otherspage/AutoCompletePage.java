package pages.otherspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class AutoCompletePage {
    public AutoCompletePage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[.='Autocomplete'])[3]")
    public WebElement autoCompleteLink;
    @FindBy(xpath = "//input[@id='tags']")
    public WebElement textBox1;
    @FindBy(xpath = "//li[@class='ui-menu-item']")
    public List<WebElement> listOfAllData;
}
