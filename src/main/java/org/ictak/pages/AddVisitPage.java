package org.ictak.pages;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddVisitPage {
	WebDriver driver;
	WebDriverWait wait;
	public  AddVisitPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	@FindBy(name="userId")
	WebElement uname;
	@FindBy(css = "input[name='password']")
	WebElement pw;
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	WebElement sgnInBtn;
	@FindBy(xpath = "//a[contains(@href,'/visitlogs')]")
	WebElement visitLogs;
	@FindBy(xpath = "//h3[contains(text(),'Dashboard')]")
	WebElement dashbrd;
	@FindBy(xpath = "//button[contains(text(),'Add Visit')]")
	WebElement addVstBtn;
	//@FindBy(id = "react-select-7-placeholder")
	@FindBy(id="react-select-7-input")	
	WebElement sel_Institution;
	@FindBy(id="react-select-8-input")
	WebElement sel_employee;
	@FindBy(id="visitDateTime")
	WebElement visitdate;	
	@FindBy(xpath = "(//input[@id='purpose'])[2]")
	WebElement purpose ;
	@FindBy(id="react-select-9-input")
	WebElement cont_person;
	@FindBy(xpath="(//input[@id='additionalNotes'])[2]")
	WebElement additionalNotes;
	@FindBy(xpath="(//input[@id='discussionTopic'])[2]")
	WebElement discnTopic;
	@FindBy(id="file")
	WebElement uploadDoc;
	@FindBy(xpath="(//button[contains(text(), 'Submit')])[3]")
	WebElement vistSubmitBtn;
	@FindBy(xpath = "(//button[contains(text(), 'Cancel')])[4]")
	WebElement adVistCancel;
	@FindBy(xpath = "(//input[@id='visitDateTime'])[2]")
	//@FindBy(css=("(input[type='datetime-local'])[2]"))
	WebElement setDate;
	@FindBy(xpath = "(//div[@id='static-modal']//div[6]/div/button)[2]")
	WebElement addContPersnForm;
	@FindBy(xpath = "//p[contains(text(),'Visit scheduled by another employee , Do you want to add new visit ?')]")
	WebElement warningMsgtoPrcd;
	@FindBy(xpath = "//p[contains(text(),'Visit already scheduled, You can't add new visit in this institution')]")
	WebElement visitScheduld;
	@FindBy(xpath = "(//div[@id='static-modal']/div/div/div/div[2]/p)[2]")
	WebElement schedldVstClose;
	@FindBy(xpath = "//h2[contains(text(),'Warning!!')]")
	WebElement warningMsg;
	@FindBy(xpath = "(//button[contains(text(), 'Close')])[3] ")
	WebElement closeBtn;
	@FindBy(xpath="//button[contains(text(),'Proceed')]")
	WebElement proceedBtn;
	@FindBy(xpath = "(//button[contains(text(), 'Close')])[2]")
	WebElement proceed_closeBtn;
	@FindBy(xpath = "//p[contains(text(),'visit already scheduled')]")
	WebElement duplicateEntry;
	@FindBy(xpath = "  (//div[@id='static-modal']//button[contains(text(), 'Close')])[3]")
	WebElement duplict_closeBtn;
	@FindBy(xpath = "//*[@id='static-modal']//span[contains(text(),'Please select a institution')]")
	WebElement emptyFldInstitut;
	@FindBy(xpath = "(//button[contains(text(),'Add')])[6]")
	WebElement addContPerson;
	@FindBy(xpath="//h3[contains(text(),'Yeah , you have added a visit')]")
	WebElement addedVisit;
	@FindBy(xpath ="//h3[contains(text(),'Yeah , you have added a visit')]//following-sibling::button")
	WebElement visitCloseBtn;
	@FindBy(xpath = "//div[@id='static-modal']//span[contains(text(),'Special characters are not allowed')]")
	WebElement specialChar;

	/*export csv*/

	@FindBy(xpath ="//button[contains(text(),'Select...')][1]")
	WebElement empSelct;
	@FindBy(xpath="//div[contains(text(),'Manager 1')]")
	WebElement empSelected;
	@FindBy(xpath ="//a[@download='visitLogs-visits.csv' and contains(text(),'Export CSV')]")
	WebElement exportData;

	/*Add Contact Person*/
	@FindBy(id = "name")
	WebElement contName;	
	@FindBy(id = "designation")
	WebElement cont_Designation;
	@FindBy(xpath="//input[@id='email' and @placeholder='Email Id']")	
	WebElement cont_email;
	@FindBy(xpath ="//div[contains(text(),'Phone')]//following-sibling::input")
	WebElement cont_number;
	//@FindBy(id = "(//button[contains(text(),'Submit')])[3]")
	//@FindBy(xpath = " (//div[@id='static-modal']//div[11]/button[contains(text(),'Submit')])[2]")
	@FindBy(xpath ="//div[@id='static-modal']/div/div/div[3]/button[1]")
	WebElement cont_submitBtn;
	@FindBy(xpath = "(//button[contains(text(),'Cancel')])[4]")
	WebElement cont_cancelBtn;
	@FindBy(xpath = "//h3[contains(text(),'Thank you for adding new contact person')]//following-sibling::button")
	WebElement cont_CloseBtn;

	String rsltMsg="";
	String duplicateRslt="";
	String invaldDataRslt="";
	String emptyfldrslt="";

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

	public String getDashbord() {
		wait.until(ExpectedConditions.textToBePresentInElement(dashbrd, dashbrd.getText()));
		String dashbrd_rslt=dashbrd.getText();
		return dashbrd_rslt;
	}

	public String addVisitForm(String institute, String emp, String date1, String visitPurps,String contPersn,String adNote, String discTopic) {
		System.out.println("new visit");
		wait.until(ExpectedConditions.visibilityOf(visitLogs));
		visitLogs.click();
		wait.until(ExpectedConditions.elementToBeClickable(addVstBtn));
		addVstBtn.click();

		wait.until(ExpectedConditions.visibilityOf(sel_Institution));
		sel_Institution.sendKeys(institute);	
		sel_Institution.sendKeys(Keys.RETURN);

		System.out.println("emp"+emp);
		sel_employee.clear();
		wait.until(ExpectedConditions.visibilityOf(sel_employee));		
		sel_employee.sendKeys(emp);		
		sel_employee.sendKeys(Keys.RETURN);

		//		wait.until(ExpectedConditions.elementToBeClickable(setDate));
		//		setDate.clear();
		//		setDate.click();
		//		setDate.sendKeys("30-06-2024"+" "+"T1030");
		//		setDate.sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.elementToBeClickable(setDate));		
		setDate.sendKeys(date1);
		setDate.sendKeys(Keys.TAB);
		setDate.sendKeys("14:45");
		setDate.sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.elementToBeClickable(purpose));
		purpose.sendKeys(visitPurps);

		System.out.println("contPersn"+contPersn);
		wait.until(ExpectedConditions.elementToBeClickable(cont_person));
		cont_person.sendKeys(contPersn);
		cont_person.sendKeys(Keys.RETURN);

		/* Validate additional note field*/	

		Pattern p = Pattern.compile("\\W");
		Matcher m = p.matcher(adNote);
		if (m.find()) {
			System.out.println("Invalid character in the field");
		}
		System.out.println("valid");


		wait.until(ExpectedConditions.elementToBeClickable(additionalNotes));
		additionalNotes.sendKeys(adNote);

		wait.until(ExpectedConditions.elementToBeClickable(discnTopic));
		discnTopic.sendKeys(discTopic);	
		return "success";
	}

	public String addNewVisit() {
		addVisitForm("COT Thalassery", "Associate 1","5-07-2024","Test","Vinod (HoD)","TestAddNote","Test Disc topic");
		if(vistSubmitBtn.isEnabled()) {
			Actions actions = new Actions(driver);
			actions.moveToElement(vistSubmitBtn).click().perform();	
			wait.until(ExpectedConditions.visibilityOf(addedVisit));
			rsltMsg=addedVisit.getText();
			wait.until(ExpectedConditions.elementToBeClickable(visitCloseBtn));
			visitCloseBtn.click();
		}
		else {
			wait.until(ExpectedConditions.elementToBeClickable(adVistCancel));
			adVistCancel.click();
		}
		return rsltMsg ;
	}


	public String duplicateVisitEntry() {
		addVisitForm("COT Thalassery", "Associate 1","5-07-2024","Test","Vinod (HoD","TestAddNote","Test Disc topic");
		if(vistSubmitBtn.isEnabled()) {			
			Actions actions = new Actions(driver);
			actions.moveToElement(vistSubmitBtn).click().perform();
		}
		//wait.until(ExpectedConditions.visibilityOf(visitScheduld));
		duplicateRslt="Visit already scheduled";
		System.out.println("11");		
		wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
		closeBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(adVistCancel));
		adVistCancel.click();
		return duplicateRslt;

	}

	public String invalidDataFldAdVisit() {
		addVisitForm("COT Thalassery", "Associate 1","5-07-2024","Test","Arshad T (PC)","@3$","Test Disc topic");
		if(vistSubmitBtn.isEnabled()) {
			Actions actions = new Actions(driver);
			actions.moveToElement(vistSubmitBtn).click().perform();	
		}
		wait.until(ExpectedConditions.visibilityOf(specialChar));		
		invaldDataRslt=specialChar.getText();
		wait.until(ExpectedConditions.elementToBeClickable(adVistCancel));
		adVistCancel.click();
		return invaldDataRslt;
	}

	public String emptyFldAdVisit() {		
		addVisitForm("", "Associate 1","5-07-2024","Test","Arshad T (PC)","TestAddNote","Test Disc topic");
		if(vistSubmitBtn.isEnabled()) {
			Actions actions = new Actions(driver);
			actions.moveToElement(vistSubmitBtn).click().perform();	
		}
		else {
			wait.until(ExpectedConditions.elementToBeClickable(adVistCancel));
			adVistCancel.click();
		}
		wait.until(ExpectedConditions.visibilityOf(emptyFldInstitut));
		emptyfldrslt=emptyFldInstitut.getText();

		return emptyfldrslt;

	}

	public String addNewContactPersn(String institute, String emp, String date1, String visitPurps,String contPersn,String adNote, String discTopic ) {

		System.out.println("new visit1");
		wait.until(ExpectedConditions.visibilityOf(visitLogs));
		visitLogs.click();
		wait.until(ExpectedConditions.elementToBeClickable(addVstBtn));
		addVstBtn.click();

		wait.until(ExpectedConditions.visibilityOf(sel_Institution));
		sel_Institution.sendKeys(institute);	
		sel_Institution.sendKeys(Keys.RETURN);

		System.out.println("emp"+emp);
		sel_employee.clear();
		wait.until(ExpectedConditions.visibilityOf(sel_employee));			
		sel_employee.sendKeys(emp);		
		sel_employee.sendKeys(Keys.RETURN);

		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(setDate));
		 * setDate.clear(); setDate.click(); setDate.sendKeys("30-06-2024"+" "+"T1030");
		 * setDate.sendKeys(Keys.ENTER)
		 */;

		 wait.until(ExpectedConditions.elementToBeClickable(setDate));		
		 setDate.sendKeys(date1);
		 setDate.sendKeys(Keys.TAB);
		 setDate.sendKeys("14:45");
		 setDate.sendKeys(Keys.ENTER);

		 wait.until(ExpectedConditions.elementToBeClickable(purpose));
		 purpose.sendKeys(visitPurps);

		 if(contPersn.isEmpty()) {			
			 wait.until(ExpectedConditions.elementToBeClickable(addContPerson));
			 Actions actions = new Actions(driver);
			 actions.moveToElement(addContPerson).click().perform();	
			 System.out.println("12");
			 contPersn=addContact();			

		 }

		 wait.until(ExpectedConditions.elementToBeClickable(cont_person));
		 cont_person.sendKeys(contPersn);
		 cont_person.sendKeys(Keys.RETURN);
		 wait.until(ExpectedConditions.elementToBeClickable(additionalNotes));
		 additionalNotes.sendKeys(adNote);
		 wait.until(ExpectedConditions.elementToBeClickable(discnTopic));
		 discnTopic.sendKeys(discTopic);
		 wait.until(ExpectedConditions.elementToBeClickable(vistSubmitBtn));		 
		 if(vistSubmitBtn.isEnabled()) {
			 Actions actions = new Actions(driver);
			 actions.moveToElement(vistSubmitBtn).click().perform();	
			 wait.until(ExpectedConditions.visibilityOf(addedVisit));
			 rsltMsg=addedVisit.getText();
			 wait.until(ExpectedConditions.elementToBeClickable(visitCloseBtn));
			 visitCloseBtn.click();
		 }
		 else {
			 wait.until(ExpectedConditions.elementToBeClickable(adVistCancel));
			 adVistCancel.click();
		 }
		 return rsltMsg;
	}

	public String addContact() {
		wait.until(ExpectedConditions.elementToBeClickable(contName));
		String contPersn ="Ram";
		contName.sendKeys(contPersn);		
		wait.until(ExpectedConditions.elementToBeClickable(cont_Designation));
		cont_Designation.sendKeys("HoD");		
		wait.until(ExpectedConditions.elementToBeClickable(cont_email));
		cont_email.sendKeys("Test@gmail.com");		
		wait.until(ExpectedConditions.elementToBeClickable(cont_number));
		cont_number.click();
		cont_number.sendKeys("1234567891");
		wait.until(ExpectedConditions.elementToBeClickable(cont_submitBtn));
		//cont_submitBtn.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(cont_submitBtn).click().perform();		
		wait.until(ExpectedConditions.elementToBeClickable(cont_CloseBtn));
		cont_CloseBtn.click();
		return contPersn;
	}

	public void exportVisitLogs() {
		wait.until(ExpectedConditions.visibilityOf(visitLogs));
		visitLogs.click();
		wait.until(ExpectedConditions.elementToBeClickable(empSelct));
		empSelct.click();
		wait.until(ExpectedConditions.visibilityOf(empSelected));
		empSelected.click();
		wait.until(ExpectedConditions.visibilityOf(exportData));
		Actions actions = new Actions(driver);
		actions.moveToElement(exportData).click().perform();		

	}


}
