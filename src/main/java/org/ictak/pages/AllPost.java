package org.ictak.pages;

import org.ictak.utilities.Commons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllPost {
WebDriver driver;

	
	
	
	
	By allpages=By.xpath("(//a[@id='nav'])[2]");
	By alledit=By.xpath("//button[text()='Edit']");
	By allpostdelete=By.xpath("//button[text()='Delete']");
	
	public AllPost(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void clickEditButton() throws Exception {
		Thread.sleep(1000);
		driver.findElement(allpages).click();
		Thread.sleep(2000);
//		driver.findElement(alledit).sendKeys(Keys.PAGE_DOWN);
		WebElement editBtn = driver.findElement(alledit);
		Commons.scrollUntilVisible(driver, editBtn);
		Thread.sleep(1000);
		editBtn.click();
		}
	
	public void clickDeleteButton() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(allpages).click();
		Thread.sleep(2000);
        driver.findElement(allpostdelete).click();;
        
}

}
