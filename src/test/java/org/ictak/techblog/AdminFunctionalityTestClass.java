package org.ictak.techblog;
	import org.ictak.pages.Aboutus;
import org.ictak.pages.Action_s;
	import org.ictak.pages.Action_sApprvlComnt;
	import org.ictak.pages.Action_sRejctComnt;
	import org.ictak.pages.AddNewPost;
	import org.ictak.pages.AddOrRemove;
	import org.ictak.pages.AdminLoginP;
	import org.ictak.pages.AllPost;
	import org.ictak.pages.AllPostEdit;
	import org.ictak.pages.Categories;
	import org.ictak.pages.CategoriesEdit;
import org.ictak.pages.Contactus;
import org.ictak.pages.MyPost;
	import org.ictak.pages.MyPostEdit;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	public class AdminFunctionalityTestClass extends AdminFunctionalityTestBase {
		//AdminLogin obj =

		@Test (priority=1)
		
		public void loginpage() throws Exception {
//			obj = new AdminLogin(driver);
//			obj.AdminLoginDrop();
//			obj.AdminUsername(prop.getProperty("Username"));
//			obj.AdminPassword("1234");
			
			
			AdminLoginP oadminLogin = new AdminLoginP(driver);
			oadminLogin.loginToApplication(prop.getProperty("Username"), "1234");
			Thread.sleep(2000);
			Assert.assertEquals(driver.getCurrentUrl(), "http://64.227.132.106/admin");
		}
		
//			Category ocategory = new Category();
//			ocategory.
		
		//public void allpages()
		//{
			//AllPages oallpages= new AllPages(driver);
			//oallpages.AllPagesUpdation();
		//}
		@Test (priority=2)
		
		public void allpages() throws Exception {
		    try {
		        System.out.println("Executing allpages method...");
		        AllPost oallpages = new AllPost(driver);
		        oallpages.clickEditButton();
		     
		        System.out.println("allpages method executed successfully.");
		    } catch (Exception e) {
		        System.err.println("Error in allpages method: " + e.getMessage());
		        e.printStackTrace();
		        throw e; // Re-throw the exception to mark the test as failed
		    }
		    
		}
		
		@Test (priority=3)
		public void allpostedit() throws Exception
		{
			AllPostEdit oalledit=new AllPostEdit(driver);
			oalledit.AllPostEditing();
			AllPost oallpages = new AllPost(driver);
			oallpages.clickDeleteButton();
		}
		@Test (priority=4)
	public void Mypost() throws InterruptedException
	{
		MyPost omypost=new MyPost(driver);
		omypost.editMyPost();
		Assert.assertEquals(driver.getCurrentUrl(), "http://64.227.132.106/edit");

		
		
		//http://64.227.132.106/mypost
	}
		@Test (priority=5)
	public void editMypost() throws Exception {
		MyPostEdit omypostedit=new MyPostEdit(driver);
		omypostedit.MyPostEditing();
		MyPost omypost=new MyPost(driver);
		omypost.deleteMyPost();
		
	}
		
		@Test (priority=6)
		public void pendingapproval() throws InterruptedException
		{
			Action_s opendingaprvl=new Action_s(driver);
			opendingaprvl.pendingApproval();
			Assert.assertEquals(driver.getCurrentUrl(), "http://64.227.132.106/comment");
			Action_sApprvlComnt ocomment=new Action_sApprvlComnt(driver);
			ocomment.adminComntToUser();
			}

		@Test (priority=7)
		public void adminRejctcomnt() throws InterruptedException {
		Action_s opendingaprvl=new Action_s(driver);
		opendingaprvl.rejectApproval();
		Action_sRejctComnt orejctcomnt=new Action_sRejctComnt(driver);
		orejctcomnt.rejectComntToUser();
		
		}
		@Test (priority=8)
		
	    public void addOrRemove	() throws InterruptedException {
	    	AddOrRemove oaddremove=new AddOrRemove(driver);
	    	oaddremove.addCategory();
	    	oaddremove.removeCategory();
	    }
		@Test (priority=9)

		public void addnewpost() throws Exception
		{
			AddNewPost oaddnewpost=new AddNewPost(driver);
			oaddnewpost.addingnewpost();
			
		}
		@Test (priority=10)
		public void categories() throws InterruptedException
		{
			Categories ocategories=new Categories(driver);
			ocategories.CategoriesEdit();
			Assert.assertEquals(driver.getCurrentUrl(), "http://64.227.132.106/categorywise");
			
		}
		@Test (priority=11)
		public void editingcategories() throws InterruptedException
		{
			CategoriesEdit ocategoriesedit=new CategoriesEdit (driver);
			ocategoriesedit.editCategories();
			Categories ocategories=new Categories(driver);
			ocategories.CategoriesDelete();
			
			
		}
	
	@Test (priority=12)
	
	public void about() throws InterruptedException

	{
		Aboutus oaboutus=new Aboutus(driver);
		oaboutus.aboutus();
		Assert.assertEquals(driver.getCurrentUrl(), "http://64.227.132.106/aboutus");
	}

	

	@Test(priority=13)

	public void contact() throws InterruptedException

	{
		Contactus ocontactus=new Contactus(driver);
		ocontactus.contactus();
		Assert.assertEquals(driver.getCurrentUrl(),"http://64.227.132.106/contactus");
		
	}
	}


