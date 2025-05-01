package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.AdactinHotel;
import Pages.LoginPage;

public class TC_008_Forgot_Password_with_valid_and_Invalid_scenarios extends AdactinHotel {
	
	@BeforeTest
	public void setUp() {
		sheetName="ForgotPassword";
		TestName="Checking the forgot password Page";
		TestDescription="Verify the forgot password with valid and invalid scenarios";
		testCategory="Valid and Invalid";
		testAuthor="Chakkaravarthi";
	}
	
	@Test(dataProvider = "readData",priority = 1)
	public void checkForgotPassword(String email, String testType, String expectedResult) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickForgotPassword().enterEmail(email).clickEmailPasswordBtn().checkValidation(testType, expectedResult);
	}
	
	@Test(priority = 2)
	public void checkReset() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickForgotPassword().enterEmail("chakkarav@gmail.com").clickResetBtn();
	}

}
