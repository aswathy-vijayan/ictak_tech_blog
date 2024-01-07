package org.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Aboutus {
	WebDriver driver;

	By aboutus=By.xpath("//a[text()='About us']");
	

	
	public Aboutus(WebDriver driver) {
		this.driver=driver;
	
	}
	public void aboutus() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(aboutus));
		    // Now you can interact with the 'element'
		    Thread.sleep(1000);
		    element.click();
		} catch (TimeoutException e) {
		    // Handle the timeout exception if the element is not clickable within the specified time
		    e.printStackTrace();
		}
		//driver.findElement(aboutus).click();
}


}