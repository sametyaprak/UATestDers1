package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class JobHeroPage {

    public JobHeroPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[@href='/resume'])[1]")
    public WebElement resumesLink;
    @FindBy(xpath = "(//a[@rel='nofollow'])[2]")
    public WebElement resumeBuilderLink;
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement createMyResumeLink;
    @FindBy(xpath = "//button[@value='0-3 Years']")
    public WebElement zeroThreeYearsLink;
    @FindBy(xpath = "//button[.='No']")
    public WebElement areYouStudentNo;
    @FindBy(xpath = "//div[@class='card-img-overlay']")
    public List<WebElement> resumesList;
}
