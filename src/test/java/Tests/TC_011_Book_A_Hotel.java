package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.AdactinHotel;
import Pages.BookAHotel;
import Pages.LoginPage;
import Pages.SearchHotelPage;

public class TC_011_Book_A_Hotel extends AdactinHotel {
	
	@BeforeTest
	public void setUp() {
		sheetName="BookAHotel";
		TestName="Checking Hotel booking with valid and invalid scenario";
		TestDescription="Verify the Hotel booking with valid and invalid scenario";
		testCategory="Valid and Invalid";
		testAuthor="Chakkaravarthi";
	}
	
	@Test(dataProvider = "readData")
	public void BookingAHotel(String username, String password, String location, String hotel,String roomType, String noOfRoom, String checkInDate, String checkOutDate, String adultPerRomm, String childrenPerRoom, String firstname, String lastname, String address, String creditcardNumber, String cardType, String month, String year, String cvv, String testType, String expectedText) {
		LoginPage loginPage= new LoginPage(driver);
		loginPage.enterUsername(username).enterPassword(password).clickLoginBtn();
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);
		searchHotelPage.selectLocationDropDown(location).selectHotelDropDown(hotel).selectRoomTypeDropDown(roomType).selectNumberOfRoomsDropDown(noOfRoom).enterCheckInDate(checkInDate).enterCheckOutDate(checkOutDate).selectAdultsPerRoom(adultPerRomm).selectChildrenPerRoom(childrenPerRoom).clickSearchBtn().selectRadioOption().selectContinue();
		BookAHotel bookAHotel = new BookAHotel(driver);
		bookAHotel.enterFirstName(firstname).enterLastName(lastname).enterBillingAddress(address).enterCreditCardNumber(creditcardNumber).selectCardType(cardType).selecExpiryMonth(month).selecExpiryYear(year).enterCVVNumber(cvv).clickBookNow().checkBookConfirmation(testType, expectedText);
	}

}
