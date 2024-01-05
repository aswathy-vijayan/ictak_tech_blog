package org.ictak.techblog;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class AdminFunctionalityTestBase {
	WebDriver driver;
	public static Properties prop = null;

	@BeforeTest
	public void setup() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources/config.properties");
		prop.load(ip);
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D://AutomationUtils//chromedriver.exe");
  			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			this.driver = new ChromeDriver();
		} else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D://AutomationUtils//drivers//geckodriver.exe");
			this.driver = new FirefoxDriver();
	//	} else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
//			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
//			this.driver=new EdgeDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
	}

