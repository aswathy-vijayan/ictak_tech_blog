package org.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLoginP {
	WebDriver driver;
	WebDriverWait wait;

	By dropdown = By.xpath("(//a[@id='navbarDropdown'])[2]");
	By loginLabel = By.xpath("//a[text()='Login']");
	By usernameIp = By.id("user");
	By passwordIp = By.id("pwd");
	By loginBtn = By.id("logbut");

	public AdminLoginP(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void loginToApplication(String username, String password) throws Exception {
		driver.findElement(dropdown).click();
		driver.findElement(loginLabel).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameIp)).sendKeys(username);
//		driver.findElement(usernameIp).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordIp)).sendKeys(password);
//		driver.findElement(passwordIp).sendKeys(password);
//		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
//		driver.findElement(loginBtn).click();
	}

}
