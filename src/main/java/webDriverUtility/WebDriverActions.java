package webDriverUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverActions {
	public WebDriver driver;
	private String iframe;

	public WebDriverActions(WebDriver driver) {
		this.driver = driver;

	}
public void Alertaccept() {
		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.accept();

	}

	public void Alertdismiss() {
		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.dismiss();
	}

	public void iframes(By value) {
		driver.findElement(value);
		driver.switchTo().frame(iframe);
	}

	public void Javascripttestcase(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
		js.executeScript("arguments[0].scrollIntoView();",element);
		js.executeScript("window.scrollBy(0,250)", "");
	}
	// Common method implementation for webelement

		public void click(WebElement value) {
			value.click();
		}

		public void sendkeys(WebElement value, String value1) {
			value.clear();
			value.sendKeys(value1);
		}

		public void DropdownselectByvalue(WebElement dropdown, String value) {
			Select objSelect = new Select(dropdown);
			objSelect.selectByValue(value);

		}

		public void DropdownselectByIndex(WebElement dropdown, int value) {
			Select objSelect = new Select(dropdown);
			
	        objSelect.selectByIndex(value);
		}
		
		public String getText(WebElement value) {
			String Value = value.getText();
			return Value;
		}
		
		public void screenshot() throws IOException {
			
			Calendar cal=Calendar.getInstance();
			Date time=cal.getTime();
			String timestamp=time.toString().replace(":", "").replace(" ", "");
			
			System.out.println(time);
			System.out.println(timestamp);
			//Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)driver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination 
	               

	                File DestFile=new File("C:\\ObsquraFinalProject\\PRJ_OBSACCOUNT\\src\\test\\resources\\screenshot\\"+timestamp+"test.png");

	                //Copy file at destination
	      FileUtils.copyFile(SrcFile, DestFile);

	    }

		}
		

