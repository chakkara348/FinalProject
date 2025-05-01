package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.AdactinHotel;
import Pages.LoginPage;
import Pages.SearchHotelPage;

public class TC_015_Select_value_to_search extends AdactinHotel {
	
	@BeforeTest
	public void setUp() {
		sheetName="LocationDropDown";
		TestName="Checking the Searching the hotels";
		TestDescription="Verify the searching the hotel";
		testCategory="Valid and Invalid";
		testAuthor="Chakkaravarthi";
	}
	
	@Test(dataProvider = "readData")
	public void selectValueToSearchHotels(String username, String password,String location, String hotel, String roomType,String numberOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom, String testType, String expectedResult) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username).enterPassword(password).clickLoginBtn();
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);
		Thread.sleep(3000);
		searchHotelPage.selectLocationDropDown(location)
		.selectHotelDropDown(hotel)
		.selectRoomTypeDropDown(roomType)
		.selectNumberOfRoomsDropDown(numberOfRooms)
		.enterCheckInDate(checkInDate)
		.enterCheckOutDate(checkOutDate)
		.selectAdultsPerRoom(adultsPerRoom)
		.selectChildrenPerRoom(childrenPerRoom)
		.clickSearchBtn()
		.SearchedValidation(testType, expectedResult);
		Thread.sleep(3000);
	}

}
