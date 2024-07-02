package TrackingApp;


import org.ictak.constants.AutomationConstant;
import org.ictak.pages.NewInstitution;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewInstitutionTestCases extends TestBase {

	NewInstitution newInst;

	@BeforeClass
	public void setUp() {
		newInst = new NewInstitution(driver);
	}
	//--------------------------------------------------valid test cases----------------------------------
	@Test(priority=0)
	public void TC_2_2() throws InterruptedException  {
		newInst.userName("manager1@ictkerala.org");
		newInst.password("@manager#952");
		newInst.loginBtn();
		newInst.visitLogsPage();
		String vistLogHeading = newInst.vistLogsHeading();
		Assert.assertTrue(vistLogHeading.contains(AutomationConstant.EXPECTED_VISIT_LOGS_HEADING), "Visit Logs heading is not present on the page.");
		newInst.newInstBtn();
		newInst.instituteType("Government Departments");
		newInst.instituteName("College of Engineering Punaloor");
		newInst.instituteEmail("antony@gmail.com");
		newInst.institutePlace("Punaloor");
		newInst.instituteState("Kerala");
		newInst.instituteDistrict("Kollam");
		newInst.submitButton();
		newInst.closePopupButton();
		String heading = newInst.closePopupHeading();
		Assert.assertTrue(heading.contains(AutomationConstant.EXPECTED_CLOSE_POPUP_HEADING), "Registration succesfull  is not present on the popup.");
	}
	//--------------------------------------------------blank test cases----------------------------------
	@Test(priority=1)
	public void TC_2_3() {
		newInst.instituteType("");
		newInst.instituteName("");
		newInst.instituteEmail("");
		newInst.institutePlace("");
		newInst.instituteState("");
		newInst.instituteDistrict("");
		newInst.submitButton();
		String vistLogHeading = newInst.vistLogsHeading();
		Assert.assertTrue(vistLogHeading.contains(AutomationConstant.EXPECTED_BLANK_REQUIRED_HEADING), "Required alert text is not present on the form field.");
		
	}
	//--------------------------------------------------duplication testcase----------------------------------
	@Test(priority=2)
	public void TC_2_4() {
		newInst.instituteType("Government Departments");
		newInst.instituteName("College of Engineering Punaloor");
		newInst.instituteEmail("antony@gmail.com");
		newInst.institutePlace("Punaloor");
		newInst.instituteState("Kerala");
		newInst.instituteDistrict("Kollam");
		newInst.submitButton();
		newInst.closePopupButton();
		String heading = newInst.alertPopupText();
		Assert.assertTrue(heading.contains(AutomationConstant.EXPECTED_ALERT_POPUP_TEXT), "already exisit alert popup is not showing.");
	}
}
