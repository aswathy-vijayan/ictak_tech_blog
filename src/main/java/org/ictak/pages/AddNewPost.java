package org.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewPost {
	WebDriver driver;
	By actionsdropdown=By.id("navbarDropdown");
	By newpost=By.xpath("//a[text()='New post']");
	By title=By.xpath("//input[@id='exampleInputEmail1']");
	By author=By.xpath("//input[@name='P_author']");
	By image=By.xpath("//input[@name='P_image']");
	By category=By.xpath("//select[@name='p_cat']");
	By post=By.xpath("//textarea[@name='p_post']");
	By submit=By.xpath("//button[@type='submit']");
	

public AddNewPost(WebDriver driver) {
	this.driver=driver;
}
public void addingnewpost() throws Exception
{
//	Thread.sleep(1000);
//	driver.findElement(actionsdropdown).click();
//	Thread.sleep(1000);
//	driver.findElement(newpost).click();
//	Thread.sleep(1000);
//	driver.findElement(title).sendKeys("Selenium");
//	driver.findElement(author).sendKeys("Ashok");
//	driver.findElement(image).sendKeys("https://www.gstatic.com/webp/gallery3/1.sm.png");
//	WebElement categorydropdown=driver.findElement(category);
//	Select ocategorydropdown=new Select(categorydropdown);
//	ocategorydropdown.selectByIndex(1);
//	driver.findElement(post).sendKeys("Selenium is an open source umbrella project for a range of tools and libraries aimed at supporting browser automation.");
//	Thread.sleep(1000);
//	WebElement editBtn = driver.findElement(submit);
//	Commons.scrollUntilVisible(driver, editBtn);
//	Thread.sleep(1000);
//	editBtn.click();
//	Thread.sleep(3000);
////	Alert oalert=driver.switchTo().alert();
////	Thread.sleep(1000);
////	oalert.accept();
//	driver.findElement(submit).click();
//	Thread.sleep(3000);
//	Alert oalert1=driver.switchTo().alert();
//	Thread.sleep(1000);
//	oalert1.accept();
	//public void addingnewpost() throws InterruptedException {
	    // Click on the actions dropdown
	    driver.findElement(actionsdropdown).click();
	    Thread.sleep(1000);

	    // Click on "New post" from the dropdown
	    driver.findElement(newpost).click();
	    Thread.sleep(1000);

	    // Enter title, author, image, category, and post details
	    driver.findElement(title).sendKeys("Selenium");
	    driver.findElement(author).sendKeys("Ashok");
	    driver.findElement(image).sendKeys("https://www.gstatic.com/webp/gallery3/1.sm.png");
	    
	    // Select a category from the dropdown (assuming it's a <select> element)
	    Select categoryDropdown = new Select(driver.findElement(category));
	    categoryDropdown.selectByIndex(1);

	    driver.findElement(post).sendKeys("Selenium is an open source umbrella project for a range of tools and libraries aimed at supporting browser automation.");

	    // Click on the submit button to add the new post
	    driver.findElement(submit).click();
	    
	    // Handle any alerts if needed
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        alert.accept();
	    } catch (TimeoutException e) {
	        // No alert found, continue with your script
	    }
	    
	    // Optionally, add a wait or verification for post creation success
	    // e.g., you can wait for a success message to appear
	    // or check if the new post is listed in the posts section
	}
}
	



