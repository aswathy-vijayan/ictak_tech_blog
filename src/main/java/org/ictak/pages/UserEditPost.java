package org.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserEditPost {
	WebDriver driver;

	public UserEditPost(WebDriver d) {
		this.driver = d;
	}

	public void gotoEditPost() {
		// Go to my posts page
		driver.findElement(By.xpath("//a[@id='nav' and text()='My posts']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Click edit button of last post
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//button[text()='Edit'])[last()]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void changeTitle(String title) {
		WebElement titleElement = driver.findElement(By.name("P_title"));
		titleElement.clear();
		titleElement.sendKeys(title);
		titleElement.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
	}

	public void changeAuthor(String authorName) {
		WebElement authorField = driver.findElement(By.name("P_author"));
		authorField.clear();
		authorField.sendKeys(authorName);
		authorField.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
	}

	public void changeImage(String imageUrl) {
		WebElement imageField = driver.findElement(By.name("P_image"));
		imageField.clear();
		imageField.sendKeys(imageUrl);
		imageField.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
	}

	public void changePostContent(String content) {
		WebElement postContentElement = driver.findElement(By.name("p_post"));
		postContentElement.clear();
		postContentElement.sendKeys(content);
		postContentElement.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
	}

	public void clickSubmit() throws InterruptedException {
		Thread.sleep(1000);
		WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		if (submitBtn.isEnabled()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", submitBtn);
		}

	}

	public String getAlertText() throws InterruptedException {
		Thread.sleep(2000);
		try {
			return driver.switchTo().alert().getText();
		} catch (NoAlertPresentException e) {
			return "";
		}
	}

	public void alertClickAccept() {
		driver.switchTo().alert().accept();
	}

	public void logoutTrainer() {
		driver.findElement(By.xpath("//a[@id='nav' and text()='logout']")).click();
	}
}
