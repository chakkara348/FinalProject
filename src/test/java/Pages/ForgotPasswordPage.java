package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.AdactinHotel;

public class ForgotPasswordPage extends AdactinHotel{
	
	@FindBy(id="emailadd_recovery")
	WebElement emailElement;
	
	@FindBy(id="emailadd_span")
	WebElement emailErrorElement;
	
	@FindBy(id="Submit")
	WebElement EmailPasswordBtn;
	
	@FindBy(id="Reset")
	WebElement ResetBtn;
	
	@FindBy(xpath = "//td[contains(text(),'Please check your email')]")
	WebElement ForgotPasswordConfirmationMessage;
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ForgotPasswordPage enterEmail(String email) {
		actions.sendKeys(emailElement,email).perform();
		return this;
	}
	
	public ForgotPasswordPage clickEmailPasswordBtn() throws InterruptedException {
		actions.click(EmailPasswordBtn).perform();
		Thread.sleep(3000);
		return this;
	}
	
	public void checkValidation(String TestType, String expectedResult) {
		if (TestType.equalsIgnoreCase("invalidemail")) {
			String actualText=emailErrorElement.getText();
			Assert.assertEquals(actualText, expectedResult);
		}else if (TestType.equalsIgnoreCase("valid")) {
			String actualText=ForgotPasswordConfirmationMessage.getText();
			Assert.assertEquals(actualText, expectedResult);			
		}
	}
	
	public ForgotPasswordPage clickResetBtn() {
		actions.click(ResetBtn).perform();
		Assert.assertEquals(emailElement.getText(), "");
		return this;
	}

}
