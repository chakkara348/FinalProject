package Utils;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import Base.AdactinHotel;

public class Listeners extends AdactinHotel implements ITestListener {
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(Status.PASS, "Test case is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.fail(result.getThrowable());
		String screenShot="";
		
		try {
			screenShot = Screenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentTest.addScreenCaptureFromPath(screenShot, "Failure Screenshot");
	}

}
