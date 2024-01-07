package org.ictak.pages;

import java.time.Duration;

import org.ictak.utilities.Commons;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyPost {
WebDriver driver;
	
	By mypost=By.xpath("//a[text()='My posts']");
	By mypostedit=By.xpath("//button[text()='Edit']");
	By mypostdelete=By.xpath("//button[text()='Delete']");
	
	public MyPost(WebDriver driver) {
		this.driver=driver;
	}
	public void editMyPost() throws InterruptedException
	{	Thread.sleep(8000);
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
	try {
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(mypost));
	    // Now you can interact with the 'element'
	    element.click();
	    Commons.scrollUntilVisible(driver, element);
		Thread.sleep(2000);
	    
	} catch (TimeoutException e) {
	    // Handle the timeout exception if the element is not clickable within the specified time
	    e.printStackTrace();
	}
		Thread.sleep(5000);
		WebElement editBtn = driver.findElement(mypostedit);
		Commons.scrollUntilVisible(driver, editBtn);
		Thread.sleep(2000);
		editBtn.click();
		}
	public void deleteMyPost() throws InterruptedException
	{	
		driver.findElement(mypost).click();

		//driver.findElement(mypost).click();
		Thread.sleep(5000);
		WebElement deltbtn=driver.findElement(mypostdelete);
		Commons.scrollUntilVisible(driver, deltbtn);
		driver.findElement(mypostdelete).click();
		Thread.sleep(2000);
		deltbtn.click();
		Alert oalert = driver.switchTo().alert();
		oalert.accept();
	}
	
	
}
