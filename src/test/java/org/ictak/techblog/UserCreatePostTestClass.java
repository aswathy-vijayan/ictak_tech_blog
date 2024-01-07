package org.ictak.techblog;

import java.time.Duration;

import org.ictak.constants.AutomationConstants;
import org.ictak.pages.UserCreatePost;
import org.ictak.utilities.CaptureScreenshot;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserCreatePostTestClass extends UserTestBase {
	UserCreatePost obj = null;
	CaptureScreenshot ss = null;

	@Test(priority = 1)
	public void createPostWithBlankTitle() throws InterruptedException {
		obj = new UserCreatePost(driver);
		obj.setCategory(AutomationConstants.category);
		obj.setImage(AutomationConstants.imageUrl);
		obj.setPostContent(AutomationConstants.postContent);
		obj.clickSubmit();
		Assert.assertEquals(obj.getAlertText(), "");
	}

	@Test(priority = 2)
	public void createPostWithBlankAuthor() throws InterruptedException {
		obj = new UserCreatePost(driver);
		obj.setTitle(AutomationConstants.postTitle);
		obj.setAuthor("");
		obj.setCategory(AutomationConstants.category);
		obj.setImage(AutomationConstants.imageUrl);
		obj.setPostContent(AutomationConstants.postContent);
		obj.clickSubmit();
		Assert.assertEquals(obj.getAlertText(), "");

	}

	@Test(priority = 3)
	public void createPostWithBlankImage() throws InterruptedException {
		obj = new UserCreatePost(driver);
		obj.setTitle(AutomationConstants.postTitle);
		obj.setCategory(AutomationConstants.category);
		obj.setPostContent(AutomationConstants.postContent);
		obj.clickSubmit();
		String alertText = obj.getAlertText();
		if (alertText.length() > 0) {
			obj.alertClickAccept();
			obj.gotoCreatePost();
		}
		Assert.assertEquals(alertText, "");
	}

	@Test(priority = 4)
	public void createPostWithInvalidImage() throws InterruptedException {
		obj = new UserCreatePost(driver);
		ss = new CaptureScreenshot(driver);
		obj.setTitle(AutomationConstants.postTitle);
		obj.setCategory(AutomationConstants.category);
		obj.setImage(AutomationConstants.invalidImageUrl);
		obj.setPostContent(AutomationConstants.postContent);
		obj.clickSubmit();
		String alertText = obj.getAlertText();
		if (alertText.length() > 0) {
			obj.alertClickAccept();
			// Warning: Cannot take screenshot with alert open
			ss.captureScreenshot("user-createPostWithInvalidImage");
			obj.gotoCreatePost();
		}
		Assert.assertEquals(alertText, "");
	}

	@Test(priority = 5)
	public void createPostWithBlankCategory() throws InterruptedException {
		obj = new UserCreatePost(driver);
		obj.setTitle(AutomationConstants.postTitle);
		obj.setImage(AutomationConstants.imageUrl);
		obj.setPostContent(AutomationConstants.postContent);
		obj.clickSubmit();
		Assert.assertEquals(obj.getAlertText(), "");
	}

	@Test(priority = 6)
	public void createPostWithBlankPostContent() throws InterruptedException {
		obj = new UserCreatePost(driver);
		obj.setTitle(AutomationConstants.postTitle);
		obj.setCategory(AutomationConstants.category);
		obj.setImage(AutomationConstants.imageUrl);
		obj.clickSubmit();
		Assert.assertEquals(obj.getAlertText(), "");
	}

	@Test(priority = 7)
	public void createPostWithValidValues() throws InterruptedException {
		obj = new UserCreatePost(driver);
		obj.setTitle(AutomationConstants.postTitle);
		obj.setCategory(AutomationConstants.category);
		obj.setImage(AutomationConstants.imageUrl);
		obj.setPostContent(AutomationConstants.postContent);
		obj.clickSubmit();
		String expectedAlertMessage = AutomationConstants.userPostSuccessMessage;
		String actualAlertMessage = obj.getAlertText();
		obj.alertClickAccept();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

	@BeforeTest
	public void secondBeforeTestCase() {
		// Go to new post page
		driver.findElement(By.xpath("//a[@id='nav' and text()='New post']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
}
