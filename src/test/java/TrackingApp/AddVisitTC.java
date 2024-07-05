package TrackingApp;

import java.io.File;

import org.ictak.constants.AutomationConstant;
import org.ictak.pages.AddVisitPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AddVisitTC extends TestBase{
	AddVisitPage addVisitPage;
	String actualResult ="";


	@BeforeClass
	public void classSetup() {
		addVisitPage = new AddVisitPage(driver);		

	}
	@Test(priority = 1)
	public void validMngrLogin() throws InterruptedException {
		System.out.println("Test Case: TC_CVT_2.3.1");
		driver.navigate().refresh();		
		addVisitPage.userName(prop.getProperty("manager_uname"));
		addVisitPage.password(prop.getProperty("manager_psw"));
		addVisitPage.loginBtn();
		actualResult = addVisitPage.getDashbord();		
		Assert.assertEquals(actualResult, AutomationConstant.ExpectedHome);	
		System.out.println(actualResult+": Valid Login completed"); 

	}	
	@Test(priority = 2)
	public void addVisit() {
		System.out.println("Test Case: TC_CVT_2.3.2");
		driver.navigate().refresh();
		String addVisitRslt=addVisitPage.addNewVisit();
		System.out.println("visit log:"+addVisitRslt);
		Assert.assertEquals(addVisitRslt, AutomationConstant.AddedNewvisit);	
	}
	
	@Test(priority =3)
	public void duplicateAddVisit() {
		System.out.println("Test Case: TC_CVT_2.3.4");
		driver.navigate().refresh();
		String dupVisitRslt=addVisitPage.duplicateVisitEntry();
		System.out.println("dupVisitRslt"+dupVisitRslt);
		Assert.assertEquals(dupVisitRslt, AutomationConstant.VisitScheduled);
	}

	@Test(priority = 4)
	public void invalidDataAddVisit() {
		System.out.println("Test Case: TC_CVT_2.3.5 And TC_CVT_2.3.6");
		driver.navigate().refresh();
		String inVisitRslt=addVisitPage.invalidDataFldAdVisit();
		System.out.println("inVisitRslt"+inVisitRslt);
		Assert.assertEquals(inVisitRslt, AutomationConstant.invalidDataRslt);
	}
	
	@Test(priority = 5)
	public void emptyFldAddVisit() {
		System.out.println("Test Case: TC_CVT_2.3.3");
		driver.navigate().refresh();	
		String fldVisitRslt=addVisitPage.emptyFldAdVisit();		
		Assert.assertEquals(fldVisitRslt, AutomationConstant.EmptyFldAddInstitutn);	
		System.out.println(fldVisitRslt);
	}



	@Test(priority = 6)
	public void addContactPerson() {
		System.out.println("Test Case: TC_CVT_2.3.7");
		driver.navigate().refresh();
		String addContRslt=addVisitPage.addNewContactPersn("ITI vadakara", "Associate 1","7-07-2024","Test","","TestAddNote","Test Disc topic");
		System.out.println("visit log"+addContRslt);
		Assert.assertEquals(addContRslt, AutomationConstant.AddedNewvisit);

	}
	@Test(priority = 7)
	public void emptyFldAddContactPerson() {
		System.out.println("Test Case: TC_CVT_2.3.7");
		driver.navigate().refresh();
		String addContRslt=addVisitPage.addNewContactPersn("ITI vadakara", "Associate 1","7-07-2024","Test","","TestAddNote","Test Disc topic");
		System.out.println("visit log"+addContRslt);
		Assert.assertEquals(addContRslt, AutomationConstant.AddedNewvisit);

	}

	@Test(priority =7)
	public void visitLogsEexport() throws InterruptedException {
		System.out.println("Test Case: TC_CVT_2.1.2 and TC_CVT_2.1.3");
		driver.navigate().refresh();
		addVisitPage.exportVisitLogs();
		System.out.println("download csv");					
		addVisitPage.exportVisitLogs();		
		String downloadDir = System.getProperty("user.home") + "\\Downloads";
		String expectedFileName = "visit_data.csv";		
		File downloadedFile = new File(downloadDir + "/" + expectedFileName);
		int waitTime = 30; 
		int elapsedTime = 0;
		while (!downloadedFile.exists() && elapsedTime < waitTime) {
			Thread.sleep(1000);
			elapsedTime++;
		}

		if (downloadedFile.exists()) {
			System.out.println("File downloaded successfully: " + downloadedFile.getAbsolutePath());
		} else {
			System.out.println("Failed to download the file within the specified time.");
		}
		Assert.assertTrue(downloadedFile.exists(), "The file was  downloaded successfully.");
		addVisitPage.logOut();

	}






}
