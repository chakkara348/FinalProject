package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.AdactinHotel;

public class SignUpPage extends AdactinHotel {

	@FindBy(xpath = "//td[@class='login_title']")
	WebElement signUpPageHeadingElement;

	@FindBy(id = "username")
	WebElement signUpUsernameInputElement;

	@FindBy(id = "username_span")
	WebElement userNameErrorElement;

	@FindBy(id = "password")
	WebElement signUpPasswordInputElement;

	@FindBy(id = "password_span")
	WebElement passwordErrorElement;

	@FindBy(id = "re_password")
	WebElement signUpConfirmPassInputElement;

	@FindBy(id = "re_password_span")
	WebElement confirmPassErrorElement;

	@FindBy(id = "full_name")
	WebElement signUpFullNameInputElement;

	@FindBy(id = "full_name_span")
	WebElement fullNameErrorElement;

	@FindBy(id = "email_add")
	WebElement signUpEmailInputElement;

	@FindBy(id = "email_add_span")
	WebElement emailErrorElement;

	@FindBy(id = "captcha-form")
	WebElement enterCaptachaInputElement;

	@FindBy(id = "captcha_span")
	WebElement captachaErrorElement;

	@FindBy(id = "tnc_box")
	WebElement signUpTermsAndCondCheckBoxElement;

	@FindBy(id = "tnc_span")
	WebElement checkBoxErrorElement;

	@FindBy(id = "Submit")
	WebElement RegisterBtn;

	@FindBy(id = "Reset")
	WebElement resetBtn;

	@FindBy(xpath = "//a[text()='Go back to Login page']")
	WebElement backToLoginPageBtn;

	@FindBy(xpath = "//td[contains(text(),'email verification code')]")
	WebElement registerConfirmation;

	@FindBy(xpath = "//span[contains(text(),'Note')]")
	WebElement noteMessageOnRegisteredpage;

	@FindBy(xpath = "//a[text()='Click here to login']")
	WebElement clickLoginBtnAfterRegister;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SignUpPage checkingFieldsAreDisplayed() {
		OptionDisplayedCheck(signUpPageHeadingElement);
		OptionDisplayedCheck(signUpUsernameInputElement);
		OptionDisplayedCheck(signUpPasswordInputElement);
		OptionDisplayedCheck(signUpConfirmPassInputElement);
		OptionDisplayedCheck(signUpFullNameInputElement);
		OptionDisplayedCheck(signUpEmailInputElement);
		OptionDisplayedCheck(enterCaptachaInputElement);
		OptionDisplayedCheck(signUpTermsAndCondCheckBoxElement);
		OptionDisplayedCheck(RegisterBtn);
		OptionDisplayedCheck(resetBtn);
		OptionDisplayedCheck(backToLoginPageBtn);
		return this;
	}

	public SignUpPage CheckOptionsAreClickable() {
		OptionsAreClickable(signUpTermsAndCondCheckBoxElement);
		OptionsAreClickable(RegisterBtn);
		OptionsAreClickable(resetBtn);
		OptionsAreClickable(backToLoginPageBtn);
		return this;
	}

	public SignUpPage enterUsername(String username) {
		actions.sendKeys(signUpUsernameInputElement, username).perform();
		return this;
	}

	public SignUpPage enterPassword(String password) {
		actions.sendKeys(signUpPasswordInputElement, password).perform();
		return this;
	}

	public SignUpPage enterConfirmPassword(String confirmPassword) {
		actions.sendKeys(signUpConfirmPassInputElement, confirmPassword).perform();
		return this;
	}

	public SignUpPage enterFullName(String fullName) {
		actions.sendKeys(signUpFullNameInputElement, fullName).perform();
		return this;
	}

	public SignUpPage enterEmail(String email) {
		actions.sendKeys(signUpEmailInputElement, email).perform();
		return this;
	}

	public SignUpPage enterCaptacha() throws InterruptedException {
		actions.click(enterCaptachaInputElement).perform();
		Thread.sleep(20000);
		return this;
	}

	public SignUpPage selectCheckBox() {
		actions.click(signUpTermsAndCondCheckBoxElement).perform();
		return this;
	}

	public SignUpPage clickRegisterButton() throws InterruptedException {
		actions.click(RegisterBtn).perform();
		Thread.sleep(5000);
		return this;
	}

	public SignUpPage checkValidation(String testType, String expectedResult) {
		switch (String.valueOf(testType)) {
		case "InvalidUsername":
			String actualUserNameResult = userNameErrorElement.getText();
			Assert.assertEquals(actualUserNameResult, expectedResult);
			break;
		case "InvalidPassword":
			String actualPassResult = passwordErrorElement.getText();
			Assert.assertEquals(actualPassResult, expectedResult);
			break;
		case "InvalidConfirm":
			String actualConfirmPassResult = confirmPassErrorElement.getText();
			Assert.assertEquals(actualConfirmPassResult, expectedResult);
			break;
		case "InvalidFull":
			String actualfullNameResult = fullNameErrorElement.getText();
			Assert.assertEquals(actualfullNameResult, expectedResult);
			break;
		case "InvalidEmail":
			String actualEmailResult = emailErrorElement.getText();
			Assert.assertEquals(actualEmailResult, expectedResult);
			break;
		case "InvalidCaptcha":
			String actualCaptachaResult = captachaErrorElement.getText();
			Assert.assertEquals(actualCaptachaResult, expectedResult);
			break;
		case "InvalidCheckBox":
			String actualCheckBoxResult = checkBoxErrorElement.getText();
			Assert.assertEquals(actualCheckBoxResult, expectedResult);
			break;
		case "ValidCaptcha":
			String actualValidCaptchaResult = captachaErrorElement.getText();
			Assert.assertEquals(actualValidCaptchaResult, expectedResult);
			break;
		case "Valid":
			String actualResult = registerConfirmation.getText();
			Assert.assertEquals(actualResult, expectedResult);
			clickLogin();
			break;
		}
		return this;
	}

	public LoginPage clickLogin() {
		actions.click(clickLoginBtnAfterRegister).perform();
		return new LoginPage(driver);
	}
	
	public SignUpPage clickResetBtn() throws InterruptedException {
		actions.click(resetBtn).perform();
		Thread.sleep(3000);
		Assert.assertEquals(signUpUsernameInputElement.getText(), "");
		Assert.assertEquals(signUpPasswordInputElement.getText(), "");
		Assert.assertEquals(signUpConfirmPassInputElement.getText(), "");
		Assert.assertEquals(signUpFullNameInputElement.getText(), "");
		Assert.assertEquals(signUpEmailInputElement.getText(), "");
		Assert.assertEquals(enterCaptachaInputElement.getText(), "");
		Assert.assertTrue(signUpTermsAndCondCheckBoxElement.isSelected());
		return this;
	}
}
