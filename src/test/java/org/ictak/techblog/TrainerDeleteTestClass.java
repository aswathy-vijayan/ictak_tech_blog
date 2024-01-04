package org.ictak.techblog;

import org.ictak.constants.AutomationConstants;
import org.ictak.pages.TrainerDeletePost;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrainerDeleteTestClass extends TrainerDeleteTestBase {
	TrainerDeletePost obj = null;

	@Test
	public void deletePost() throws InterruptedException {
		obj = new TrainerDeletePost(driver);
		obj.deletePost();
		String actualAlertText = obj.getAlertText();
		obj.alertClickAccept();
		Assert.assertEquals(actualAlertText, AutomationConstants.userPostDeleteMessage);
	}

}
