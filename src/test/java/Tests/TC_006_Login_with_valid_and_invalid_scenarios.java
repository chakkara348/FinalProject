package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.AdactinHotel;
import Pages.LoginPage;

public class TC_006_Login_with_valid_and_invalid_scenarios extends AdactinHotel {

	@BeforeTest
	public void setUp() {
		sheetName="Login";
		TestName="Checking the Login Page";
		TestDescription="Verify the Login with valid and invalid scenarios";
		testCategory="Valid and Invalid";
		testAuthor="Chakkaravarthi";
	}
	
	@Test(dataProvider = "readData")
	public void checkingLogin(String username, String password, String TestType, String expectedMessage) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username)
		.enterPassword(password)
		.clickLoginBtn()
		.LoginValidation(TestType,expectedMessage);
	}
}
