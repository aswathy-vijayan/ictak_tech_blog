package org.ictak.techblog;

import java.io.IOException;
import java.time.Duration;

import org.ictak.constants.AutomationConstants;
import org.ictak.pages.SignUpPage;
import org.ictak.utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrainerSignUpTestClass extends SignUpTestBase {
	
	
SignUpPage trainerSign;
	
	
	@Test(priority=1)
	public void verifyvalidTrainerName() throws IOException, InterruptedException 
	{
		trainerSign= new SignUpPage(driver);
		
//		trainerSign.ClickDropDown();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
//		trainerSign.ClickSign();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		trainerSign.SelectTrainer();
		
		trainerSign.SelectEdu();
		
		trainerSign.SelectPG();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
	
		String enterName= ExcelUtility.getCellData(15, 0);
		String yourEmail=ExcelUtility.getCellData(15, 1);
		String yourPassword=ExcelUtility.getCellData(15, 2);
		trainerSign.EnterName(enterName);
		trainerSign.setYourEmail(yourEmail);
		trainerSign.setYourPassword(yourPassword);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
//		trainerSign.allSubmitSign();
		trainerSign.activeESubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		
}
	
	
	
	
	@Test(priority=2)
	public void verifyInvalidTrainerName() throws IOException, InterruptedException 
	{
		trainerSign= new SignUpPage(driver);
		
//		trainerSign.ClickDropDown();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
//		trainerSign.ClickSign();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		trainerSign.SelectTrainer();
		
		trainerSign.SelectEdu();
		
		trainerSign.SelectPG();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	
		String enterName= ExcelUtility.getCellData(9, 0);
		String yourEmail=ExcelUtility.getCellData(9, 1);
		String yourPassword=ExcelUtility.getCellData(9, 2);
		trainerSign.EnterName(enterName);
		trainerSign.setYourEmail(yourEmail);
		trainerSign.setYourPassword(yourPassword);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
//		trainerSign.cSubmitUser();
		trainerSign.activeESubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		
}
	
	@Test(priority=3)
	public void verifyInvalidTrainerPassword() throws IOException, InterruptedException 
	{
		trainerSign= new SignUpPage(driver);
		
//		trainerSign.ClickDropDown();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
//		trainerSign.ClickSign();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		trainerSign.SelectTrainer();
		
		trainerSign.SelectEdu();
		
		trainerSign.SelectPG();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	
		String enterName= ExcelUtility.getCellData(10, 0);
		String yourEmail=ExcelUtility.getCellData(10, 1);
		String yourPassword=ExcelUtility.getCellData(10, 2);
		trainerSign.EnterName(enterName);
		trainerSign.setYourEmail(yourEmail);
		trainerSign.setYourPassword(yourPassword);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		//trainerSign.cSubmitUser();
//		trainerSign.cSubmitUser();
		trainerSign.activeESubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
//		String actualResults=trainerSign.getErrorUp1();
//	    System.out.println(actualResults);
//		Assert.assertEquals(actualResults,AutomationConstants.ExpectedErrorPU);
		
		
		
	}
	@Test(priority=4)
	public void verifyInvalidTrainerSelection() throws IOException, InterruptedException 
	{
		trainerSign= new SignUpPage(driver);
		
//		trainerSign.ClickDropDown();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
//		trainerSign.ClickSign();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		//trainerSign.SelectTrainer();
		
		//trainerSign.SelectEdu();
		
		//trainerSign.SelectPG();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	
		String enterName= ExcelUtility.getCellData(15, 0);
		String yourEmail=ExcelUtility.getCellData(15, 1);
		String yourPassword=ExcelUtility.getCellData(15, 2);
		trainerSign.EnterName(enterName);
		trainerSign.setYourEmail(yourEmail);
		trainerSign.setYourPassword(yourPassword);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
//		trainerSign.cSubmitUser();
		trainerSign.cSubmitUser();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		

}

}

