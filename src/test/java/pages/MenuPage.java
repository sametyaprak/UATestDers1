package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MenuPage {

    public MenuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[.='Menu'])[3]")
    public WebElement menuLink;
    @FindBy(xpath = "//li[@class='ui-menu-item']")
    public List<WebElement> allHoverElements;
    @FindBy(xpath = "//li[@class='ui-menu-item ui-state-focus'])")
    public WebElement selectedItem;
    @FindBy(xpath = "//li[@role='menuitem']")
    public List<WebElement> allItems;
    @FindBy(xpath = "//*[.='Menu With Sub Menu']")
    public WebElement menuWithSubmenuLink;
    @FindBy(xpath = "//li[@tabindex='-1']")
    public List<WebElement> allHovers;
    @FindBy(xpath = "//*[.='Sub Menu 1']")
    public WebElement submenu1;
    @FindBy(xpath = "//*[.='Sub Menu 2']")
    public WebElement submenu2;
    @FindBy(xpath = "//*[.='Sub Menu 3']")
    public WebElement submenu3;
    @FindBy(xpath = "//*[.='Sub Menu 4']")
    public WebElement submenu4;
}
