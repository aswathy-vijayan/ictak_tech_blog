package org.ictak.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLogin {
WebDriver driver;
	
	public AdminLogin(WebDriver driver) {
		this.driver=driver;
	}
	
	public void AdminLoginDrop()
	{
		driver.findElement(By.xpath("(//a[@id='navbarDropdown'])[2]")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();		
	}
	public void AdminUsername(String username)
	{
		driver.findElement(By.id("user")).sendKeys(username);
		
	}
	public void AdminPassword(String password)
	{
		driver.findElement(By.id("pwd")).sendKeys(password);
	}
}

