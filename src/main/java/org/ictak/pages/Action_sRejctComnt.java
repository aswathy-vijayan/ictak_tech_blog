package org.ictak.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Action_sRejctComnt {
	WebDriver driver;
	By rejectcmnt=By.xpath("//textarea[@name='p_post']");
	By sbmtbutn=By.xpath("//button[@type='submit']");
	
	public Action_sRejctComnt(WebDriver driver) {
		this.driver=driver;
	}
	public void rejectComntToUser() throws InterruptedException {
		driver.findElement(rejectcmnt).sendKeys("Please post updated contents");	
		Thread.sleep(1000);
		driver.findElement(sbmtbutn).click();
		Thread.sleep(1000);
		Alert oalert = driver.switchTo().alert();
		oalert.accept();
	}

}
