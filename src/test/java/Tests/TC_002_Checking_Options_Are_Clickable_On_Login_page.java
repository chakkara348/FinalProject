package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.AdactinHotel;
import Pages.LoginPage;

public class TC_002_Checking_Options_Are_Clickable_On_Login_page extends AdactinHotel {
	
	@BeforeTest
	public void setUp() {
		TestName="Checking Fields are clickable on the Login Screen";
		TestDescription="Verify the optios on the Login Screen are clickable";
		testCategory="Valid";
		testAuthor="Chakkaravarthi";
	}
	
	@Test
	public void checkingLoginPageFieldsAreClickable() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.CheckingButtonAreClickable();
	}

}
