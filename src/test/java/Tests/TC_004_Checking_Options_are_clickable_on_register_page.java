package Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.AdactinHotel;
import Pages.LoginPage;

public class TC_004_Checking_Options_are_clickable_on_register_page extends AdactinHotel {
	
	@BeforeTest
	public void setUp() {
		TestName="Checking Fields are clickable on the Register Screen";
		TestDescription="Verify the optios on the Register Screen are clickable";
		testCategory="Valid";
		testAuthor="Chakkaravarthi";
	}
	
	@Test
	public void checkingRegisterPageFieldsAreClickable() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickNewRegister()
		.CheckOptionsAreClickable();
	}

}
