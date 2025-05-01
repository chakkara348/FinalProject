package Pages;

import static org.testng.Assert.assertListContains;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Base.AdactinHotel;

public class BookIternaryPage extends AdactinHotel {
	
	@FindBy(id="check_all")
	WebElement checkAllOption;
	
	@FindBy(xpath = "//table[@cellspacing='1']/tbody/tr")
	WebElement noOfOrdersCountElement;
	
	@FindBy(xpath = "//table[@cellspacing='1']/tbody/tr[2]/td[1]")
	WebElement checkRadioOptionToDelete;
	
	@FindBy(xpath = "//table[@cellspacing='1']/tbody/tr[2]/td[2]")
	WebElement OrderNumber;
	
	@FindBy(xpath = "//table[@cellspacing='1']/tbody/tr[2]/td[3]")
	WebElement cancelOptionFromTable;
	
	@FindBy(xpath = "//input[@name='cancelall']")
	WebElement cancelSelectedOption;
	
	public BookIternaryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public BookIternaryPage clickCancelBtn() throws InterruptedException {
		String orderNo=OrderNumber.getText();
		actions.click(cancelOptionFromTable).perform();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		if (OrderNumber.getText()!=orderNo) {
			System.out.println("The order is deleted");
		}else {
			System.out.println("Order is not deleted");
		}
		
		return this;
	}
	
	public BookIternaryPage cancelBySingleCheckBox() throws InterruptedException {
		String orderNo=OrderNumber.getText();
		actions.click(checkRadioOptionToDelete).perform();
		actions.click(cancelSelectedOption).perform();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		if (OrderNumber.getText()!=orderNo) {
			System.out.println("The order is deleted");
		}else {
			System.out.println("Order is not deleted");
		}
		return this;
	}
	
	public BookIternaryPage cancelByCheckAllOption() throws InterruptedException {
		List beforeRowsCount=noOfOrdersCountElement.findElements(By.xpath("//table[@cellspacing='1']/tbody/tr"));
		int BeforeDeleteCount=beforeRowsCount.size();
		actions.click(checkAllOption).perform();
		actions.click(cancelSelectedOption).perform();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		List afterRowsCount=noOfOrdersCountElement.findElements(By.xpath("//table[@cellspacing='1']/tbody/tr"));
		int AfterDeleteCount=afterRowsCount.size();
		if (BeforeDeleteCount!=AfterDeleteCount) {
			System.out.println("The orders is deleted");
		}else {
			System.out.println("Order is not deleted");
		}
		return this;
	}

}
