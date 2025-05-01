package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.AdactinHotel;
import Pages.LoginPage;

public class TC_005_Register_with_valid_and_Invalid_scenarios extends AdactinHotel {
	
	@BeforeTest
	public void setUp() {
		sheetName="SignUp";
		TestName="Checking the SignUp Page";
		TestDescription="Verify the signUp with valid and invalid scenarios";
		testCategory="Valid and Invalid";
		testAuthor="Chakkaravarthi";
	}
	
	@Test(dataProvider = "readData",priority = 1)
	public void checkSignUp(String username, String password, String confrimPassword, String fullName, String email, String testType, String expectedResult) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickNewRegister().enterUsername(username).enterPassword(password).enterConfirmPassword(confrimPassword).enterFullName(fullName).enterEmail(email).enterCaptacha().selectCheckBox().clickRegisterButton().checkValidation(testType, expectedResult);
	}
	
	@Test(priority = 2)
	public void checkCaptachaEmptyError() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickNewRegister().enterUsername("").enterPassword("").enterConfirmPassword("").enterFullName("").enterEmail("").selectCheckBox().clickRegisterButton().checkValidation("InvalidCaptacha", "Captcha is Empty");
	}
	
	@Test(priority = 3)
	public void checkCheckBoxNotCheckError() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickNewRegister().enterUsername("").enterPassword("").enterConfirmPassword("").enterFullName("").enterEmail("").enterCaptacha().clickRegisterButton().checkValidation("InvalidCheckBox", "You must agree to Terms and Conditions");
	}
	
	@Test(priority = 4)
	public void checkReset() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickNewRegister().enterUsername("chakkaravar").enterPassword("123456").enterConfirmPassword("123456").enterFullName("").enterEmail("chakka").enterCaptacha().selectCheckBox().clickRegisterButton();
	}

}
