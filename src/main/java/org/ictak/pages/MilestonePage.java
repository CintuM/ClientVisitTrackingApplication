package org.ictak.pages;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MilestonePage {
	WebDriver driver;
	WebDriverWait wait;
	public  MilestonePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	@FindBy(name="userId")
	WebElement uname;
	@FindBy(css = "input[name='password']")
	WebElement pw;
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	WebElement sgnInBtn;
	@FindBy(xpath = "//span[@class='ms-3' and contains(text(),'Dashboard')]")
	WebElement dashbrdPage;
	@FindBy(xpath = "//h2[contains(text(),'Milestones')]")
	WebElement milestones;
	@FindBy(xpath = "(//select[@class='bg-gray-200 text-black px-4 py-2 rounded-md w-full md:w-auto'])[1]")
	WebElement organizatnType;
	@FindBy(xpath = "(//select[@class='bg-gray-200 text-black px-4 py-2 rounded-md w-full md:w-auto'])[2]")
	WebElement organizatnName;
	@FindBy(xpath = "//button[contains(text(), 'Go')]")
	WebElement goBtn;
	@FindBy(xpath ="//a[@download='visit_data.csv' and contains(text(),'Export CSV')]")
	WebElement downloadData;
	@FindBy(xpath ="//img[@src='/static/media/Profile Picture.4adcbd95bd8d4932c37d71ad885c4c76.svg']")
	WebElement profileImg;
	@FindBy(xpath="//div[text()='Logout']")
	WebElement logout;

	public void userName(String mangr_uname) {;
	uname.sendKeys(mangr_uname);
	}
	public void password(String mngr_passwd) {

		pw.sendKeys(mngr_passwd);
	}
	public void loginBtn() {	

		System.out.println("login btn");
		wait.until(ExpectedConditions.elementToBeClickable(sgnInBtn));
		sgnInBtn.click();
	}

	public String getDashbdMileston() {
		wait.until(ExpectedConditions.visibilityOf(dashbrdPage));
		Actions actions = new Actions(driver);
		actions.moveToElement(dashbrdPage).click().perform();	
		wait.until(ExpectedConditions.textToBePresentInElement(milestones, milestones.getText()));
		String mileston_rslt=milestones.getText();
		return mileston_rslt;

	}
	public void selectMilestones() {
		wait.until(ExpectedConditions.elementToBeClickable(organizatnType));
		organizatnType.click();
		Select orgType = new Select(organizatnType);
		orgType.selectByVisibleText("Academic Institutions");
		// organizatnType.sendKeys(Keys.RETURN);		
		wait.until(ExpectedConditions.elementToBeClickable(organizatnName));
		organizatnName.click();
		Select orgName = new Select(organizatnName);
		orgName.selectByVisibleText("ITI");		
		//organizatnName.sendKeys(Keys.ENTER);		
		wait.until(ExpectedConditions.elementToBeClickable(goBtn));
		goBtn.click();

	}
	public void exportCSV() {
		wait.until(ExpectedConditions.visibilityOf(downloadData));
		Actions actions = new Actions(driver);
		actions.moveToElement(downloadData).click().perform();	
	}
	public void logOut() {
		profileImg.click();
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
	}

}
