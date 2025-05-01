package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.AdactinHotel;
import Pages.LoginPage;
import Pages.SearchHotelPage;

public class TC_014_Logout_from_page extends AdactinHotel{
	
	@BeforeTest
	public void setUp() {
		sheetName="UserCredentials";
		TestName="Checking Logout";
		TestDescription="Verify the Logout from webPage";
		testCategory="Valid";
		testAuthor="Chakkaravarthi";
	}
	
	@Test(dataProvider = "readData")
	public void Logout(String username, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username).enterPassword(password).clickLoginBtn();
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);
		searchHotelPage.clickLogout().checkLogoutMessage("You have successfully logged out. Click here to login again").clickLoginAgain();
	}
	

}
