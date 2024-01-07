package org.ictak.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Action_s {
	WebDriver driver;
	By actionsdropdown=By.xpath("//p[@class='dropdown-toggle']");
	By pendingapproval=By.xpath("//a[@id='drop']");
	By approve=By.xpath("(//button[text()='Approve'])[1]");
	By reject=By.xpath("//button[text()='Reject']");
	
	
	
	public Action_s(WebDriver driver) {
		this.driver=driver;
	}

public void pendingApproval() throws InterruptedException
{
	driver.findElement(actionsdropdown).click();
	Thread.sleep(1000);
	driver.findElement(pendingapproval).click();
	Thread.sleep(1000);
	driver.findElement(approve).click();
	Thread.sleep(1000);
	Alert oalert = driver.switchTo().alert();
	oalert.accept();
}
	
	public void rejectApproval() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(actionsdropdown).click();
	    Thread.sleep(1000);
	    driver.findElement(pendingapproval).click();
	    Thread.sleep(1000);
		driver.findElement(reject).click();
		Thread.sleep(1000);
		Alert oalert = driver.switchTo().alert();
		oalert.accept();
	}
	
	
	

}
