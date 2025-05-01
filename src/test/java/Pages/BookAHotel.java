package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.AdactinHotel;

public class BookAHotel extends AdactinHotel {

	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	WebElement BookAHotelHeading;
	
	@FindBy(id="first_name")
	WebElement firstNameInput;
	
	@FindBy(id="first_name_span")
	WebElement firstNameErrorMessage;
	
	@FindBy(id="last_name")
	WebElement lastNameInput;
	
	@FindBy(id="last_name_span")
	WebElement LastNameErrorMessage;
	
	@FindBy(id="address")
	WebElement billingAddressInput;
	
	@FindBy(id="address_span")
	WebElement billingAddressErrorMessage;
	
	@FindBy(id="cc_num")
	WebElement creditCardNumberInput;
	
	@FindBy(id="cc_num_span")
	WebElement creditCardNumberErrorMessage;
	
	@FindBy(id="cc_type")
	WebElement cardTypeInput;
	
	@FindBy(id="cc_type_span")
	WebElement creditCardTypeErrorMessage;
	
	@FindBy(id="cc_exp_month")
	WebElement expireDateMonthInput;
	
	@FindBy(id="cc_expiry_span")
	WebElement expiryErrorMessage;
	
	@FindBy(id="cc_exp_year")
	WebElement expiryDateYearInput;
	
	@FindBy(id="cc_cvv")
	WebElement cvvNumberInput;
	
	@FindBy(id="cc_cvv_span")
	WebElement cvvErrorMessage;
	
	@FindBy(id="book_now")
	WebElement bookNowBtn;
	
	@FindBy(id="cancel")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//td[@class='login_title']/a")
	WebElement backBtn;
	
	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	WebElement bookingConfirmationHeading;
	
	@FindBy(id="order_no")
	WebElement orderNoElement;
	
	@FindBy(id="my_itinerary")
	WebElement myIternarybtn;
	
	public BookAHotel(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public BookAHotel hotelPageHeadingVerification(String expectedResult) {
		String actualText=BookAHotelHeading.getText();
		Assert.assertEquals(actualText,expectedResult);
		return this;
	}
	
	public BookAHotel enterFirstName(String firstname) {
		actions.sendKeys(firstNameInput, firstname).perform();
		return this;
	}
	
	public BookAHotel enterLastName(String lastname) {
		actions.sendKeys(lastNameInput, lastname).perform();
		return this;
	}
	
	public BookAHotel enterBillingAddress(String address) {
		actions.sendKeys(billingAddressInput, address).perform();
		return this;
	}
	
	public BookAHotel enterCreditCardNumber(String number) {
		actions.sendKeys(creditCardNumberInput, number).perform();
		return this;
	}
	
	public BookAHotel selectCardType(String cardType) {
		selectDropDownValue(cardTypeInput, cardType);
		return this;
	}
	
	public BookAHotel selecExpiryMonth(String month) {
		selectDropDownValue(expireDateMonthInput, month);
		return this;
	}
	
	public BookAHotel selecExpiryYear(String year) {
		selectDropDownValue(expiryDateYearInput, year);
		return this;
	}
	
	public BookAHotel enterCVVNumber(String cvv) {
		actions.sendKeys(cvvNumberInput, cvv).perform();
		return this;
	}
	
	public BookAHotel clickBookNow() {
		actions.click(bookNowBtn).perform();
		return this;
	}
	
	public BookAHotel checkBookConfirmation(String testType, String expectedText) {
		if (testType.equalsIgnoreCase("invalidfirstname")) {
			String actualtext = firstNameErrorMessage.getText();
			Assert.assertEquals(actualtext, expectedText);	
		}else if (testType.equalsIgnoreCase("invalidlastname")) {
			String actualtext = LastNameErrorMessage.getText();
			Assert.assertEquals(actualtext, expectedText);	
		}else if (testType.equalsIgnoreCase("invalidaddress")) {
			String actualtext = billingAddressErrorMessage.getText();
			Assert.assertEquals(actualtext, expectedText);			
		}else if (testType.equalsIgnoreCase("invalidcreditcardnumber")) {
			String actualtext = creditCardNumberErrorMessage.getText();
			Assert.assertEquals(actualtext, expectedText);
		}else if (testType.equalsIgnoreCase("invalidcardtype")) {
			String actualtext = creditCardTypeErrorMessage.getText();
			Assert.assertEquals(actualtext, expectedText);
		}else if (testType.equalsIgnoreCase("invalidmonth")) {
			String actualtext = expiryErrorMessage.getText();
			Assert.assertEquals(actualtext, expectedText);
		}else if (testType.equalsIgnoreCase("invalidyear")) {
			String actualtext = expiryErrorMessage.getText();
			Assert.assertEquals(actualtext, expectedText);
		}else if (testType.equalsIgnoreCase("invalidcvv")) {
			String actualtext = cvvErrorMessage.getText();
			Assert.assertEquals(actualtext, expectedText);
		}else if (testType.equalsIgnoreCase("valid")) {
			Assert.assertTrue(bookingConfirmationHeading.isDisplayed());
			Assert.assertTrue(orderNoElement.isDisplayed());
		}
		return this;
	}
	
	public BookIternaryPage clickMyIternary() {
		actions.click(myIternarybtn).perform();
		return new BookIternaryPage(driver);
	}
	
	
}
