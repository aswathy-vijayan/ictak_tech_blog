package org.ictak.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserDeletePost {
	WebDriver driver;

	public UserDeletePost(WebDriver d) {
		this.driver = d;
	}

	public void deletePost() throws InterruptedException {
		WebElement deleteBtn = driver.findElement(By.xpath("(//button[text()='Delete'])[last()]"));
		Thread.sleep(4000);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", deleteBtn);

	}

	public String getAlertText() throws InterruptedException {
		Thread.sleep(3000);
		return driver.switchTo().alert().getText();
	}

	public void alertClickAccept() {
		driver.switchTo().alert().accept();
	}
}
