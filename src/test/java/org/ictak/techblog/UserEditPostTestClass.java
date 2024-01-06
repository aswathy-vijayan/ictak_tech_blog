package org.ictak.techblog;

import org.ictak.constants.AutomationConstants;
import org.ictak.pages.UserEditPost;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserEditPostTestClass extends UserEditTestBase {
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
		obj.changeImage(AutomationConstants.invalidImageUrlNew);
		obj.clickSubmit();
		String alertText = obj.getAlertText();
		if (alertText.length() > 0) {
			obj.alertClickAccept();
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
}
