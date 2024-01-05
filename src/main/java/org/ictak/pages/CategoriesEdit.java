package org.ictak.pages;

import org.ictak.utilities.Commons;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriesEdit {
	WebDriver driver;
	By title= By.id("exampleInputEmail1");
	By author=By.name("P_author");
	By imageurl=By.name("P_image");
	By post=By.name("p_post");
	By submtbtn=By.className("btn-primary");
	
	public CategoriesEdit(WebDriver driver) {
		this.driver=driver;
	}
	public void editCategories() throws InterruptedException
	{Thread.sleep(5000);
	driver.findElement(title).clear();
		driver.findElement(title).sendKeys("Technology");
		Thread.sleep(1000);
		driver.findElement(author).clear();
		driver.findElement(author).sendKeys("saranya");
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
