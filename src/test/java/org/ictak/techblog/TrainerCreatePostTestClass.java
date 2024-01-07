package org.ictak.techblog;

import java.time.Duration;

import org.ictak.constants.AutomationConstants;
import org.ictak.pages.TrainerCreatePost;
import org.ictak.utilities.CaptureScreenshot;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TrainerCreatePostTestClass extends TrainerTestBase {
	TrainerCreatePost obj = null;

	@Test(priority = 1)
	public void createPostWithBlankTitle() throws InterruptedException {
		obj = new TrainerCreatePost(driver);
		obj.setCategory(AutomationConstants.category);
		obj.setImage(AutomationConstants.imageUrl);
		obj.setPostContent(AutomationConstants.postContent);
		obj.clickSubmit();
		Assert.assertEquals(obj.getAlertText(), "");
	}

	@Test(priority = 2)
	public void createPostWithBlankAuthor() throws InterruptedException {
		obj = new TrainerCreatePost(driver);
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
		obj = new TrainerCreatePost(driver);
		obj.setTitle(AutomationConstants.postTitle);
		obj.setCategory(AutomationConstants.category);
		obj.setImage("");
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
		obj = new TrainerCreatePost(driver);
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
			ss.captureScreenshot("trainer-createPostWithInvalidImage");
			obj.gotoCreatePost();
		}
		Assert.assertEquals(alertText, "");
	}

	@Test(priority = 5)
	public void createPostWithBlankCategory() throws InterruptedException {
		obj = new TrainerCreatePost(driver);
		Thread.sleep(3000);
		obj.setTitle(AutomationConstants.postTitle);
		obj.setImage(AutomationConstants.imageUrl);
		obj.setPostContent(AutomationConstants.postContent);
		obj.clickSubmit();
		Assert.assertEquals(obj.getAlertText(), "");
	}

	@Test(priority = 6)
	public void createPostWithBlankPostContent() throws InterruptedException {
		obj = new TrainerCreatePost(driver);
		obj.setTitle(AutomationConstants.postTitle);
		obj.setCategory(AutomationConstants.category);
		obj.setImage(AutomationConstants.imageUrl);
		obj.setPostContent("");
		obj.clickSubmit();
		Assert.assertEquals(obj.getAlertText(), "");
	}

	@Test(priority = 7)
	public void createPostWithValidValues() throws InterruptedException {
		obj = new TrainerCreatePost(driver);
		obj.setTitle(AutomationConstants.postTitle);
		obj.setCategory(AutomationConstants.category);
		obj.setImage(AutomationConstants.imageUrl);
		obj.setPostContent(AutomationConstants.postContent);
		obj.clickSubmit();
		Thread.sleep(1000);
		String expectedAlertMessage = AutomationConstants.trainerPostSuccessMessage;
		String actualAlertMessage = obj.getAlertText();
		obj.alertClickAccept();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);

	}

	@BeforeTest
	public void secondBeforeTestCase() {
		// Go to new posts page
		driver.findElement(By.xpath("//a[@id='nav' and text()='New post']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
