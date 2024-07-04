package org.ictak.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="userId")
	WebElement userId;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement loginButton;
	
	@FindBy(xpath="//h3[text()='Dashboard']")
	WebElement dashboardText;
	
	@FindBy(xpath="//h1[text()='Appointments']")
	WebElement appointments;
	
//	@FindBy(how = How.NAME , using = "text-violet-700 text-sm")
//	@FindBy(className="text-violet-700 text-sm")
	@FindBy(xpath="(//p[text()=' Appointments'])")
	WebElement appointmentsNum;
	
	@FindBy(xpath="()")
	WebElement home;
	
	@FindBy(xpath ="//img[@src='/static/media/Profile Picture.4adcbd95bd8d4932c37d71ad885c4c76.svg']")
	WebElement image;
	
	@FindBy(xpath="//div[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath="//div[text()=' Invalid user Credentials']")
	WebElement invalidMsg;
	
	@FindBy(xpath="//p[text()='Please enter the password']")
	WebElement invalidBlankMsg;
	
	public String safeLanding() {
		WebElement home = driver.findElement(By.xpath("(//h2[text()='Visit App'])[1]"));
		return home.getText();
	}
	
	public void setName(String name) {
		userId.clear();
		userId.sendKeys(name); 
	}
	
	public void setPwd(String pw) {
		password.clear();
		password.sendKeys(pw); 
	}
	
	public String login() {
		Actions actions = new Actions(driver);
		actions.moveToElement(loginButton).click().build().perform();
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		return dashboardText.getText();			
	}
	
	public Boolean loginInvalid(String invalid) {
		Actions actions = new Actions(driver);
		actions.moveToElement(loginButton).click().build().perform();
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		if(invalid.equalsIgnoreCase("invalid")) {
		if (invalidMsg.isEnabled())
			return true;
		else
			return false;
		}
		else {
			if (invalidBlankMsg.isEnabled())
				return true;
			else
				return false;
			}			
	}
	
	public void logOut() {
		image.click();
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		logout.click();
		
	}
}
