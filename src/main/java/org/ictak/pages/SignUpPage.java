package org.ictak.pages;

import java.time.Duration;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jdk.internal.org.jline.terminal.MouseEvent.Button;
import jdk.javadoc.internal.doclets.formats.html.markup.Text;

public class SignUpPage {
	
	WebDriver driver;
	public SignUpPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath="//img[@src=\"../../assets/images/user.png\"]")
//	WebElement DropDown;
//
//
//
//	@FindBy(xpath="//a[@href=\"/signup\"]")
//	WebElement  signup;

	@FindBy(id="first")
	WebElement enterName;
	
	@FindBy(xpath="//select[@style=\"max-width: 90%;\"]")
	WebElement drpDown;

//	@FindBy(xpath="//option[@class=\"ng-star-inserted\"]")
//	WebElement user;
	
	@FindBy(xpath="//select[@formcontrolname='id']//option[@value='0: user']")
	private WebElement user;


	@FindBy(id="em")
	private WebElement yourEmail;
	@FindBy(id="pw")
	private WebElement yourPassword;

	@FindBy(xpath="//*[@id=\"but\"]")
	 //@FindBy(id="but")
	//@FindBy(xpath="//button[@type=\"submit\"]")
	//@FindBy(xpath="//button[@id='but']")
	//@FindBy(xpath="//button[contains(@id,'but')]")
	private WebElement userSubmitButton;


	//trainer
	 
	@FindBy(xpath="//option[@value=\"1: trainer\"]")
	WebElement trainer;



	@FindBy(xpath="(//select[@style=\"max-width: 90%;\"])[2]")
	WebElement eduDrope;


	@FindBy(xpath="//option[@value=\"0: UNDER GRADUATE\"]")
	WebElement eduPG;



	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement tSub;
	//option
	@FindBy(xpath="//*[@id=\"but\"]")
	WebElement tOptionS;


//	public void ClickDropDown() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.elementToBeClickable(DropDown)).click();
//		DropDown.click();
//	}
//	public void ClickSign() {
//		signup.click();
//		
//	}
	
//	public void SignUpPage1(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}


	public void EnterName(String yrName) {
		enterName.sendKeys(yrName);
		
	}
	public void DrpDwnUsr() {
		drpDown.click();
	}

	public void SelectUser() {
		user.click();
		
		
		
	}
	public void setYourEmail(String strYourEmail){
		yourEmail.sendKeys(strYourEmail); 

	}
	public void setYourPassword(String stYourPassword){
	    yourPassword.sendKeys(stYourPassword);
	}

	public void cSubmitUser() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		driver.manage().window().maximize();
		//userSubmitButton.sendKeys(Keys.ENTER);
		//userSubmitButton.click();
		}
	public void allSubmitSign() {
		tSub.sendKeys(Keys.ENTER);
	}
	//option
	public void activeESubmit() {
		tSub.submit();
	}
	public void trySub() {
		tOptionS.click();
		
	}


	//trainer

	public void SelectTrainer() {
		trainer.click();

	}
	public void SelectEdu() {
		eduDrope.click();
	}
	public void SelectPG() {
		eduPG.click();
	}
	//public void tsubmitSign() {
	//tSub.click();



	public String getErrorT1() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		return(driver.switchTo().alert().getText());
		
	}



	public String getErrorU1() {
		return(driver.switchTo().alert().getText());
	}

	public String getErrorU2() {
	  return(driver.findElement(By.xpath("//small[@style=\"color: rgb(255, 15, 15);\"]")).getText());
		 
		
	}
	public String getErrorUp1() throws InterruptedException {
		driver.manage().timeouts().getPageLoadTimeout();
		//return(driver.findElement(By.xpath("(//small[@class=\"ng-star-inserted\"])[2]")).getText());
		//return(driver.findElement(By.xpath("//small[@class=\"ng-star-inserted\"]//child::b")).getText());
		//return(driver.findElement(By.xpath("//small[@class=\"ng-star-inserted\"]//child::br")).getText());
		return(driver.findElement(By.xpath("//*[@id=\"sign\"]/small[2]/b")).getText());
		
	}

	public String getErrorUSelect1() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
		//return(driver.findElement(By.xpath("//small[@style=\"color: rgb(255, 15, 15);\"]/b")).getText());
			//return (driver.findElement(By.xpath("//small[@class=\"ng-star-inserted\"]")).getText());
			return(driver.findElement(By.xpath("//small[@style=\"color: rgb(255, 15, 15);\"]//b")).getText());
	}


}

//---------------------------------------------------------------------------------------------

