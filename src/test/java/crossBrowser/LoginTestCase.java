package crossBrowser;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import extendReport.ExtendTestManager;
import pomTestCases.POMLogin;
import pomTestCases.POMUnits;
import waitUtility.WaitCondition;
import webDriverUtility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTestCase extends ExtendTestManager {
	static WebDriver driver;
	POMLogin objPomLogin;
	ExtentTest test;
	public ExtentReports extent;
	
	static String url = "https://qalegend.com/billing/public/login";
	//static String browser = "chrome";
	ExtendTestManager objTestManager;
	
	@Test(priority = 1, enabled = true)
	public void logIn() throws IOException {
		test=extent.createTest("Validating login scenario");
		boolean Status;
		String username = ExcelRead.readStringData(1, 0);
		String password = ExcelRead.integerData(1, 1);
		objPomLogin.login(username, password);

		String current_url = driver.getCurrentUrl();
		SoftAssert asser = new SoftAssert();
		if(PropertyFileRead.readConfigFile("url").contains(current_url))
		{
			
			asser.assertTrue(true);
			Status=true;
		}
		else {
			asser.assertTrue(false);
			Status=false;
		}
		
		asser.assertAll();
		if(Status==true)
		{
			test.log(com.aventstack.extentreports.Status.PASS, "Login successfully to the application");
		}
		else if(Status==false) {
			test.log(com.aventstack.extentreports.Status.FAIL, "Login failed");
		}
		
	}
@BeforeTest
	  @Parameters({"browser1"})
	public void beforeTest(String browser1) {
		DriverManager objDriverManager = new DriverManager();
		objDriverManager.launchBrowser(url, browser1);
		driver = objDriverManager.driver;
		objPomLogin = new POMLogin(driver);
		objTestManager=new ExtendTestManager();
		extent=objTestManager.extendreportgenerate();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}