package org.ictak.pages;

import java.time.Duration;

import org.ictak.utilities.Commons;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyPostEdit {
	WebDriver driver;
	WebDriverWait wait;
	By title=By.id("exampleInputEmail1");
	By authorname=By.xpath("//input[@id='exampleInputPassword1'][1]");
	By imageurl=By.name("P_image");
	By postedited=By.name("p_post");
	By submitbtn=By.xpath("//button[@type='submit']");
	
public MyPostEdit(WebDriver driver) {
	this.driver=driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
}
public void MyPostEditing() throws Exception
{
	driver.findElement(title).clear();
	driver.findElement(title).sendKeys("software testing");
	Thread.sleep(1000);
	driver.findElement(authorname).clear();
	driver.findElement(authorname).sendKeys("saumya");
	driver.findElement(imageurl).clear();
	driver.findElement(imageurl).sendKeys("https://sfdergt hyt.hg");
	Thread.sleep(1000);
	driver.findElement(postedited).clear();
	driver.findElement(postedited).sendKeys("software testing is the process of assessing the functionality of a software program. The process checks for errors and gaps and whether the outcome of the application matches desired expectations before the software is installed and goes live.Software testing can also provide an objective, independent view of the software to allow the business to appreciate and understand the risks of software implementation.");
	Thread.sleep(3000);
	WebElement editBtn = driver.findElement(submitbtn);
	Commons.scrollUntilVisible(driver, editBtn);
	Thread.sleep(1000);
	editBtn.click();
	
	
	Thread.sleep(1000);
	Alert oalert = driver.switchTo().alert();
	oalert.accept();
}
}



