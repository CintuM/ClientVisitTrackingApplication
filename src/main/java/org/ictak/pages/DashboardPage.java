package org.ictak.pages;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	WebDriver driver;
	WebDriverWait wait;


	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}


	@FindBy(xpath="//h1[text()='Appointments']")
	WebElement appointments;

	@FindBy(xpath="//h1[text()='Add New Visit']")
	WebElement add;

	@FindBy(xpath="//h3[text()='Add Visits']")
	WebElement addVisit;

	@FindBy(xpath="(//div[@class=' css-19bb58m']/descendant::input)[5]")
	WebElement institution;

	@FindBy(xpath="(//div[@class=' css-19bb58m']/descendant::input)[6]")
	WebElement employee;

	@FindBy(xpath="(//div[@class=' css-19bb58m']/descendant::input)[4]")
	WebElement status;

	@FindBy(xpath="(//button[text()='Submit'])[1]")
	WebElement submit;

	@FindBy(xpath="(//input[@id='purpose' and @name='purpose'])[2]")
	WebElement purpose;

	@FindBy(xpath="(//div[@class=' css-19bb58m']/descendant::input)[7]")
	WebElement contactPerson;

	@FindBy(xpath="(//input[@id='additionalNotes' and @name='additionalNotes'])[2]")
	WebElement additionalNotes;

	@FindBy(xpath = "(//input[@id='visitDateTime'])[2]")
	WebElement setDate;

	@FindBy(xpath="(//button[@type='button' and text()='Submit'])[2]")
	WebElement submit1;

	@FindBy(xpath="//span[text()='Completed']")
	WebElement completedVists;

	@FindBy(xpath="(//button[text()='Cancel'])[3]")
	WebElement cancel;

	@FindBy(xpath="(//button[text()='Cancel'])[1]")
	WebElement cancel1;

	@FindBy(xpath="(//button[text()='Close'])[2]")
	WebElement close;

	@FindBy(xpath="(//button[text()='Close'])[3]")
	WebElement close1;
	
	@FindBy(xpath="//td[@class='px-6 py-4 whitespace-nowrap flex space-x-4']")
	WebElement upcomingvisitNum;
	
	@FindBy(xpath="//a[text()='Export CSV']")
	WebElement upcomingVisitCSV;
	
	@FindBy(xpath="(//button[@class='text-gray-400 bg-white hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center'])[2])")
	WebElement crossadded;


	public Boolean deleteVisit() {

		List<WebElement> allDelete=driver.findElements(By.xpath("//span[text()='Delete']/parent::div"));
		int count=allDelete.size();
//		System.out.println("Clicking last delete");
		allDelete.get(count-1).click();

		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Testing");
		alert.accept();
		return true;
	}

	@SuppressWarnings("finally")
	public Boolean updateNewVisit() {

		List<WebElement> allUpdate=driver.findElements(By.xpath("//span[text()='Update']/parent::div"));
		int count=allUpdate.size();
		System.out.println("Clicking last update");
		allUpdate.get(count-1).click();

		//			wait.until(ExpectedConditions.visibilityOf(status));
		status= driver.findElement(By.xpath("(//div[@class=' css-19bb58m']/descendant::input)[4]"));
		status.sendKeys("Action Needed");
		status.sendKeys(Keys. RETURN);
		submit.click();
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		try {
			if (driver.findElement(By.xpath("//h3[text()='Updated Successfully'])")).isEnabled()) {
				cancel1.click();
				return true;
			}
			else {
				cancel1.click();
				return false;
			}
		}
		finally {
			cancel1.click();
			return false;
		}
	}

	public Boolean viewNewVisit() {
		
		List<WebElement> allVisits=driver.findElements(By.xpath("//button[@class='text-blue-700 flex items-center space-x-1']"));
		int count=allVisits.size();
//		System.out.println(count);
//		System.out.println("Clicking last visit to view");
		allVisits.get(count-3).click();

		if (driver.findElement(By.xpath("//h3[text()='Visit Purpose']")).isEnabled()) {
			driver.findElement(By.xpath("//button[text()='Close' and @type='button']")).click();
			return true;
		}
		else
			return false;
	}

	public Boolean compareAppointmentNumber() {
		
		List<WebElement> allupcomingvisits=driver.findElements(By.xpath("//td[@class='px-6 py-4 whitespace-nowrap flex space-x-4']"));
		int count=allupcomingvisits.size();
		System.out.println(count);
		
		try {
		driver.findElement(By.xpath("//p[text()='"+count+"']"));
		return true;
		}
		catch(Exception e) {
			System.out.println("Apointment number and upcoming visits number not matching !!");
			return false;
		}
		
	}


	public Boolean addNewVisit(String institute1,String employee1,String purpose1,String contactperson1, String note, String date1) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		add.click();
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		addVisit.click();

		institution=driver.findElement(By.xpath("(//div[@class=' css-19bb58m']/descendant::input)[5]"));
		//			wait.until(ExpectedConditions.visibilityOf(institution));
		institution.sendKeys(institute1);
		institution.sendKeys(Keys. RETURN);

		employee=driver.findElement(By.xpath("(//div[@class=' css-19bb58m']/descendant::input)[6]"));
		//			wait.until(ExpectedConditions.visibilityOf(employee));
		employee.sendKeys(employee1);
		employee.sendKeys(Keys. RETURN);

		//wait.until(ExpectedConditions.elementToBeClickable(setDate));
		setDate=driver.findElement(By.xpath("(//input[@id='visitDateTime'])[2]"));
		setDate.sendKeys(date1);
		setDate.sendKeys(Keys.TAB);
		setDate.sendKeys("14:45");
		setDate.sendKeys(Keys.ENTER);

		//wait.until(ExpectedConditions.visibilityOf(purpose));
		purpose=driver.findElement(By.xpath("(//input[@id='purpose' and @name='purpose'])[2]"));
		purpose.click();
		purpose.sendKeys(purpose1);

		contactPerson=driver.findElement(By.xpath("(//div[@class=' css-19bb58m']/descendant::input)[7]"));
		//			wait.until(ExpectedConditions.elementToBeClickable(contactPerson));
		contactPerson.sendKeys(contactperson1);
		contactPerson.sendKeys(Keys. ENTER); 

		additionalNotes=driver.findElement(By.xpath("(//input[@id='additionalNotes' and @name='additionalNotes'])[2]"));
		//			wait.until(ExpectedConditions.visibilityOf(additionalNotes));
		additionalNotes.sendKeys(note);
		additionalNotes.sendKeys(Keys. RETURN);

		//			wait.until(ExpectedConditions.elementToBeClickable(submit1));
		submit1=driver.findElement(By.xpath("(//button[@type='button' and text()='Submit'])[2]"));
		submit1.click();
//		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		System.out.println(driver.findElement(By.xpath("//h3[text()='Yeah , you have added a visit']")).isEnabled());
		
		if (driver.findElement(By.xpath("//h3[text()='Yeah , you have added a visit']")).isEnabled()) {
			
			try{
//				crossadded.click();
				close.click();
				System.out.println("Yeah , you have added a visit");
				return true;
			}
			catch(Exception e) {
				try {
				close1.click();
				System.out.println("Visit already scheduled, You can't add new visit in this institution");
				cancel.click();
				System.out.println("Cancel clicked");
				}
				catch(Exception e1) {
					cancel.click();
					System.out.println("Invalid data. Request cancelled");
				}
			}
			return false;
			
		}
		return false;		
	}


	public Boolean addNewVisitBlank(String institute1,String employee1,String purpose1,String note) {

		add.click();
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		addVisit.click();
		
		institution=driver.findElement(By.xpath("(//div[@class=' css-19bb58m']/descendant::input)[5]"));
		institution.sendKeys(institute1);
		institution.sendKeys(Keys. RETURN);
		
		employee=driver.findElement(By.xpath("(//div[@class=' css-19bb58m']/descendant::input)[6]"));
		employee.sendKeys(employee1);
		employee.sendKeys(Keys. RETURN);

		purpose=driver.findElement(By.xpath("(//input[@id='purpose' and @name='purpose'])[2]"));
		purpose.sendKeys(purpose1);

		additionalNotes=driver.findElement(By.xpath("(//input[@id='additionalNotes' and @name='additionalNotes'])[2]"));
		additionalNotes.sendKeys(note);
		
		submit=driver.findElement(By.xpath("(//button[@type='button' and text()='Submit'])[2]"));
		submit.click(); 

		if (driver.findElement(By.xpath("//span[text()='Please select contact person']")).isEnabled()) {
			cancel.click();
			return true;
		}
		else {
			cancel.click();
			return false;
		}
	}

	public Boolean completedVisits() {

		List<WebElement> allcompletedVisits=completedVists.findElements(By.xpath("//span[text()='Completed']"));
		int count=allcompletedVisits.size();
		System.out.println("Count of completed visits in Upcoming section: "+count);
		if(count==0)	
			return true;
		else
			return false;
	}
	
	public void exportUpcomingVisits() {
//		wait.until(ExpectedConditions.visibilityOf(upcomingVisitCSV));
		upcomingVisitCSV=driver.findElement(By.xpath("//a[text()='Export CSV']"));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(upcomingVisitCSV).click().perform();
	}
	
	public Boolean downloadCSV() throws InterruptedException {
		System.out.println("download csv");					
		exportUpcomingVisits();		
		String downloadDir = System.getProperty("user.home") + "\\Downloads";
		String expectedFileName = "upcoming-visits.csv";		
		File downloadedFile = new File(downloadDir + "/" + expectedFileName);
		int waitTime = 30; 
		int elapsedTime = 0;
		while (!downloadedFile.exists() && elapsedTime < waitTime) {
			Thread.sleep(1000);
			elapsedTime++;
		}

		if (downloadedFile.exists()) {
			System.out.println("File downloaded successfully: " + downloadedFile.getAbsolutePath());
			return true;
		} else {
			System.out.println("Failed to download the file within the specified time.");
			return false;
		}
	}
}
