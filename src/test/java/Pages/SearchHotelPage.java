package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.AdactinHotel;

public class SearchHotelPage extends AdactinHotel {
	
	@FindBy(className = "welcome_menu")
	WebElement welcomeElement;
	
	@FindBy(xpath = "//td[text()='Location']")
	WebElement locationField;
	
	@FindBy(id="location")
	WebElement locationDropDown;
	
	@FindBy(xpath = "//form[@id='search_form']//tbody/tr[3]/td[1]")
	WebElement hotelField;
	
	@FindBy(id="hotels")
	WebElement hotelDropDown;
	
	@FindBy(xpath = "//form[@id='search_form']//tbody/tr[4]/td[1]")
	WebElement roomTypeField;
	
	@FindBy(id="room_type")
	WebElement roomTypeDropDown;
	
	@FindBy(xpath = "//td[text()='Number of Rooms']")
	WebElement numberOfRoomsField;
	
	@FindBy(id="room_nos")
	WebElement numberOfRoomsDropDown;
	
	@FindBy(xpath = "//td[text()='Check In Date']")
	WebElement checkInDateField;
	
	@FindBy(id="datepick_in")
	WebElement checkInDateInput;
	
	@FindBy(xpath="//td[text()='Check Out Date']")
	WebElement checkOutDateField;
	
	@FindBy(id="datepick_out")
	WebElement checkOutDateInput;
	
	@FindBy(xpath = "//td[text()='Adults per Room']")
	WebElement adultsPerRoomField;
	
	@FindBy(id="adult_room")
	WebElement adultsPerRoomDropDown;
	
	@FindBy(xpath = "//form[@id='search_form']//tbody/tr[9]/td[1]")
	WebElement childrenPerRoomField;
	
	@FindBy(id="child_room")
	WebElement childrenPerRoomDropDown;
	
	@FindBy(id="Submit")
	WebElement searchBtn;
	
	@FindBy(id="Reset")
	WebElement resetBtn;
	
	@FindBy(xpath = "//a[text()='Change Password']")
	WebElement changePasswordBtn;
	
	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	WebElement bookedIternaryBtn;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutBtn;
	
	
	public SearchHotelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public SearchHotelPage checkWelcomeTextIsDisplayed() {
		OptionDisplayedCheck(welcomeElement);
		return this;
	}
	
	public SearchHotelPage checkLocationField(String ExpectedText) {
		LabelTextCheck(locationField, ExpectedText);
		return this;
	}
	
	public SearchHotelPage checkHotelField(String ExpectedText) {
		LabelTextCheck(hotelField, ExpectedText);
		return this;
	}
	
	public SearchHotelPage checkRoomTypeField(String ExpectedText) {
		LabelTextCheck(roomTypeField, ExpectedText);
		return this;
	}
	
	public SearchHotelPage checkNumberOfRoomField(String ExpectedText) {
		LabelTextCheck(numberOfRoomsField, ExpectedText);
		return this;
	}
	
	public SearchHotelPage checkCheckInDateField(String ExpectedText) {
		LabelTextCheck(checkInDateField, ExpectedText);
		return this;
	}
	
	public SearchHotelPage checkCheckOutDateField(String ExpectedText) {
		LabelTextCheck(checkOutDateField, ExpectedText);
		return this;
	}
	
	public SearchHotelPage checkAdultPerRoomField(String ExpectedText) {
		LabelTextCheck(adultsPerRoomField, ExpectedText);
		return this;
	}
	
	public SearchHotelPage checkChildrenPerRoomField(String ExpectedText) {
		LabelTextCheck(childrenPerRoomField, ExpectedText);
		return this;
	}
	
	public SearchHotelPage checkSearchBtn(String ExpectedText) {
		String actualText=searchBtn.getAttribute("value");
		Assert.assertEquals(actualText, ExpectedText);
		return this;
	}
	
	public SearchHotelPage checkResetBtn(String ExpectedText) {
		String actualText=resetBtn.getAttribute("value");
		Assert.assertEquals(actualText, ExpectedText);
		return this;
	}
	
	public SearchHotelPage selectLocationDropDown(String location) {
		selectDropDownValue(locationDropDown, location);
		return this;
	}
	
	public SearchHotelPage selectHotelDropDown(String hotel) {
		selectDropDownValue(hotelDropDown, hotel);
		return this;
	}
	
	public SearchHotelPage selectRoomTypeDropDown(String roomType) {
		selectDropDownValue(roomTypeDropDown, roomType);
		return this;
	}
	
	public SearchHotelPage selectNumberOfRoomsDropDown(String numberOfRooms) {
		selectDropDownValue(numberOfRoomsDropDown, numberOfRooms);
		return this;
	}
	
	public SearchHotelPage enterCheckInDate(String checkInDate) {
		checkInDateInput.clear();
		actions.sendKeys(checkInDateInput, checkInDate);
		return this;
	}
	
	public SearchHotelPage enterCheckOutDate(String checkOutDate) {
		checkOutDateInput.clear();
		actions.sendKeys(checkOutDateInput, checkOutDate);
		return this;
	}
	
	public SearchHotelPage selectAdultsPerRoom(String adultsPerRoom) {
		selectDropDownValue(adultsPerRoomDropDown, adultsPerRoom);
		return this;
	}
	
	public SearchHotelPage selectChildrenPerRoom(String childrenPerRoom) {
		selectDropDownValue(childrenPerRoomDropDown, childrenPerRoom);
		return this;
	}
	
	public SelectHotelPage clickSearchBtn() {
		actions.click(searchBtn).perform();
		return new SelectHotelPage(driver);
	}
	
	public ChangePasswordPage clickChangePassword() {
		actions.click(changePasswordBtn).perform();
		return new ChangePasswordPage(driver);
	}
	
	public BookIternaryPage clickBookedItinerary() {
		actions.click(bookedIternaryBtn).perform();
		return new BookIternaryPage(driver);
	}
	
	public LogoutPage clickLogout() {
		actions.click(logoutBtn).perform();
		return new LogoutPage(driver);
	}
}
