package TrackingApp;

import java.io.File;

import org.ictak.constants.AutomationConstant;
import org.ictak.pages.AddVisitPage;
import org.ictak.pages.MilestonePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MilestoneTC extends TestBase{
	MilestonePage milestonepage;
	AddVisitPage  addvisitObj=null;
	String actualResult ="";


	@BeforeClass
	public void classSetup() {
		milestonepage = new MilestonePage(driver);
		addvisitObj = new AddVisitPage(driver);

	}	
	@Test(priority = 1)
	public void milestoneFeature() throws InterruptedException {
		driver.navigate().refresh();
		System.out.println("Test Case: TC_CVT_1.3.1");
		driver.navigate().refresh();		
		milestonepage.userName(prop.getProperty("manager_uname"));
		milestonepage.password(prop.getProperty("manager_psw"));
		addvisitObj.loginBtn();
		actualResult = milestonepage.getDashbdMileston();		
		Assert.assertEquals(actualResult, AutomationConstant.DashBrdMilestones);	
		System.out.println(actualResult+": Valid Login completed");
		milestonepage.selectMilestones();
		//downloadCSV();

	}
	@Test(priority = 2)
	public void downloadCSV() throws InterruptedException {
		System.out.println("Test Case: TC_CVT_1.3.2");
		System.out.println("download csv");					
		milestonepage.exportCSV();		
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
		milestonepage.logOut();

	}


}
