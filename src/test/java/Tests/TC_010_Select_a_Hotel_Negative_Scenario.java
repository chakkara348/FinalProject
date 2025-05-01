package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.AdactinHotel;
import Pages.LoginPage;
import Pages.SearchHotelPage;

public class TC_010_Select_a_Hotel_Negative_Scenario extends AdactinHotel{

	@BeforeTest
	public void setUp() {
		sheetName="SelectAHotelInvalid";
		TestName="Checking Hotel are selected";
		TestDescription="Verify the Hotel are selected";
		testCategory="Valid";
		testAuthor="Chakkaravarthi";
	}
	
	@Test(dataProvider = "readData")
	public void selectAHotelToBook(String username, String password,String location, String hotel,String roomType, String noOfRooms,String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom, String testType, String expectedResult) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username).enterPassword(password).clickLoginBtn();
		Thread.sleep(3000);
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);
		searchHotelPage.selectLocationDropDown(location).selectHotelDropDown(hotel).selectRoomTypeDropDown(roomType).selectNumberOfRoomsDropDown(noOfRooms).enterCheckInDate(checkInDate).enterCheckOutDate(checkOutDate).selectAdultsPerRoom(adultsPerRoom).selectChildrenPerRoom(childrenPerRoom)
		.clickSearchBtn().checkSearchedLocationName(location).checkSearchedHotelName(hotel).checkArrivalDate(checkInDate).checkDepartureDate(checkOutDate).selectContinue().checkSelectHotelValidation(testType, expectedResult);
		Thread.sleep(3000);
	}	
}
