package org.ictak.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage 
{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void assertHome(String s1,String s2,String s3,String s4)
	{
	
		System.out.println("Home page is present");
		Assert.assertEquals(s1,driver.findElement(By.xpath("//body/app-root/app-home[@class='ng-star-inserted']/app-header/nav[@class='navbar navbar-expand-lg navbar-dark']/div[@class='container-fluid']/div[@id='navbarSupportedContent']/ul[@class='navbar-nav me-auto mb-2 mb-lg-0']/li[1]/a[1]")).getText());
		
		Assert.assertEquals(s2,driver.findElement(By.xpath("//marquee[@class='pt-3 mx-3']\r\n")).getText());
		System.out.println("Tech news is present");
		
		Assert.assertEquals(s3,driver.findElement(By.xpath("//h2[normalize-space()='Latest Articles']")).getText());
		System.out.println("Latest article is present");
		
		Assert.assertEquals(s4,driver.findElement(By.xpath("//h2[normalize-space()='Share Feedback']")).getText());
		System.out.println("feedbaack form is present");
	}
	
	public void category() throws InterruptedException
	{
		 WebElement drdown = driver.findElement(By.xpath("//p[@id='nav']"));
		 drdown.click();
		 WebElement upost = driver.findElement(By.xpath("//a[@id='drop']\r\n"));
		 upost.click();
//		 Select select = new Select(drdown);
//		 select.selectByVisibleText("USER");
//		 Thread.sleep(2000);
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void aboutUs(String abt)
	{
		 WebElement about = driver.findElement(By.xpath("//body/app-root/app-home[@class='ng-star-inserted']/app-header/nav[@class='navbar navbar-expand-lg navbar-dark']/div[@class='container-fluid']/div[@id='navbarSupportedContent']/ul[@class='navbar-nav me-auto mb-2 mb-lg-0']/li[8]/a[1]"));
		 about.click();	
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		 Thread.sleep(2000);
		 Assert.assertEquals(abt,driver.findElement(By.xpath("//body//app-root//h2[1]")).getText());
//		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement about = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/app-root/app-home/app-header/nav/div/div/ul/li[8]/a[1]")));
//		about.click();

	}
	
	public void contactUs(String cont,String nam,String mail,String msg)
	{
		 	WebElement contact = driver.findElement(By.xpath("//body/app-root/app-home[@class='ng-star-inserted']/app-header/nav[@class='navbar navbar-expand-lg navbar-dark']/div[@class='container-fluid']/div[@id='navbarSupportedContent']/ul[@class='navbar-nav me-auto mb-2 mb-lg-0']/li[9]/a[1]"));
		 	contact.click();
		 	
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
			Assert.assertEquals(cont,driver.findElement(By.xpath("//h1[normalize-space()='Contact us']")).getText());
			WebElement uname= driver.findElement(By.xpath("//input[@id='name']"));
			uname.sendKeys(nam);
			WebElement umail= driver.findElement(By.xpath("//input[@id='email']"));
			umail.sendKeys(mail);
			WebElement umsg= driver.findElement(By.xpath("//textarea[@placeholder='MESSAGE']"));
			umsg.sendKeys(msg);
			
			WebElement element = driver.findElement(By.xpath("//span[@class='send-text']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//==========================================================================================			
			
//			WebElement element = driver.findElement(By.xpath("//span[@class='send-text']"));
//			Actions actions = new Actions(driver);
//			actions.moveToElement(element).click().perform();
//================================================================================================
			
//			WebElement cbut=driver.findElement(By.xpath("//span[@class='send-text']\r\n"));
//			cbut.click();
						
//==========================================================================================
//			 //Switch to iframeResult iframe because all elements located in this iframe
//		    driver.switchTo().frame("iframeResult");
//		    
//		    //Alert Message (Expected Text)
//		    String expectedAlertMessage = "Message is send successfully";
//		    //Captured Alert Text (Actual Text)
//		    String actualAlertMessage = driver.switchTo().alert().getText();
//		    //Assertion
//		    Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
//		    //Accept the alert (Click OK)
//		    driver.switchTo().alert().accept();
			
//========================================================================================
	}
	
	public void profileOne(String in) throws InterruptedException
	{
		 WebElement drpdown = driver.findElement(By.xpath("//a[@id='navbarDropdown']//img"));
		 drpdown.click();
//		 Select select = new Select(drpdown);
//		 select.selectByVisibleText("Login");
		 WebElement Lbut = driver.findElement(By.xpath("//ul[@class='dropdown-menu show']//li[1]//a[1]"));
			Lbut.click();
		 Thread.sleep(2000);		 
		 Assert.assertEquals(in,driver.findElement(By.xpath("//h3[normalize-space()='Login']")).getText());
	}
	
	public void profileTwo(String up) throws InterruptedException
	{
		 WebElement dropdown = driver.findElement(By.xpath("//a[@id='navbarDropdown']//img"));
		 dropdown.click();
//		 Select select = new Select(dropdown);
//		 select.selectByVisibleText("Signup");
		 WebElement Sbut = driver.findElement(By.xpath("//ul[@class='dropdown-menu show']//li[2]//a[1]"));
			Sbut.click();
		 Thread.sleep(2000);		
		 Assert.assertEquals(up,driver.findElement(By.xpath("//h3[normalize-space()='Signup form']")).getText());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void setUsername(String usern)
//	{
//		WebElement uBox= driver.findElement(By.xpath("//input[@name='user-name']"));
//		uBox.sendKeys(usern);
//	}
//	
//	public void setPass(String passw)
//	{
//		WebElement pBox=driver.findElement(By.xpath("//input[@name='password' and @placeholder='Password']"));
//		pBox.sendKeys(passw);
//	}
//	
//	public void clickLogin()
//	{
//		

//	}
}
