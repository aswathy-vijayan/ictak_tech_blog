package org.ictak.techblog;

import org.ictak.constants.AutomationConstants;
import org.ictak.pages.UserCreatePost;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCreatePostTestCase extends UserTestBase {
	UserCreatePost obj = null;

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
		obj.setTitle(AutomationConstants.postTitle);
		obj.setCategory(AutomationConstants.category);
		obj.setImage(AutomationConstants.invalidImageUrl);
		obj.setPostContent(AutomationConstants.postContent);
		obj.clickSubmit();
		String alertText = obj.getAlertText();
		if (alertText.length() > 0) {
			obj.alertClickAccept();
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
		Thread.sleep(1000);
		String expectedAlertMessage = AutomationConstants.userPostSuccessMessage;
		String actualAlertMessage = obj.getAlertText();
		obj.alertClickAccept();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}
}
