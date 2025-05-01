package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class utilityClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions actions;
	public String sheetName,OrderNumber;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public String TestName, TestDescription,testCategory, testAuthor;
	public int totalPriceWithOutGST,totalPriceWithGST;

	//Method to launch the browser
	public void launchBrowser(String browser, String url) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(url);
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		actions = new Actions(driver);
	}

	//Method to close the browser
	public void closeBrowser() {

		driver.close();
	}
	
	//Method to read a data from excel sheet
	public static String[][] readExcel(String sheetName) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook(
				"C:\\Users\\cmurugan\\eclipse-workspace\\FinalProject\\src\\test\\resources\\Data\\UserTestData.xlsx");
		XSSFSheet sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		short colunmnCount = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[rowCount][colunmnCount];
		for (int i = 1; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < colunmnCount; j++) {
				Cell cell = row.getCell(j);
				if (cell==null) {
					data[i - 1][j] ="";
				} else {
					data[i - 1][j] = cell.getStringCellValue();
				}
			}
		}
		book.close();
		return data;

	}

	//Method to capture the screenshot for failed test cases
	public static String Screenshot(String name) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String path = "C:\\Users\\cmurugan\\eclipse-workspace\\MiniProject-1\\src\\test\\resources\\snap\\" + name
				+ timeStamp + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;

	}
	
	//Method to check elements are displayed or not
	public void OptionDisplayedCheck(WebElement element) {
		Assert.assertTrue(element.isDisplayed());
	}
	
	//Method to check Buttons and Link are clickable
	public void OptionsAreClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//Method to check Label text
	public void LabelTextCheck(WebElement element,String expectedText) {
		String actualText = element.getText();
		Assert.assertEquals(actualText, expectedText);
	}
	
	//Method to select dropdown value
	public void selectDropDownValue(WebElement element, String options) {
		Select select = new Select(element);
		select.selectByValue(options);
	}

}
