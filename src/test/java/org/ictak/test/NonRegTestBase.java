package org.ictak.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class NonRegTestBase {
	WebDriver driver;
	public static Properties prop=null;
	@BeforeMethod
	public void setup() throws IOException
	{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Core_Java\\Projects\\ictproject\\ictak_tech_blog\\src\\test\\resources\\config.properties");
		prop.load(ip);
//		driver=new ChromeDriver();		
	
		
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
	@AfterMethod
	public void closing() throws IOException
	{
		driver=new ChromeDriver();
		driver.quit();
	}
	
	
	//TechBlog

}
