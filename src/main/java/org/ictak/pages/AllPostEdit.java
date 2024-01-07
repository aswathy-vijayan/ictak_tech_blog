package org.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllPostEdit {
	WebDriver driver;
	WebDriverWait wait;
	By title=By.id("exampleInputEmail1");
	By authorname=By.xpath("//input[@id='exampleInputPassword1'][1]");
	By imageurl=By.name("P_image");
	By postedited=By.name("p_post");
	By submitbtn=By.xpath("//button[@type='submit']");
	
public AllPostEdit(WebDriver driver) {
	this.driver=driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
}
public void AllPostEditing() throws Exception
{
	driver.findElement(title).clear();
	driver.findElement(title).sendKeys("abcd");
	Thread.sleep(1000);
	driver.findElement(authorname).clear();
	driver.findElement(authorname).sendKeys("anu");
	driver.findElement(imageurl).clear();
	driver.findElement(imageurl).sendKeys("qwert");
	Thread.sleep(1000);
	driver.findElement(postedited).clear();
	driver.findElement(postedited).sendKeys("trthggjg");
	Thread.sleep(2000);
	driver.findElement(submitbtn).click();
	Thread.sleep(2000);
	Alert oalert = driver.switchTo().alert();
	oalert.accept();
}

}
