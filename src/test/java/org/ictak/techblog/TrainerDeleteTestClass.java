package org.ictak.techblog;

import java.time.Duration;

import org.ictak.constants.AutomationConstants;
import org.ictak.pages.TrainerDeletePost;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TrainerDeleteTestClass extends TrainerTestBase {
	TrainerDeletePost obj = null;

	@Test
	public void deletePost() throws InterruptedException {
		obj = new TrainerDeletePost(driver);
		obj.deletePost();
		String actualAlertText = obj.getAlertText();
		obj.alertClickAccept();
		Assert.assertEquals(actualAlertText, AutomationConstants.userPostDeleteMessage);
	}

	@BeforeTest
	public void secondBeforeTestCase() {
		// Go to My posts page
		driver.findElement(By.xpath("//a[@id='nav' and text()='My posts']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
