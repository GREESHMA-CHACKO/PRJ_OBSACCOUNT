package webDriverUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
	public WebDriver driver;
	
	public void launchbrowser(String url,String Browser)
	{
		if(Browser.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
		if(Browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
	}
	public void closebrowser()
	{
		driver.close();
	}
}
