package org.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainerEditPost {
	WebDriver driver;

	public TrainerEditPost(WebDriver d) {
		this.driver = d;
	}

	public void gotoEditPost() throws InterruptedException {
		// Go to my posts page
		driver.findElement(By.xpath("//a[@id='nav' and text()='My posts']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Click edit button of last post
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement EditBtn = driver.findElement(By.xpath("(//button[text()='Edit'])[last()]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", EditBtn);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void changeTitle(String title) {
		WebElement titleElement = driver.findElement(By.xpath("//input[@name=\"P_title\"]"));
		titleElement.clear();
		titleElement.sendKeys(title);
		titleElement.sendKeys(Keys.SPACE, Keys.BACK_SPACE);

	}

	public void changeAuthor(String authorName) {
		WebElement authorField = driver.findElement(By.xpath("//input[@name=\"P_author\"]"));
		authorField.clear();
		authorField.sendKeys(authorName);
		authorField.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
	}

	public void changeImage(String imageUrl) {
		WebElement imageField = driver.findElement(By.xpath("//input[@name=\"P_image\"]"));
		imageField.clear();
		imageField.sendKeys(imageUrl);
		imageField.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
	}

	public void changePostContent(String content) {
		WebElement postContentElement = driver.findElement(By.xpath("//textarea[@name=\"p_post\"]"));
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
		try {
			Thread.sleep(3000);
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
