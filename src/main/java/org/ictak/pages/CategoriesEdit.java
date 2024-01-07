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

public class CategoriesEdit {
	WebDriver driver;
	By title= By.name("P_title");
	By author=By.name("P_author");
	By imageurl=By.name("P_image");
	By post=By.name("p_post");
	By submtbtn=By.className("btn-primary");
	
	public CategoriesEdit(WebDriver driver) {
		this.driver=driver;
	}
//	public void editCategories() throws InterruptedException
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		//WebElement elmnt= wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("*[name='P_title']")));
//		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		try {
//		    WebElement elmnt = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("*[name='P_title']")));
//		    elmnt.clear();
//		    // Perform actions on the element
//		} catch (TimeoutException e) {
//		    // Handle timeout exception or log the error
//		    e.printStackTrace();
//		}

		// Perform actions on the element
		
	public void editCategories() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
try
{
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(title));
	    // Now you can interact with the 'element'
	    Commons.scrollUntilVisible(driver, element);
		Thread.sleep(1000);
		element.clear();
		element.sendKeys("Technology");
		
	    
	} catch (TimeoutException e) {
	    // Handle the timeout exception if the element is not clickable within the specified time
	    e.printStackTrace();
	}
		Thread.sleep(1000);
		try
		{
			    WebElement oauthor = wait.until(ExpectedConditions.elementToBeClickable(author));
			    // Now you can interact with the 'element'
			    Thread.sleep(3000);
			    Commons.scrollUntilVisible(driver, oauthor);
				Thread.sleep(1000);
				oauthor.clear();
				oauthor.sendKeys("Saranya");
				
			    
			} catch (TimeoutException e) {
			    // Handle the timeout exception if the element is not clickable within the specified time
			    e.printStackTrace();
			}
		
//		driver.findElement(author).clear();
//		driver.findElement(author).sendKeys("saranya");
		Thread.sleep(1000);
		driver.findElement(imageurl).clear();
		driver.findElement(imageurl).sendKeys("https://images.unsplash.com/photo-1488590528505-98d2b5aba04b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8dGVjaG5vbG9neXxlbnwwfHwwfHx8MA%3D%3D");
		driver.findElement(post).clear();
		driver.findElement(post).sendKeys("Technology is the application of conceptual knowledge for achieving practical goals, especially in a reproducible way. ");
		Thread.sleep(1000);
		WebElement editBtn = driver.findElement(submtbtn);
		Commons.scrollUntilVisible(driver, editBtn);
		Thread.sleep(1000);
		editBtn.click();
		Thread.sleep(1000);
		Alert oalert=driver.switchTo().alert();
		oalert.accept();
		
	}
	
}
