package org.ictak.techblog;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.ictak.utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TrainerEditTestBase {
	WebDriver driver;
	public static Properties prop = null;

	@BeforeSuite
	public void excelSetup() throws IOException {
		String excelFilePath = "src\\main\\resources\\TestData.xlsx";
		ExcelUtility.setExcelFile(excelFilePath, "Sheet1");
	}

	@BeforeTest
	public void beforeTestCase() throws InterruptedException, IOException {
		prop = new Properties();
		FileInputStream props = new FileInputStream("src\\test\\resources\\config.properties");
		prop.load(props);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebElement usernameElement, passwordElement, loginButtonElement;
		// Login to the trainer account
		driver.get(prop.getProperty("loginUrl"));

		// Get trainer credentials from excel file
		String username = ExcelUtility.getCellData(6, 0);
		String password = ExcelUtility.getCellData(6, 1);

		// Login
		usernameElement = driver.findElement(By.id("user"));
		usernameElement.sendKeys(username);
		passwordElement = driver.findElement(By.id("pwd"));
		passwordElement.sendKeys(password);
		loginButtonElement = driver.findElement(By.id("logbut"));
		loginButtonElement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Go to my posts page
		driver.findElement(By.xpath("//a[@id='nav' and text()='My posts']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Click edit button of last post
		WebElement editButton = driver.findElement(By.xpath("(//button[text()='Edit'])[last()]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", editButton);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@BeforeMethod
	public void beforeTestMethod() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@AfterTest
	public void afterTestCase() {
		driver.findElement(By.xpath("//a[@id='nav' and text()='logout']")).click();
	}
}
