package Test;

import Base.BasePage;
import Common.HeaderPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHomePage extends BasePage {

    public HomePage homePage;

    public TestHomePage(){
        super(); //will call BasePage();
    }

    @BeforeTest
    public void setUp(){
        initialization();
        homePage=new HomePage();
    }

    //RUN THIS TEST TO CHECK IF PAGE OBJECT MODEL IS WORKING ?
//    @Test
//    public void verifyHomePageTitle() {
//        //just call the login page , which will make the title page works...
//        Assert.assertEquals(homePage.getHomePageTitle(),prop.getProperty("HOME_PAGE_TITLE"));
//    }
//
//    @Test
//    public void veirfyHomePageBannerTitle(){
//        Assert.assertEquals(homePage.getBannerTitle(),prop.getProperty("BANNER_TITLE"));
//    }
    
    @Test
    public void veirfyPageCoursesTitle(){
        Assert.assertEquals(homePage.getPageCourseTitle(),prop.getProperty("COURSES_TITLE"));
    }

//    @Test
//    public void verifyMenus(){
//        HeaderPage page=new HeaderPage();
//        page.verifyMenus();
//    }
    
    @Test
    public void headerCheck() {
    	HomePage checkCoursesText = new HomePage();
    	System.out.println(checkCoursesText.coursesHeaderCheck());    	
    }
    
    @Test
    public void verifyCoursesNCreateLink() {
    	HomePage coursesCreateURL = new HomePage();
    	coursesCreateURL.checkCoursesNCreate();
    }
    
    @Test
    public void headersListCheck() {
    	HomePage headerListCheckText = new HomePage();
    	headerListCheckText.headerListCheck();    	
    }
    
    @Test
    public void newCoursesRecordCheck() {
    	HomePage recordCheck4Courses = new HomePage();
    	recordCheck4Courses.tableRecord();
    }
    
    
    
    @Test
    public void editCoursesFeatureCheck() throws InterruptedException {
    	HomePage editFeaturesChecker = new HomePage();
    	editFeaturesChecker.editFeature();
    	Thread.sleep(2000);
    }
    
  @Test
	public void checkCoursesDetailsLink() throws InterruptedException {
	  HomePage Check4Details= new HomePage();
	  Check4Details.CoursesdetailsLinkCheck();;
	Thread.sleep(2000);
    }
    
    @Test
	public void checkDeleteLink() throws InterruptedException {
    	HomePage checkDeleteFromLink = new HomePage();
    	checkDeleteFromLink.deleteLinkCheck();
		Thread.sleep(2000);
	}


   
    @AfterTest
    public void tearDown(){
        wd.quit();
    }

}



