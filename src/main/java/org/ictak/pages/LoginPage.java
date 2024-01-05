package org.ictak.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
	this.driver=driver;
	}
	
	public void setemailid(String setemail)
    {
		WebElement emailid=driver.findElement(By.id("user"));
   	emailid.sendKeys(setemail);
    }
    
    public void setpassword(String setpass)
    {
    	WebElement password=driver.findElement(By.id("pwd"));
   	 password.sendKeys(setpass);
   	 
    }
    public void LoginClick()
    {
    	WebElement Login=driver.findElement(By.id("logbut"));
   	 Login.click();
    }
    
    public String ConfirmLog() {
		return driver.findElement(By.xpath("//h2")).getText();
	}
    
    public String getError() { 
		return(driver.switchTo().alert().getText());}
	
}
