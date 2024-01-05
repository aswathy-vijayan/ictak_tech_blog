package org.ictak.pages;

import org.ictak.utilities.Commons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Categories {
	WebDriver driver;
	By categoriesbtn=By.xpath("//p[text()='Categories']");
	By categoriesdropdown=By.xpath("(//a[@class='dropdown-item'])");
	By categoriesedit=By.xpath("//button[text()='Edit']");
	By categoriesdelete=By.xpath("//button[text()='Delete']");

public Categories(WebDriver driver) {
	this.driver=driver;
}

public void CategoriesEdit() throws InterruptedException
{
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Thread.sleep(5000);
	driver.findElement(categoriesbtn).click();
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.findElement(categoriesdropdown).click();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	WebElement editBtn = driver.findElement(categoriesedit);
	Commons.scrollUntilVisible(driver, editBtn);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	editBtn.click();
	
	
}
public void CategoriesDelete() throws InterruptedException
{Thread.sleep(1000);
	driver.findElement(categoriesbtn).click();
	Thread.sleep(1000);
	driver.findElement(categoriesdropdown).click();
	WebElement editBtn = driver.findElement(categoriesdelete);
	Commons.scrollUntilVisible(driver, editBtn);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	editBtn.click();

	
	
}
}
