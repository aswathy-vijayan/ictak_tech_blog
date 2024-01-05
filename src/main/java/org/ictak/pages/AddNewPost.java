package org.ictak.pages;

import org.ictak.utilities.Commons;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddNewPost {
	WebDriver driver;
	By actionsdropdown=By.xpath("//p[@class='dropdown-toggle']");
	By newpost=By.xpath("//a[text()='New post']");
	By title=By.xpath("//input[@id='exampleInputEmail1']");
	By author=By.xpath("//input[@name='P_author']");
	By image=By.xpath("//input[@name='P_image']");
	By category=By.xpath("//select[@name='p_cat']");
	By post=By.xpath("//textarea[@name='p_post']");
	By submit=By.xpath("//button[@type='submit']");
	

public AddNewPost(WebDriver driver) {
	this.driver=driver;
}
public void addingnewpost() throws Exception
{
	Thread.sleep(1000);
	driver.findElement(actionsdropdown).click();
	Thread.sleep(1000);
	driver.findElement(newpost).click();
	Thread.sleep(1000);
	driver.findElement(title).sendKeys("Selenium");
	driver.findElement(author).sendKeys("Ashok");
	driver.findElement(image).sendKeys("https://www.gstatic.com/webp/gallery3/1.sm.png");
	WebElement categorydropdown=driver.findElement(category);
	Select ocategorydropdown=new Select(categorydropdown);
	ocategorydropdown.selectByIndex(1);
	driver.findElement(post).sendKeys("Selenium is an open source umbrella project for a range of tools and libraries aimed at supporting browser automation.");
	Thread.sleep(1000);
	WebElement editBtn = driver.findElement(submit);
	Commons.scrollUntilVisible(driver, editBtn);
	Thread.sleep(1000);
	editBtn.click();
	Thread.sleep(3000);
	driver.findElement(submit).click();
	Thread.sleep(3000);
	Alert oalert=driver.switchTo().alert();
	Thread.sleep(1000);
	oalert.accept();
}
	


}
