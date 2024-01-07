package org.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(sendbtn));
			element.click();
			
			//driver.findElement(sendbtn).click();
			Alert oalert=driver.switchTo().alert();
			oalert.accept();
		}
	}
}
	
	
	