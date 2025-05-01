package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.AdactinHotel;

public class SelectHotelPage extends AdactinHotel {
	
	
	@FindBy(id="location_span")
	WebElement locationErrorMessage;
	
	@FindBy(id="checkin_span")
	WebElement checkInDateErrorMessage;
	
	@FindBy(id="checkout_span")
	WebElement checkOutDateErrorMessage;
	
	@FindBy(xpath = "//td[text()='Select Hotel ']")
	WebElement SelectHotelTitle;
	
	@FindBy(id="radiobutton_0")
	WebElement selectHotelFromList;
	
	@FindBy(id="hotel_name_0")
	WebElement hotelNameElement;
	
	@FindBy(id="location_0")
	WebElement locationNameElement;
	
	@FindBy(id="arr_date_0")
	WebElement arrivalDate;
	
	@FindBy(id="dep_date_0")
	WebElement departureDate;
	
	@FindBy(id="total_price_0")
	WebElement totalPriceElement;
	
	@FindBy(id="continue")
	WebElement selectContinueBtn;
	
	@FindBy(id="radiobutton_span")
	WebElement selectHotelErrorMessage;
	
	@FindBy(id="cancel")
	WebElement selectCancelBtn;
	
	public SelectHotelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public SelectHotelPage SearchedValidation(String testType,String expectedTitle) {
		if (testType.equalsIgnoreCase("Invalid")) {
			String actualTitle = locationErrorMessage.getText();
			Assert.assertEquals(actualTitle,expectedTitle);
		}else if (testType.equalsIgnoreCase("invalidcheckindate")) {
			String actualTitle = checkInDateErrorMessage.getText();
			Assert.assertEquals(actualTitle,expectedTitle);
		}else if (testType.equalsIgnoreCase("invalidcheckoutdate")) {
			String actualTitle = checkOutDateErrorMessage.getText();
			Assert.assertEquals(actualTitle,expectedTitle);
		}else if (testType.equalsIgnoreCase("valid")) {
			String actualTitle = SelectHotelTitle.getText();
			Assert.assertEquals(actualTitle,expectedTitle);
		}
		return this;
	}
	
	
	public SelectHotelPage checkSearchedHotelName(String hotelName) {
		String actualHotelName = hotelNameElement.getAttribute("value");
		Assert.assertEquals(actualHotelName, hotelName);
		return this;
	}
	
	public SelectHotelPage checkSearchedLocationName(String location) {
		String actualLocationName = locationNameElement.getAttribute("value");
		Assert.assertEquals(actualLocationName,location);
		return this;
	}
	
	public SelectHotelPage checkArrivalDate(String expectedArrivalDate) {
		String actualLocationName = arrivalDate.getAttribute("value");
		Assert.assertEquals(actualLocationName,expectedArrivalDate);
		return this;
	}
	
	public SelectHotelPage checkDepartureDate(String expectedDepartureDate) {
		String actualLocationName = departureDate.getAttribute("value");
		Assert.assertEquals(actualLocationName,expectedDepartureDate);
		return this;
	}
	
	public SelectHotelPage selectRadioOption() {
		selectHotelFromList.click();
		return this;
	}
	
	public SelectHotelPage checkRadioOptionIsSelected() {
		Assert.assertTrue(selectHotelFromList.isSelected());
		return this;
	}
	
	public SelectHotelPage selectContinue() {
		actions.click(selectContinueBtn).perform();
		return this;
		
	}
	
	public void checkSelectHotelValidation(String testType, String expectedText) {
		if (testType.equalsIgnoreCase("invalid")) {
			checkValidation(expectedText);			
		}else if (testType.equalsIgnoreCase("valid")) {
			bookAHotelPage(expectedText);
		}
	}
	
	public SelectHotelPage checkValidation(String expectedResult) {
		String actualText=selectHotelErrorMessage.getText();
		Assert.assertEquals(actualText, expectedResult);
		return this;
	}
	
	public BookAHotel bookAHotelPage(String expectedResult) {
		return new BookAHotel(driver).hotelPageHeadingVerification(expectedResult);
		
	}

}
