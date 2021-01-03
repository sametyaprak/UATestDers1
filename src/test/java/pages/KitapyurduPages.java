package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KitapyurduPages {
    public KitapyurduPages(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//span[@class='RveJvd snByac'])[3]")
    public WebElement ichStimmeZu;

}
