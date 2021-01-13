package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JobHeroPage;
import utilities.ConfigReader;
import utilities.Driver;

public class JobHeroTest {

//    www.jonhero.com sitesine gidiniz
//    resumes menusune tiklayiniz
//    resume builder linkine seciniz
//    build your resume butonuna tiklayiniz
//    create my resume butonuna tiklayiniz
//    experience level' a "0-3 years"  secenegini seciniz
//    are you student sorusuna "no" seciniz
//    gelen sayfada 3 tane resume ornegi oldugunu dogrulayiniz

    JobHeroPage jobHeroPage = new JobHeroPage();
    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("jobhero"));
        jobHeroPage.resumesLink.click();
        jobHeroPage.resumeBuilderLink.click();
        jobHeroPage.createMyResumeLink.click();
        jobHeroPage.zeroThreeYearsLink.click();
        jobHeroPage.areYouStudentNo.click();
        Assert.assertEquals(jobHeroPage.resumesList.size(),3);



    }
}
