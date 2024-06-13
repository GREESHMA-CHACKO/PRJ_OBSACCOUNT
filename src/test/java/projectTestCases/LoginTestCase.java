package projectTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import excelUtility.ExcelRead;
import pomTestCases.POMLogin;
import webDriverUtility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTestCase {
	static String url="https://qalegend.com/billing/public/products";
	static String browser="chrome";
	POMLogin objpomlogin;
	static WebDriver driver;

	  
//  using excel read
		
	
@Test(priority=1,enabled=true)
public void f() throws IOException, InterruptedException {
	  

	  String userName=ExcelRead.readStringData(1, 0);
	  String password=ExcelRead.integerData(1, 1);
	  objpomlogin.login(userName,password);		
	  
	  String currenturl="https://qalegend.com/billing/public/products";
	  String url=driver.getCurrentUrl();
	  //soft assert
	  SoftAssert val=new SoftAssert();
	  val.assertEquals(url, currenturl);
	  val.assertAll();
	  //hard assert
	  //Assert.assertFalse(currenturl.contains(url));
}
	  
	  


@BeforeTest

public void beforeTest() throws InterruptedException {
	
	  DriverManager obj1=new DriverManager();
		obj1.launchbrowser(url,browser);
		driver=obj1.driver;
		
		objpomlogin=new POMLogin(driver);
		
}@AfterTest
public void afterTest() {
	 
}
}
