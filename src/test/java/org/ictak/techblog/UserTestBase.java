package org.ictak.techblog;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.ictak.utilities.CaptureScreenshot;
import org.ictak.utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class UserTestBase {
	WebDriver driver;
	CaptureScreenshot ss = null;
	public static Properties prop = null;

	@BeforeSuite
	public void excelSetup() throws IOException {
		String excelFilePath = "src\\main\\resources\\TestData.xlsx";
		ExcelUtility.setExcelFile(excelFilePath, "Sheet1");
	}

	@BeforeTest
	public void beforeTestCase() throws IOException {
		prop = new Properties();
		FileInputStream props = new FileInputStream("src\\test\\resources\\config.properties");
		prop.load(props);

		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		WebElement usernameElement, passwordElement, loginButtonElement;
		// Login to the user account
		driver.get(prop.getProperty("loginUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		// Get user credentials from excel file
		String username = ExcelUtility.getCellData(0, 0);
		String password = ExcelUtility.getCellData(0, 1);

		// Login
		usernameElement = driver.findElement(By.id("user"));
		usernameElement.sendKeys(username);
		passwordElement = driver.findElement(By.id("pwd"));
		passwordElement.sendKeys(password);
		loginButtonElement = driver.findElement(By.id("logbut"));
		loginButtonElement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@BeforeMethod
	public void beforeTest() {
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterTest
	public void afterTestCase() {
		driver.findElement(By.xpath("//a[@id='nav' and text()='logout']")).click();
	}

	@AfterSuite
	public void afterTestSuite() {
		driver.quit();
	}
}
