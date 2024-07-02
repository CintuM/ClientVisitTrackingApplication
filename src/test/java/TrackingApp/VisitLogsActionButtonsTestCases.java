package TrackingApp;

import org.ictak.pages.VisitLogsActionButtons;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VisitLogsActionButtonsTestCases extends TestBase {
	

	VisitLogsActionButtons action;

	@BeforeClass
	public void setUp() {
		action = new VisitLogsActionButtons(driver);
	}

	@Test(priority=0)
	public void TC_1_2(){
		action.userName("manager1@ictkerala.org");
		action.password("@manager#952");
		action.loginBtn();
		action.visitLogsPage();
		action.deleteActionButton();
		action.viewDetailsActionButton();
		action.viewDetailsCloseButton();
		action.updateActionButton();

	}
	

}
