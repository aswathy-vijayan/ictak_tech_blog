package org.ictak.techblog;

import java.io.IOException;
import java.time.Duration;

import org.ictak.pages.SignUpPage;
import org.ictak.utilities.ExcelUtility;
import org.testng.annotations.Test;

public class SignUpTestClass extends SignUpTestBase {
	SignUpPage userSign;
	
	@Test(priority=4)
		public void verifyvalidUserName() throws IOException, InterruptedException 
		{
			userSign= new SignUpPage(driver);
		//driver.navigate().refresh();
			
//		userSign.ClickDropDown();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
//		userSign.ClickSign();
		Thread.sleep(2000);
		String enterName= ExcelUtility.getCellData(8, 0);
		String yourEmail=ExcelUtility.getCellData(8, 1);
		String yourPassword=ExcelUtility.getCellData(8, 2);
		userSign.EnterName(enterName);
		userSign.DrpDwnUsr();
		userSign.SelectUser();
		
		userSign.setYourEmail(yourEmail);
		userSign.setYourPassword(yourPassword);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
//		userSign.allSubmitSign();
		userSign.cSubmitUser();
		Thread.sleep(2000);
		
		}	
		
		
	@Test(priority=2)
		public void verifyInvalidUserName() throws IOException, InterruptedException 
		{
			userSign= new SignUpPage(driver);
		//driver.navigate().refresh();
			
//		userSign.ClickDropDown();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
//		userSign.ClickSign();
		Thread.sleep(2000);
		String enterName= ExcelUtility.getCellData(9, 0);
		String yourEmail=ExcelUtility.getCellData(9, 1);
		String yourPassword=ExcelUtility.getCellData(9, 2);
		userSign.EnterName(enterName);
		userSign.DrpDwnUsr();
		userSign.SelectUser();
		
		userSign.setYourEmail(yourEmail);
		userSign.setYourPassword(yourPassword);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		userSign.cSubmitUser();
		Thread.sleep(2000);
		}


		@Test(priority=3)
		public void verifyInvalidUserPassword() throws IOException, InterruptedException 
		{
			userSign= new SignUpPage(driver);
			
//		userSign.ClickDropDown();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
//		userSign.ClickSign();
		Thread.sleep(2000);
		String enterName= ExcelUtility.getCellData(10, 0);
		String yourEmail=ExcelUtility.getCellData(10, 1);
		String yourPassword=ExcelUtility.getCellData(10, 2);
		userSign.EnterName(enterName);
		userSign.DrpDwnUsr();
		userSign.SelectUser();
		
		userSign.setYourEmail(yourEmail);
		userSign.setYourPassword(yourPassword);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		userSign.cSubmitUser();
		Thread.sleep(2000);
		}
		
		
		@Test(priority=1)
		public void verifyInvalidUserSelection() throws IOException, InterruptedException 
		{
			userSign= new SignUpPage(driver);
		//driver.navigate().refresh();
			
//		userSign.ClickDropDown();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
//		userSign.ClickSign();
		Thread.sleep(2000);
		String enterName= ExcelUtility.getCellData(8, 0);
		String yourEmail=ExcelUtility.getCellData(8, 1);
		String yourPassword=ExcelUtility.getCellData(8, 2);
		userSign.EnterName(enterName);
		//userSign.SelectUser();
		
		userSign.setYourEmail(yourEmail);
		userSign.setYourPassword(yourPassword);
		
		userSign.cSubmitUser();

		}
		

}

//TRAINER



