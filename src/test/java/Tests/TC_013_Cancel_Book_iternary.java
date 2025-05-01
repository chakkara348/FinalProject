package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.AdactinHotel;
import Pages.LoginPage;
import Pages.SearchHotelPage;

public class TC_013_Cancel_Book_iternary extends AdactinHotel {
	
	@BeforeTest
	public void setUp() {
		sheetName="UserCredentials";
		TestName="Checking cancel book itinerary with valid and invalid scenario";
		TestDescription="Verify the cancel book itinerary with valid and invalid scenario";
		testCategory="Valid and Invalid";
		testAuthor="Chakkaravarthi";
	}
	
	@Test(dataProvider = "readData",priority = 1)
	public void checkCancelBookItineraryByCancelButton(String username, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username).enterPassword(password).clickLoginBtn();
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);
		searchHotelPage.clickBookedItinerary().clickCancelBtn();
	}
	
	@Test(dataProvider = "readData",priority = 2)
	public void checkCancelBookItineraryBySingleCheck(String username, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username).enterPassword(password).clickLoginBtn();
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);
		searchHotelPage.clickBookedItinerary().cancelBySingleCheckBox();
	}
	
	@Test(dataProvider = "readData",priority = 3)
	public void checkCancelBookItineraryByAllCheck(String username, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username).enterPassword(password).clickLoginBtn();
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);
		searchHotelPage.clickBookedItinerary().cancelByCheckAllOption();
	}

}
