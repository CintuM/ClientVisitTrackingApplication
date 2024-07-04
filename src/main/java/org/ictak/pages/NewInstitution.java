package org.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
public class NewInstitution  {
	WebDriver driver;
	Actions actions;
	WebDriverWait wait;
	public  NewInstitution(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}


	//	--------------------------------------------login locators------------------------------------------------
	@FindBy(name="userId")
	WebElement uname;
	@FindBy(css = "input[name='password']")
	WebElement pw;
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	WebElement sgnInBtn;
	@FindBy(xpath = "//a[contains(@href,'/visitlogs')]")
	WebElement visitLogs;

	public void userName(String mangr_uname) {;
	uname.sendKeys(mangr_uname);
	}
	public void password(String mngr_passwd) {

		pw.sendKeys(mngr_passwd);
	}
	public void loginBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(sgnInBtn));
		sgnInBtn.click();
	}
	//	--------------------------------------------visit logs page locators------------------------------------------------	

	@FindBy(xpath="//a[@href='/visitlogs' and contains(@class, 'flex items-center p-2 text-gray-900 rounded-lg')]")
	WebElement visitlogs;
	public void visitLogsPage()  {
		visitlogs.click();
	}
	@FindBy(xpath="//h3[text()='Visit Logs' and contains(@class, 'text-md sm:text-2xl')]")
	WebElement visitlogstext;
	public String vistLogsHeading() {
		wait.until(ExpectedConditions.textToBePresentInElement(visitlogstext, visitlogstext.getText()));
		String dashbrd_rslt=visitlogstext.getText();
		return dashbrd_rslt;
	}
//	--------------------------------------------visit logs New Institute Form Locators------------------------------------------------	
	
	@FindBy(xpath="//button[normalize-space(text())='Add Institutions']")
	WebElement newInstButton;
	public void newInstBtn()  {
		newInstButton.click();
	}
	@FindBy(xpath="//input[@id='react-select-10-input']")
	WebElement instType;
	public void instituteType(String instituteType)  {
		instType.sendKeys(instituteType);		
		instType.sendKeys(Keys.RETURN);
	}
	@FindBy(id="organizationName")
	WebElement instName;
	public void instituteName(String iName)  {
		instName.sendKeys(iName);
	}
	@FindBy(id="email")
	WebElement instEmail;
	public void instituteEmail(String iEmail)  {
		instEmail.sendKeys(iEmail);
	}
	@FindBy(id="place")
	WebElement place;
	public void institutePlace(String iplace)  {
		place.sendKeys(iplace);
	}
	@FindBy(xpath="//input[@id='react-select-11-input']")
	WebElement state;
	public void instituteState(String istate)  {
		state.sendKeys(istate);
		state.sendKeys(Keys.RETURN);
	}
	@FindBy(xpath="//input[@id='react-select-12-input']")
	WebElement district;
	public void instituteDistrict(String iDistrict)  {
		district.sendKeys(iDistrict);
		district.sendKeys(Keys.RETURN);
	}
	@FindBy(xpath="//*[@id=\"static-modal\"]/div[1]/div/div[8]/button[1]")
	WebElement submitBtn;
	public void submitButton()  {
		wait.until(ExpectedConditions.visibilityOf(submitBtn));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
		actions.moveToElement(submitBtn).click().perform();
	}
//	--------------------------------------------Form Alert Pop-up Locators------------------------------------------------	
	
	@FindBy(xpath="//button[text()='Close' and contains(@class, 'bg-green-600')]")
	WebElement closeBtn;
	public void closePopupButton()  {
		wait.until(ExpectedConditions.visibilityOf(closeBtn));
        wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closeBtn);
		actions.moveToElement(closeBtn).click().perform();
	}
	@FindBy(xpath="//h3[@class='text-xl font-normal text-gray-500 mt-5 mb-6' and text()='Thanks for adding new Institution']")
	WebElement closePopuptext;
	public String closePopupHeading() {
		wait.until(ExpectedConditions.textToBePresentInElement(closePopuptext, closePopuptext.getText()));
		String dashbrd_rslt=closePopuptext.getText();
		return dashbrd_rslt;
	}
	@FindBy(xpath="	//p[@class='text-red-500 ml-2 mb-[0px] text-[10px]' and text()='Required']")
	WebElement blankReqtext;
	public String blankRequiredtext() {
		wait.until(ExpectedConditions.textToBePresentInElement(blankReqtext, blankReqtext.getText()));
		String dashbrd_rslt=blankReqtext.getText();
		return dashbrd_rslt;
	}
	@FindBy(xpath="//div[contains(@class, 'Toastify__toast') and contains(@class, 'Toastify__toast--error') and contains(text(), 'College of Engineering Punaloor, Punaloor ,Kollam is already exisit.')]")
	WebElement alertPopupText;
	public String alertPopupText() {
		wait.until(ExpectedConditions.textToBePresentInElement(alertPopupText, alertPopupText.getText()));
		String dashbrd_rslt=alertPopupText.getText();
		return dashbrd_rslt;
	}
	
}
