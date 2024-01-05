package org.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Aboutus {
	WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	By aboutus=By.xpath("//a[text()='About us']");
	

	
	public Aboutus(WebDriver driver) {
		this.driver=driver;
	}
	public void aboutus() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(aboutus).click();
}


}