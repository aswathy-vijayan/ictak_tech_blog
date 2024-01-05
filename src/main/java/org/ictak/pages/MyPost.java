package org.ictak.pages;

import org.ictak.utilities.Commons;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyPost {
WebDriver driver;
	
	By mypost=By.xpath("//a[text()='My posts']");
	By mypostedit=By.xpath("//button[text()='Edit']");
	By mypostdelete=By.xpath("//button[text()='Delete']");
	
	public MyPost(WebDriver driver) {
		this.driver=driver;
	}
	public void editMyPost() throws InterruptedException
	{	Thread.sleep(1000);
		driver.findElement(mypost).click();	
		Thread.sleep(2000);
		WebElement editBtn = driver.findElement(mypostedit);
		Commons.scrollUntilVisible(driver, editBtn);
		Thread.sleep(2000);
		editBtn.click();
		}
	public void deleteMyPost() throws InterruptedException
	{
		driver.findElement(mypost).click();
		Thread.sleep(2000);
		driver.findElement(mypostdelete).click();
		Thread.sleep(2000);
		Alert oalert = driver.switchTo().alert();
		oalert.accept();
	}
	
	
}
