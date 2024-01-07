package org.ictak.techblog;

import java.time.Duration;
import java.io.IOException;
import org.ictak.constants.AutomationConstants;
import org.ictak.pages.LoginPage;
import org.ictak.utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestClass extends LoginTestBase {
	
	LoginPage log;
	
	@Test(priority=6)
	public void validLogin() throws IOException, InterruptedException {
		log=new LoginPage(driver);
		String emailid=ExcelUtility.getCellData(0, 0);
		String password=ExcelUtility.getCellData(0, 1);
		
		log.setemailid(emailid);
		log.setpassword(password);
		log.LoginClick();
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

		

		
//		String expectedtitle="http://64.227.132.106/mypost";
//	    String Displayhome=driver.getCurrentUrl();
//	    Assert.assertEquals(Displayhome,expectedtitle);
	
		
		String actualResult=log.ConfirmLog();
		System.out.println(actualResult);
		Assert.assertEquals(actualResult, AutomationConstants.ExpectedText);

	}
//	
	@Test(priority=2)
	public void Invalidemailloginpage() throws InterruptedException{
		log=new LoginPage(driver);
		String emailid=ExcelUtility.getCellData(1, 0);
		System.out.println(emailid);
		String password=ExcelUtility.getCellData(1, 1);
		log.setemailid(emailid);
		log.setpassword(password);
		log.LoginClick();
		Thread.sleep(2000);
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		String actualResult=log.getError();
		System.out.println(actualResult);
		Assert.assertEquals(actualResult, AutomationConstants.ExpectedError);
//		
////		String expectedtitle="User not found";
////		String Displayhome=driver.getCurrentUrl();
////		Assert.assertEquals(Displayhome,expectedtitle);
	}
//	
	@Test(priority=1)
	public void Invalidpasswordloginpage() throws InterruptedException{
		log=new LoginPage(driver);
		String emailid=ExcelUtility.getCellData(2, 0);
		String password=ExcelUtility.getCellData(2, 1);
		
		log.setemailid(emailid);
		log.setpassword(password);
		log.LoginClick();
		Thread.sleep(2000);
		}
//		
//
////		String actualResult=obj.getError();
////		System.out.println(actualResult);
////		Assert.assertEquals(actualResult, AutomationConstants.ExpectedError);
//	
	@Test(priority=3)
	public void blankloginpage() throws InterruptedException{
		log=new LoginPage(driver);
		
		String emailid=ExcelUtility.getCellData(4, 0);
		String password=ExcelUtility.getCellData(4, 1);
		
		log.setemailid(emailid);
		log.setpassword(password);
		log.LoginClick();
		Thread.sleep(2000);
		}
//	
//	//	String actualResult=obj.getError();
//	//	System.out.println(actualResult);
//	//	Assert.assertEquals(actualResult, AutomationConstants.ExpectedError);
//	
	@Test(priority=5)
	public void Validadminloginpage() throws InterruptedException{
		log=new LoginPage(driver);
		String emailid=ExcelUtility.getCellData(5, 0);
		String password=ExcelUtility.getCellData(5, 1);
		
		log.setemailid(emailid);
		log.setpassword(password);
		log.LoginClick();
		Thread.sleep(2000);
		}
//	
//	
////	String expectedTitle = "http://64.227.132.106/admin";
////	String currentUrl = driver.getCurrentUrl();
////	System.out.println("Expected URL: " + expectedTitle);
////	System.out.println("Current URL: " + currentUrl);
////	Assert.assertEquals(currentUrl, expectedTitle);
//	
//	

	@Test(priority=4)
	public void Validtrainerloginpage(){
		log=new LoginPage(driver);
		String emailid=ExcelUtility.getCellData(6, 0);
		String password=ExcelUtility.getCellData(6, 1);
		
		log.setemailid(emailid);
		log.setpassword(password);
		log.LoginClick();
		
		}



}
