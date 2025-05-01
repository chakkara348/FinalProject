package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.AdactinHotel;
import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.SearchHotelPage;

public class TC_012_Chnage_Password extends AdactinHotel{
	
	@BeforeTest
	public void setUp() {
		sheetName="ChangePassword";
		TestName="Checking change password with valid and invalid scenario";
		TestDescription="Verify the change password with valid and invalid scenario";
		testCategory="Valid and Invalid";
		testAuthor="Chakkaravarthi";
	}
	
	@Test(dataProvider = "readData")
	public void changePassword(String username,String password,String currentPass, String newPass, String confirmPass, String testType, String expectedResult) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username).enterPassword(password).clickLoginBtn();
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);
		searchHotelPage.clickChangePassword().enterCurrentPassword(currentPass).enterNewPassword(newPass).enterConfirmPassword(confirmPass).clickSubmitBtn().checkValidation(testType,expectedResult);
		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.checkLogoutMessage("You have successfully logged out. Click here to login again").clickLoginAgain();
	}

}
