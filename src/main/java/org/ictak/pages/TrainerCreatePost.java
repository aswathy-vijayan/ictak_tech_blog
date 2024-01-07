/**
 * 
 */
package org.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 */
public class TrainerCreatePost {
	WebDriver driver;

	public TrainerCreatePost(WebDriver d) {
		this.driver = d;
	}

	public void gotoCreatePost() {
		// Go to new post page
		driver.findElement(By.xpath("//a[@id='nav' and text()='New post']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void setTitle(String title) {
		WebElement titleField = driver.findElement(By.name("P_title"));
		titleField.sendKeys(title);
		titleField.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
	}

	public void setAuthor(String authorName) {
		WebElement authorField = driver.findElement(By.name("P_author"));
		if (authorName.equals("")) {
			authorField.clear();
			authorField.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
		} else
			authorField.sendKeys(authorName);
	}

	public void setImage(String imageUrl) {
		WebElement imageField = driver.findElement(By.name("P_image"));
		imageField.sendKeys(imageUrl);
		imageField.sendKeys(Keys.SPACE, Keys.BACK_SPACE);

	}

	public void setCategory(String categoryName) {
		Select categoryDropdown = new Select(driver.findElement(By.name("p_cat")));
		categoryDropdown.selectByVisibleText(categoryName);
	}

	public void setPostContent(String content) {
		WebElement contentField = driver.findElement(By.name("p_post"));
		contentField.sendKeys(content);
		contentField.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
	}

	public void clickSubmit() throws InterruptedException {
		Thread.sleep(2000);
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
