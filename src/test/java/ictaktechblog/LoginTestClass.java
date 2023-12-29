package ictaktechblog;

import java.time.Duration;
import java.io.IOException;
import org.ictak.constants.AutomationConstants;
import org.ictak.pages.LoginPage;
import org.ictak.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestClass extends LoginTestBase {
	
	LoginPage log;
	
	@Test(priority=1)
	public void validLogin() throws IOException, InterruptedException {
		log=new LoginPage(driver);
		String emailid=ExcelUtility.getCellData(0, 0);
		String password=ExcelUtility.getCellData(0, 1);
		
		log.setemailid(emailid);
		log.setpassword(password);
		log.LoginClick();
		Thread.sleep(2000);
		
//		String expectedtitle=" http://64.227.132.106/mypost ";
//	    String Displayhome=driver.getCurrentUrl();
//	    Assert.assertEquals(Displayhome,expectedtitle);
	}
		
//		String actualResult=obj.ConfirmLog();
//		System.out.println(actualResult);
////		Assert.assertEquals(actualResult, AutomationConstants.ExpectedText);
////		driver.close();
//		
////		driver.quit();
////		String expectedtitle="My posts";
////		String Displayhome=driver.getCurrentUrl();
////		Assert.assertEquals(Displayhome,expectedtitle);
//	}
//	
	@Test(priority=5)
	public void Invalidemailloginpage(){
		log=new LoginPage(driver);
		String emailid=ExcelUtility.getCellData(1, 0);
		System.out.println(emailid);
		String password=ExcelUtility.getCellData(1, 1);
		log.setemailid(emailid);
		log.setpassword(password);
		log.LoginClick();
//		
////		String actualResult=obj.getError();
////		System.out.println(actualResult);
////		Assert.assertEquals(actualResult, AutomationConstants.ExpectedError);
//		
////		String expectedtitle="User not found";
////		String Displayhome=driver.getCurrentUrl();
////		Assert.assertEquals(Displayhome,expectedtitle);
	}
//	
	@Test(priority=3)
	public void Invalidpasswordloginpage(){
		log=new LoginPage(driver);
		String emailid=ExcelUtility.getCellData(2, 0);
		String password=ExcelUtility.getCellData(2, 1);
		
		log.setemailid(emailid);
		log.setpassword(password);
		log.LoginClick();
		}
//		
//
////		String actualResult=obj.getError();
////		System.out.println(actualResult);
////		Assert.assertEquals(actualResult, AutomationConstants.ExpectedError);
//	
	@Test(priority=4)
	public void blankloginpage(){
		log=new LoginPage(driver);
		
		String emailid=ExcelUtility.getCellData(4, 0);
		String password=ExcelUtility.getCellData(4, 1);
		
		log.setemailid(emailid);
		log.setpassword(password);
		log.LoginClick();
		}
//	
//	//	String actualResult=obj.getError();
//	//	System.out.println(actualResult);
//	//	Assert.assertEquals(actualResult, AutomationConstants.ExpectedError);
//	
	@Test(priority=2)
	public void Validadminloginpage(){
		log=new LoginPage(driver);
		String emailid=ExcelUtility.getCellData(5, 0);
		String password=ExcelUtility.getCellData(5, 1);
		
		log.setemailid(emailid);
		log.setpassword(password);
		log.LoginClick();
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

	@Test(priority=6)
	public void Validtrainerloginpage(){
		log=new LoginPage(driver);
		String emailid=ExcelUtility.getCellData(6, 0);
		String password=ExcelUtility.getCellData(6, 1);
		
		log.setemailid(emailid);
		log.setpassword(password);
		log.LoginClick();
		}



}
