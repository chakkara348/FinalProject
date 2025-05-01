package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.AdactinHotel;
import Pages.LoginPage;

public class TC_001_Checking_Fields_On_Login_Page_Are_Visible extends AdactinHotel {
	
	@BeforeTest
	public void setUp() {
		TestName="Checking Fields are visible on the Login Screen";
		TestDescription="Verify the Fields on the Login Screen are visible";
		testCategory="Valid";
		testAuthor="Chakkaravarthi";
	}
	
	@Test
	public void checkingLoginPageFieldsAreDisplayed() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.checkingFieldsAreDisplayed();
	}
	}

