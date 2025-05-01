package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.AdactinHotel;
import Pages.LoginPage;
import Pages.SearchHotelPage;

public class TC_007_Checking_Fields_on_Search_Hotel_page extends AdactinHotel {
	
	@BeforeTest
	public void setUp() {
		sheetName="SearchFields";
		TestName="Checking the Searching the hotels";
		TestDescription="Verify the searching the hotel";
		testCategory="Valid and Invalid";
		testAuthor="Chakkaravarthi";
	}
	
	@Test(dataProvider = "readData")
	public void CheckingSearchPageFields(String location, String hotel, String roomType, String numberOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom, String search, String reset) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("chakka312").enterPassword("161298").clickLoginBtn();
		Thread.sleep(3000);
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);
		searchHotelPage.checkLocationField(location).checkHotelField(hotel).checkRoomTypeField(roomType).checkNumberOfRoomField(numberOfRooms).checkCheckInDateField(checkInDate).checkCheckOutDateField(checkOutDate).checkAdultPerRoomField(adultsPerRoom).checkChildrenPerRoomField(childrenPerRoom).checkSearchBtn(search).checkResetBtn(reset);
	}

}
