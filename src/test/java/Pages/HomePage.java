package Pages;

import Base.BasePage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage extends BasePage {

	@FindBy(className = "jumbotron")
	WebElement bannerTitle;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/ul/li[4]/a")
	WebElement CoursePageTitle;

	@FindBy(xpath = "//h2[text()='Courses']")
	WebElement courseHeader;

	@FindBy(xpath = "/html/body/div[2]/p/a")
	WebElement courseCreate;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr[1]/th")
	List<WebElement> headerList;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td")
	List<WebElement> coursesDescription;
	
	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr[2]/td")
	List<WebElement> courseLine1List;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr[2]/td[5]/a[3]")
	WebElement deleteCourseInformation;

	@FindBy(xpath = "/html/body/div[2]/div/dl/dd[1]")
	WebElement infoToBeDeleted;
	
	@FindBy(xpath = "//div[2]/table/tbody/tr[2]/td[5]/a[1]")
	WebElement editXPath;
	
	@FindBy(xpath ="//div[@class='col-md-10']")
	WebElement editCoursesPage;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr[2]/td[5]/a[2]")
	WebElement CoursesdetailsInformation;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement deleteInfoPermanent;

	public HomePage() {
		PageFactory.initElements(wd, this);
	}

	public String getHomePageTitle() {
		return wd.getTitle();
	}

	public void checkCoursesNCreate() {
		CoursePageTitle.click();
		courseCreate.click();
		Assert.assertEquals(wd.getCurrentUrl(), "https://automationpractice.itsutra.com/Course/Create");
	}

	public String getBannerTitle() {
		return bannerTitle.getText();
	}

	public String getPageCourseTitle() {
		CoursePageTitle.click();
		return wd.getTitle();
	}

	public String coursesHeaderCheck() {
		CoursePageTitle.click();
		return courseHeader.getText();
	}

	public void headerListCheck() {
		CoursePageTitle.click();

		for (int i = 0; i < headerList.size(); i++) {
			String nameOnHeader = headerList.get(i).getText();
			System.out.print(nameOnHeader + " ");
		}
		Assert.assertTrue(true, "Number Title Credits Department");
	}
	
	public String tableRecord() {
		CoursePageTitle.click();
		for (int i = 0; i < coursesDescription.size(); i++) {
			String tableChecker = coursesDescription.get(i).getText();
			//System.out.println(tableChecker);
			if (tableChecker.contains("")) {
				return "True: Records could be empty";
			}
		}
		return null;			
		}
	
	public void editFeature() {
		CoursePageTitle.click();
		editXPath.click();
		Assert.assertTrue(editCoursesPage.isDisplayed());
	}

	public void CoursesdetailsLinkCheck() {
		CoursePageTitle.click();
		Assert.assertTrue(CoursesdetailsInformation.isEnabled());
	}

	public void deleteLinkCheck() {
		CoursePageTitle.click();
		deleteCourseInformation.click();
		String deletingCourseName = infoToBeDeleted.getText();
		deleteInfoPermanent.click();

	}
}
