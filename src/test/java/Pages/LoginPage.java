package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.AdactinHotel;

public class LoginPage extends AdactinHotel {

	@FindBy(id = "username")
	WebElement loginUsernameInputElement;

	@FindBy(id = "password")
	WebElement loginPasswordInputElement;

	@FindBy(id = "login")
	WebElement LoginBtn;

	@FindBy(xpath = "//a[text()='Forgot Password?']")
	WebElement ForgotPassword;

	@FindBy(xpath = "//a[text()='New User Register Here']")
	WebElement SignUpBtn;

	@FindBy(xpath = "//td[text()='Existing User Login - Build 1']")
	WebElement loginPageHeading;

	@FindBy(id = "username_span")
	WebElement usernameErrorElement;

	@FindBy(id = "password_span")
	WebElement passwordErrorElement;

	@FindBy(xpath = "//b[contains(text(),'Invalid Login')]")
	WebElement errorMessageElement;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to check the Options are visible on the Login Page
	public LoginPage checkingFieldsAreDisplayed() {
		OptionDisplayedCheck(loginPageHeading);
		OptionDisplayedCheck(loginUsernameInputElement);
		OptionDisplayedCheck(loginPasswordInputElement);
		OptionDisplayedCheck(LoginBtn);
		OptionDisplayedCheck(ForgotPassword);
		OptionDisplayedCheck(SignUpBtn);
		return this;
	}

	// Method to check the buttons and link are clickable
	public LoginPage CheckingButtonAreClickable() {
		OptionsAreClickable(LoginBtn);
		OptionsAreClickable(ForgotPassword);
		OptionsAreClickable(SignUpBtn);
		return this;
	}

	public LoginPage enterUsername(String username) {
		actions.sendKeys(loginUsernameInputElement, username).perform();
		return this;
	}

	public LoginPage enterPassword(String password) {
		actions.sendKeys(loginPasswordInputElement, password).perform();
		return this;
	}

	public LoginPage clickLoginBtn() {
		actions.click(LoginBtn).perform();
		return this;
	}

	public LoginPage LoginValidation(String TestType, String expectedMessage) throws InterruptedException {
		if (TestType.equalsIgnoreCase("invalidusername")) {
			String actualError = errorMessageElement.getText();
			Assert.assertEquals(actualError, expectedMessage);
		}else if (TestType.equalsIgnoreCase("invalidpassword")) {
			String actualError = errorMessageElement.getText();
			Assert.assertEquals(actualError, expectedMessage);
		} else if (TestType.equalsIgnoreCase("emptyusername")) {
			String actualError = usernameErrorElement.getText();
			Assert.assertEquals(actualError, expectedMessage);
		} else if (TestType.equalsIgnoreCase("emptypassword")) {
			String actualError = passwordErrorElement.getText();
			Assert.assertEquals(actualError, expectedMessage);
		} else if (TestType.equalsIgnoreCase("emailnotverify")) {
			String actualError = errorMessageElement.getText();
			Assert.assertEquals(actualError, expectedMessage);
		} else if (TestType.equalsIgnoreCase("bothinvalid")) {
			String actualError = errorMessageElement.getText();
			Assert.assertEquals(actualError, expectedMessage);
		}
		else if (TestType.equalsIgnoreCase("valid")) {
			Thread.sleep(3000);
			String actualUrl = driver.getCurrentUrl();
			Assert.assertEquals(actualUrl, expectedMessage);
		}
		return this;

	}

	// Method to click New register user page
	public SignUpPage clickNewRegister() {
		SignUpBtn.click();
		return new SignUpPage(driver);
	}
	
	//Method to click Forgot Password
	public ForgotPasswordPage clickForgotPassword() {
		ForgotPassword.click();
		return new ForgotPasswordPage(driver);
	}

}
