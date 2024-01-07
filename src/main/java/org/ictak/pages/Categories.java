package org.ictak.pages;

import java.time.Duration;

import org.ictak.utilities.Commons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Categories {
	WebDriver driver;

	By categoriesbtn=By.xpath("//p[text()='Categories']");
	By categoriesdropdown=By.xpath("//a[@class='dropdown-item']");
	By categoriesedit=By.xpath("//button[text()='Edit']");
	By categoriesdelete=By.xpath("//button[text()='Delete']");

public Categories(WebDriver driver) {
	this.driver=driver;
}


public void CategoriesEdit() throws InterruptedException
{//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	Thread.sleep(2000);
//	driver.findElement(categoriesbtn).click();
//	Thread.sleep(1000);
//	
//	driver.findElement(categoriesdropdown).click();
//	//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	Thread.sleep(1000);
//	WebElement editBtn = driver.findElement(categoriesedit);
//	Commons.scrollUntilVisible(driver, editBtn);
//	editBtn.click();
//	
//	
//}
	
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(categoriesbtn)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(categoriesdropdown)).click();
	        WebElement editBtn = driver.findElement(categoriesedit);
	        Commons.scrollUntilVisible(driver, editBtn);
	        editBtn.click();

//	        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(categoriesedit));
//	        editBtn.click();
	    } catch (Exception e) {
	        e.printStackTrace(); // Handle or log the exception
	    }
	}

public void CategoriesDelete() throws InterruptedException
{
	
	Thread.sleep(2000);
	driver.findElement(categoriesbtn).click();
	Thread.sleep(1000);
	driver.findElement(categoriesdropdown).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(categoriesdelete));
	//deleteBtn.click();
//	WebElement editBtn = driver.findElement(categoriesdelete);
	Commons.scrollUntilVisible(driver, deleteBtn);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
	e.printStackTrace();
	}
	deleteBtn.click();

	
	
}
}
