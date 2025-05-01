package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.AdactinHotel;

public class LogoutPage extends AdactinHotel {
	
	@FindBy(xpath = "//td[contains(text(),'You have successfully')]")
	WebElement successfulMessage;
	
	@FindBy(xpath = "//a[text()='Click here to login again']")
	WebElement redirectToLogin;
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public LogoutPage checkLogoutMessage(String expectedMessage) {
		String actualText=successfulMessage.getText();
		Assert.assertEquals(actualText, expectedMessage);
		return this;
	}
	
	public LoginPage clickLoginAgain() throws InterruptedException {
		actions.click(redirectToLogin).perform();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://adactinhotelapp.com/index.php");
		return new LoginPage(driver);
	}

}
