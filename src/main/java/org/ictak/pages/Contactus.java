package org.ictak.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Contactus {
	WebDriver driver;
	By contactus=By.xpath("//a[text()='Contact us']");
	By name =By.id("name");
	By email=By.id("email");
	By message=By.name("message");
	By sendbtn=By.className("alt-send-button");
	public Contactus(WebDriver driver) {
		this.driver=driver;
	}
	public void contactus() throws InterruptedException{
		{Thread.sleep(1000);
			driver.findElement(contactus).click();
			Thread.sleep(1000);
			driver.findElement(name).sendKeys("Arya");
			Thread.sleep(1000);
			driver.findElement(email).sendKeys("arya05@gmail.com");
			Thread.sleep(1000);
			driver.findElement(message).sendKeys("HI...");
			Thread.sleep(1000);
			driver.findElement(sendbtn).click();
			Alert oalert=driver.switchTo().alert();
			oalert.accept();
		}
	}
}
	
	
	