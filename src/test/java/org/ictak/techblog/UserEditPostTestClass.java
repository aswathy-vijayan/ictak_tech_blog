package org.ictak.techblog;

import java.time.Duration;

import org.ictak.constants.AutomationConstants;
import org.ictak.pages.UserEditPost;
import org.ictak.utilities.CaptureScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserEditPostTestClass extends UserTestBase {
	UserEditPost obj = null;

	@Test(priority = 1)
	public void editPostWithBlankTitle() throws InterruptedException {
		obj = new UserEditPost(driver);
		obj.changeTitle("");
		obj.clickSubmit();
		Assert.assertEquals(obj.getAlertText(), "");
	}

	@Test(priority = 2)
	public void editPostWithBlankAuthor() throws InterruptedException {
		obj = new UserEditPost(driver);
		obj.changeAuthor("");
		obj.clickSubmit();
		Assert.assertEquals(obj.getAlertText(), "");

	}

	@Test(priority = 3)
	public void editPostWithBlankImage() throws InterruptedException {
		obj = new UserEditPost(driver);
		obj.changeImage("");
		obj.clickSubmit();
		String alertText = obj.getAlertText();
		if (alertText.length() > 0) {
			obj.alertClickAccept();
			obj.gotoEditPost();
		}
		Assert.assertEquals(alertText, "");
	}

	@Test(priority = 4)
	public void editPostWithInvalidImage() throws InterruptedException {
		obj = new UserEditPost(driver);
		ss = new CaptureScreenshot(driver);
		obj.changeImage(AutomationConstants.invalidImageUrlNew);
		obj.clickSubmit();
		String alertText = obj.getAlertText();
		if (alertText.length() > 0) {
			obj.alertClickAccept();
			// Warning: Cannot take screenshot with alert open
			ss.captureScreenshot("user-editPostWithInvalidImage");
			obj.gotoEditPost();
		}
		Assert.assertEquals(alertText, "");
	}

	@Test(priority = 5)
	public void editPostWithBlankPostContent() throws InterruptedException {
		obj = new UserEditPost(driver);
		obj.changePostContent("");
		obj.clickSubmit();
		Assert.assertEquals(obj.getAlertText(), "");
	}

	@Test(priority = 6)
	public void editPostWithValidValues() throws InterruptedException {
		obj = new UserEditPost(driver);
		obj.changeTitle(AutomationConstants.postTitleNew);
		obj.changeImage(AutomationConstants.imageUrlNew);
		obj.changePostContent(AutomationConstants.postContentNew);
		obj.clickSubmit();
		Thread.sleep(1000);
		String expectedAlertMessage = AutomationConstants.postUpdateSuccessMessage;
		String actualAlertMessage = obj.getAlertText();
		obj.alertClickAccept();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

	@BeforeTest
	public void secondBeforeTestCase() {
		// Go to new posts page
		driver.findElement(By.xpath("//a[@id='nav' and text()='My posts']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Click edit button of last post
		WebElement editButton = driver.findElement(By.xpath("(//button[text()='Edit'])[last()]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", editButton);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
