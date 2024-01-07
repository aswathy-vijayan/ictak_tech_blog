package org.ictak.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOrRemove {
	WebDriver driver;
	By actionsdropdown=By.xpath("//p[@class='dropdown-toggle']");
	By addorremove=By.xpath("//a[text()='Add/Remove category']");
	By addnewcategory=By.xpath("//input[@name='category']");
	By addbtn=By.xpath("//button[text()='Add']");
	By removebtn=By.xpath("//button[text()='Remove']");
	
	public AddOrRemove(WebDriver driver) {
       this.driver=driver;
	}
	public void addCategory() throws InterruptedException
	{	driver.findElement(actionsdropdown).click();
		Thread.sleep(1000);
		driver.findElement(addorremove).click();
		Thread.sleep(1000);
		driver.findElement(addnewcategory).sendKeys("AGILE");
		Thread.sleep(3000);
		driver.findElement(addbtn).click();
		Thread.sleep(1000);
		Alert oalert=driver.switchTo().alert();
		oalert.accept();
	}
	public void removeCategory() throws InterruptedException
	{	driver.findElement(actionsdropdown).click();
		Thread.sleep(1000);	
		driver.findElement(addorremove).click();
		Thread.sleep(1000);
		driver.findElement(removebtn).click();
		Thread.sleep(1000);
		Alert oalert=driver.switchTo().alert();
		oalert.accept();
	}
	}





