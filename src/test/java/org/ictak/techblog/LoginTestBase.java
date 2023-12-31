package org.ictak.techblog;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.ictak.utilities.ExcelUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class LoginTestBase {
	
	WebDriver driver;
	public static Properties prop=null;
	
	@BeforeMethod
	public void setup() throws IOException {
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\Nithin Shaji\\eclipse-workspace\\ictproject\\ictak_tech_blog\\src\\test\\resources\\config.properties");
		prop.load(ip);
		
//		driver = new ChromeDriver();
//		driver.get(prop.getProperty("url"));
		
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		}
	@BeforeSuite
    public void excelSetup() throws IOException {
        String excelFilePath = "C:\\Users\\Nithin Shaji\\eclipse-workspace\\ictproject\\ictak_tech_blog\\src\\main\\resources\\TestData.xlsx";
        ExcelUtility.setExcelFile(excelFilePath, "Sheet1");
    }
	
	@AfterMethod
	public void closing() throws IOException
	{
		driver=new ChromeDriver();
		driver.quit();
	}

}
