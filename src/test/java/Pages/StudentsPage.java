package Pages;

import Base.BasePage;
import Common.CommonPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentsPage extends BasePage {

	CommonPage cp = new CommonPage();

	@FindBy(xpath = "//a[text()='Students']")
	WebElement studentsMenu;

	@FindBy(xpath = "/html/body/div/p/a")
	WebElement lnkCreateNew;
	// WebElement lnkCreateNew= wd.findElement(By.linkText("Create New"));

	// Create Heading
	@FindBy(xpath = "//h2[text()='Create']")
	WebElement headingCreate;

	// Students Info
	@FindBy(id = "LastName")
	WebElement lastName;

	@FindBy(id = "FirstMidName")
	WebElement firstName;

	@FindBy(id = "EnrollmentDate")
	WebElement enrollmentDate;

	@FindBy(xpath = "//input[@class='btn btn-default']")
	WebElement createButton;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]")
	List<WebElement> eStudents;

	@FindBy(xpath = "//a[text()='»']")
	List<WebElement> nextButton;

	@FindBy(id = "SearchString")
	WebElement eSearchTextBox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement eSearchButton;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr[2]/td")
	WebElement searchName;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[4]/a[3]")
	List<WebElement> eDeleteButtons;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement eDeleteConfirm;
	
	@FindBy(xpath = "/html/body/div[2]/div/ul/li[3]/a")
	WebElement oneBox;
	
	
	@FindBy(css = "li[class='PagedList-skipToPrevious']")
	WebElement firstHiddenBox;
	
	@FindBy(css = "li[class='PagedList-skipToNext']")
	WebElement lastHiddenBox;
	
	@FindBy(xpath = "/html/body/div[2]/div/ul/li[13]/a")
	WebElement lastBox;
	
	@FindBy(xpath = "//div[2]/table/tbody/tr[2]/td[4]/a[1]")
	WebElement editXPathStudent;
	
	@FindBy(xpath ="//*[text()='Department']")
	WebElement editCoursesPage;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr[2]/td[4]/a[2]")
	WebElement detailsInformation;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr[2]/td[4]/a[3]")
	WebElement deleteInformation;
	
	@FindBy(xpath = "/html/body/div[2]/div/dl/dd[1]")
	WebElement infoToBeDeleted;
		
	@FindBy(xpath = "//input[@type='submit']")
	WebElement deleteInfoPermanent;
	

	public StudentsPage() {
		PageFactory.initElements(wd, this);
	}

	public void navigateStudentsmenu() {
		studentsMenu.click();
	}

	public void clickCreateNew() {

		// Mah Code Starts
		if (lnkCreateNew.isDisplayed()) {
			System.out.println("Yes link is there");
		} else {
			System.out.println("No link is there");
		}
	}
	// Mah Code Ends

	public void verifyCreateNewFunctionality() {
		lnkCreateNew.click();
		lastName.sendKeys("Peterson");
		firstName.sendKeys("Ryan");
		enrollmentDate.sendKeys("04021990");
		createButton.click();
		eSearchTextBox.sendKeys("Peterson");
		eSearchButton.click();
		String name = searchName.getText();
		if (name.contains("Peterson")) {
			System.out.println("Verified");
		} else {
			System.out.println("Sth is wrong");
		}
	}

	public void firstNameCheck() {
		eSearchTextBox.click();
		eSearchTextBox.clear();
		eSearchTextBox.sendKeys("Ryan");
		eSearchButton.click();
		String name = searchName.getText();
		System.out.println(name);
		if (name.contains("Ryan")) {
			System.out.println("Verified");
		} else {
			System.out.println("Sth is wrong");

		}
	}
	
	public void inActiveCheck() {
		oneBox.click();
		Assert.assertTrue(firstHiddenBox.isEnabled());
		System.out.println(firstHiddenBox.isEnabled());
		//For Last Page
		
		Assert.assertTrue(lastHiddenBox.isEnabled());
		lastBox.click();
		System.out.println(lastHiddenBox.isSelected());
	}
	
	public void editFeatureStudents() {
		studentsMenu.click();
		editXPathStudent.click();
		Assert.assertTrue(editCoursesPage.isDisplayed());
	}
	
	public void detailsLinkCheck() {
		studentsMenu.click();
		Assert.assertTrue(detailsInformation.isEnabled());		
	}
	
	public void deleteLinkCheck() {
		studentsMenu.click();
		deleteInformation.click();
		String deletingName= infoToBeDeleted.getText();
		deleteInfoPermanent.click();
		
		//Check if its Deleted or Not
		
		eSearchTextBox.click();
		eSearchTextBox.sendKeys(deletingName);
		eSearchButton.click();
		
	}

	// lnkCreateNew.click();

//    public void clickSearchButton(){
//        eSearchButton.click();
//    }
//
//
//    public void verifyHeadingCreate(){
//        cp.isElementDisplayed(headingCreate);
//    }
//
//    public void enterFirstName(){
//        cp.enterData(firstName,prop.getProperty("FIRST_NAME"));
//    }
//
//    public void enterLastName(){
//        cp.enterData(lastName,prop.getProperty("LAST_NAME"));
//    }
//
//    public void enterEnrollmentDate(){
//        String pattern = "MM/dd/yyyy";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String date = simpleDateFormat.format(new Date());
//        cp.enterData(enrollmentDate,date);
//    }
//
//    public void clickCreateButton(){
//        createButton.click();
//    }
//
//    public String getHomePageTitle(){
//        return wd.getTitle();
//    }
//
//
//    public List<String> getAllStudentsNameList() throws InterruptedException {
//        //System.out.println(students.size());
//        //click till the next button is disabled , add all the pages records
//        //Note: if nextButton is not kept in array, it then we can't use the size(), and
//        //since for single element, only
//        List<String> students=new ArrayList<>();
//        for(WebElement eStudent:eStudents) {
//            students.add(eStudent.getText());
//        }
//        while(nextButton.size() > 0 && nextButton.get(0).isDisplayed()==true){
//            nextButton.get(0).click();
//            for(WebElement eStudent:eStudents) {
//                students.add(eStudent.getText());
//            }
//           // Thread.sleep(3000);
//        }
//                return students;
//    }
//
//    public void enterNameSearchButton(String name) {
//        eSearchTextBox.sendKeys(name);
//    }
//
//    public void clickAllDeleteButtons() {
//        while (eDeleteButtons.size() > 0) {
//            clickDeleteButtons();
//            clickDeleteConfirm();
//        }
//    }
//
//    public void clickDeleteButtons(){
//        eDeleteButtons.get(0).click();
//    }
//
//    public int getDeteleteButtonsSize(){
//        return eDeleteButtons.size();
//    }
//
//    public void clickDeleteConfirm(){
//        eDeleteConfirm.click();
//    }

	public void close() {
		wd.quit();
	}

}
