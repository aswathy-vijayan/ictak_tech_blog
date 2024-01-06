package org.ictak.techblog;

import java.time.Duration;

import org.ictak.constants.AutomationConstants;
import org.ictak.pages.UserDeletePost;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserDeleteTestClass extends UserTestBase {
	UserDeletePost obj = null;

	@Test
	public void deletePost() throws InterruptedException {
		obj = new UserDeletePost(driver);
		obj.deletePost();
		String actualAlertText = obj.getAlertText();
		obj.alertClickAccept();
		Assert.assertEquals(actualAlertText, AutomationConstants.userPostDeleteMessage);
	}

	@BeforeTest
	public void secondBeforeTestCase() {
		// Go to new posts page
		driver.findElement(By.xpath("//a[@id='nav' and text()='My posts']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

}
