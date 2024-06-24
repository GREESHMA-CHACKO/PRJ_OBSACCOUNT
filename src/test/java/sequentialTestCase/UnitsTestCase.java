package sequentialTestCase;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import pomTestCases.POMBrands;
import pomTestCases.POMCategories;
import pomTestCases.POMLogin;
import pomTestCases.POMUnits;
import webDriverUtility.DriverManager;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class UnitsTestCase{
	
	POMLogin objPOMLogin;
	POMUnits objPOMUnit;
	SoftAssert softassert=new SoftAssert();
	public static WebDriver driver;
	LoginTestCase objlogin=new LoginTestCase();
	@Test(priority = 1, enabled = true, dataProvider="testdata")
	public void Add_units(String tData1,String tData2) throws InterruptedException, IOException {
		objPOMLogin=new POMLogin(objlogin.driver);
		objPOMUnit=new POMUnits(objlogin.driver);
		
		objPOMLogin.product_click();
		//objPOMUnit=new POMUnits(driver);
		objPOMUnit.units_click();
		objPOMUnit.addUnits(tData1,tData2);
		
		String actual_message="Unit added successfully";
		String message=objPOMUnit.getMessage();
		
		Assert.assertTrue(actual_message.contains(message));
	

		
		
	}
	
	@Test(priority = 2, enabled = true)
	public void search_units() throws InterruptedException
	{
		boolean status=objPOMUnit.searchUnits(PropertyFileRead.readConfigFile("unit_test_data"));
		SoftAssert asser=new SoftAssert();
		asser.assertEquals(status, true);
		asser.assertAll();
		
	}
	
	@Test(priority = 3, enabled = true)
	public void deleteUnits() throws InterruptedException
	{
		objPOMUnit.delete_unit(PropertyFileRead.readConfigFile("unit_test_data"));
		
		String actual_message="Unit deleted successfully";
		String message=objPOMUnit.getMessage();
		SoftAssert asser=new SoftAssert();
		asser.assertEquals(actual_message,message);
		asser.assertAll();
		
	}

	 @DataProvider(name="testdata")
	  public Object[][] TestDataFeed(){

	  // Create object array with 1 rows and 2 column- first parameter is row and second is //column
	  Object [][] unitsData=new Object[1][2];

	  // Enter data to row 0 column 0
	  unitsData[0][0]="Test_unit";
	  // Enter data to row 0 column 1
	  unitsData[0][1]="t_unit";
	  
	  return unitsData;
	  }

}