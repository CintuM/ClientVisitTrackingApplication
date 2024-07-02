package org.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;

public class VisitLogsActionButtons extends TestNG {

	WebDriver driver;
	Actions actions;
	WebDriverWait wait;
	public  VisitLogsActionButtons(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	//--------------------------------------------------- locators -----------------------------------------------
	
	//	------------------------login----------------------
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

	//	--------------------------------------------action buttons ------------------------------------------------

	@FindBy(xpath="//a[@href='/visitlogs' and contains(@class, 'flex items-center p-2 text-gray-900 rounded-lg')]")
	WebElement visitlogs;
	public void visitLogsPage()  {
		visitlogs.click();
	}
	@FindBy(xpath="//svg[@viewBox='0 0 448 512']")
	WebElement deleteIcon;
	public void deleteActionButton()  {
		deleteIcon.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Testing Demo");
		alert.accept();
	}
	@FindBy(xpath="//svg[@viewBox='0 0 448 512']")
	WebElement viewIcon;
	public void viewDetailsActionButton()  {
		viewIcon.click();
	}
	@FindBy(xpath="//button[contains(@class, 'text-red-500') and contains(@class, 'uppercase') and contains(@class, 'px-6')")
	WebElement viewDetailsClose;
	public void viewDetailsCloseButton()  {
		viewDetailsClose.click();
	}
	@FindBy(xpath="//svg[contains(@viewBox, '0 0 576 512') and contains(@stroke-width, '0')]")
	WebElement updateAction;
	public void updateActionButton()  {
		updateAction.click();

	}

}
