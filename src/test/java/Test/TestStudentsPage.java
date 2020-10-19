package Test;

import Base.BasePage;
import Pages.StudentsPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestStudentsPage extends BasePage {

	public StudentsPage studentsPage;

	public TestStudentsPage() {
		super(); // will call BasePage();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		studentsPage = new StudentsPage();
	}

	// RUN THIS TEST TO CHECK IF PAGE OBJECT MODEL IS WORKING ?
	@Test
	public void verifyAddStudents() throws InterruptedException {
		studentsPage.navigateStudentsmenu();
		Thread.sleep(5000);
		studentsPage.clickCreateNew();
		Thread.sleep(5000);
	}

	// Verify the add Create New works on Index page of Students
	@Test
	public void checkforEnteredName() throws InterruptedException {
		studentsPage.navigateStudentsmenu();
		studentsPage.verifyCreateNewFunctionality();
		Thread.sleep(3000);
	}
	
	
	//Verify Search Functionality of the student works by First Name
	@Test
	public void checkByFirstName() throws InterruptedException {
		studentsPage.navigateStudentsmenu();
		studentsPage.firstNameCheck();
		Thread.sleep(3000);
	}
	
	//Verifying in-active 
	@Test
	public void verifyInActive() throws InterruptedException {
			studentsPage.inActiveCheck();
			Thread.sleep(2000);
	}	
	  @Test
	    public void editCoursesFromStudentsPage() throws InterruptedException {
		  studentsPage.editFeatureStudents();
	    	//editFeaturesChecker.editFeature();
	    	Thread.sleep(2000);
	    }
	
	@Test
	public void checkDetailsLink() throws InterruptedException {
		studentsPage.detailsLinkCheck();
		Thread.sleep(2000);
	}
	
	@Test
	public void checkDeleteLink() throws InterruptedException {
		studentsPage.deleteLinkCheck();
		Thread.sleep(2000);
	}

//        //verify Create Heading
//        studentsPage.verifyHeadingCreate();
//
//        studentsPage.enterLastName();
//        Thread.sleep(3000);
//
//        // Enter forms Value
//        studentsPage.enterFirstName();
//        Thread.sleep(3000);
//
//        studentsPage.enterEnrollmentDate();
//        Thread.sleep(3000);
//
//        studentsPage.clickCreateButton();
//
//        //verify the students create...... create another @Test method to verify the user created..
//
//    }

	@AfterTest
	public void tearDown() {
		wd.quit();
	}

}
