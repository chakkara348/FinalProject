package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.AdactinHotel;
import Pages.LoginPage;

public class TC_003_Checking_fields_on_Register_page_are_displayed extends AdactinHotel {
	
	@BeforeTest
	public void setUp() {
		TestName="Checking Fields are visible on the Register Screen";
		TestDescription="Verify the Fields on the Register Screen are visible";
		testCategory="Valid";
		testAuthor="Chakkaravarthi";
	}
	
	@Test
	public void checkingRegisterPageFieldsAreDisplayed() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickNewRegister()
		.checkingFieldsAreDisplayed();
	}

}
