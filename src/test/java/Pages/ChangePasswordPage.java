package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.AdactinHotel;

public class ChangePasswordPage extends AdactinHotel {
	
	@FindBy(id="current_pass")
	WebElement currentPasword;
	
	@FindBy(id="current_pass_span")
	WebElement currentPassError;
	
	@FindBy(id="new_password")
	WebElement newPassword;
	
	@FindBy(id="pass_span")
	WebElement newPassError;
	
	@FindBy(id="re_password")
	WebElement confirmPassword;
	
	@FindBy(id="re_pass_span")
	WebElement confirmPassError;
	
	@FindBy(xpath = "//span[text()='Please enter correct current password!!!']")
	WebElement errorElement;
	
	@FindBy(xpath = "//span[text()='Your Password is successfully updated!!!']")
	WebElement successfullyChange;
	
	@FindBy(id="Submit")
	WebElement submitBtn;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutBtn;
	
	
	public ChangePasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public ChangePasswordPage enterCurrentPassword(String currentPassword) {
		actions.sendKeys(currentPasword,currentPassword).perform();
		return this;
	}
	
	public ChangePasswordPage enterNewPassword(String newPassword) {
		actions.sendKeys(this.newPassword,newPassword).perform();
		return this;
	}
	
	public ChangePasswordPage enterConfirmPassword(String confirmPassword) {
		actions.sendKeys(this.confirmPassword,confirmPassword).perform();
		return this;
	}
	
	public ChangePasswordPage clickSubmitBtn() {
		actions.click(submitBtn).perform();
		return this;
	}
	
	public void checkValidation(String TestType, String expecetdResult) {
		if (TestType.equalsIgnoreCase("InvalidCurrent")) {
			String actualText=errorElement.getText();
			Assert.assertEquals(actualText, expecetdResult);
		}else if (TestType.equalsIgnoreCase("InvalidNew")) {
			String actualText=newPassError.getText();
			Assert.assertEquals(actualText, expecetdResult);
		}else if (TestType.equalsIgnoreCase("InvalidConfirm")) {
			String actualText=confirmPassError.getText();
			Assert.assertEquals(actualText, expecetdResult);
		}else if (TestType.equalsIgnoreCase("valid")) {
			String actualText=successfullyChange.getText();
			Assert.assertEquals(actualText, expecetdResult);
			clickLogout();
		}
	}
	
	public LogoutPage clickLogout() {
		actions.click(logoutBtn).perform();
		return new LogoutPage(driver);
	}

}
