package org.ictak.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Action_sApprvlComnt {
	WebDriver driver;
	By apprvlcomment=By.xpath("//textarea[@name='p_post']");
	By sbmtbutn=By.xpath("//button[@type='submit']");
	
	public Action_sApprvlComnt(WebDriver driver) {
		this.driver=driver;
	}
	public void adminComntToUser() throws InterruptedException {
		driver.findElement(apprvlcomment).sendKeys("Nice content");	
		Thread.sleep(2000);
		driver.findElement(sbmtbutn).click();
		Thread.sleep(2000);
		Alert oalert = driver.switchTo().alert();
		oalert.accept();
	}

}
