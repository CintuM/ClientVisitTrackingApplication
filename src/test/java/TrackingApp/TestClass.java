package TrackingApp;


import org.ictak.constants.AutomationConstant;
import org.ictak.pages.DashboardPage;
import org.ictak.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends TestBase{

	String actualResult=null;
	Boolean actualResults;
	LoginPage login;
	DashboardPage db;


	@Test
	public void TC_CVT_1_1_1() {
		System.out.println("Running TC_CVT_1_1_1");
		login=new LoginPage(driver);
		actualResult = login.safeLanding();
		Assert.assertEquals(actualResult, AutomationConstant.LoadPageMsg);
	}

	@Test
	public void TC_CVT_1_1_3() {
		System.out.println("Running TC_CVT_1_1_3");
		login=new LoginPage(driver);
		login.setName(prop.getProperty("useridAssociateC"));
		login.setPwd(prop.getProperty("pwdAssociateC"));
		actualResult = login.login();
		waitabit();
		login.logOut();
		Assert.assertEquals(actualResult, AutomationConstant.ExpectedHome);
	}

	@Test
	public void TC_CVT_1_1_2_4() {
		System.out.println("Running TC_CVT_1_1_2_4");
		waitabit();
		login=new LoginPage(driver);
		login.setName(prop.getProperty("useridManagerC"));
		login.setPwd(prop.getProperty("pwdManagerC"));
		actualResult = login.login();
		waitabit();
		login.logOut();
		Assert.assertEquals(actualResult, AutomationConstant.ExpectedHome);
	}

	@Test
	public void TC_CVT_1_1_5() {
		System.out.println("Running TC_CVT_1_1_5");
		login=new LoginPage(driver);
		login.setName(prop.getProperty("useridManagerC"));
		login.setPwd(prop.getProperty("invalidpwdAssociateC"));
		Assert.assertEquals(login.loginInvalid("invalid"), true);
	}

	@Test
	public void TC_CVT_1_1_6() {
		System.out.println("Running TC_CVT_1_1_6");
		login=new LoginPage(driver);
		driver.navigate().refresh();
		login.setName(prop.getProperty("useridManagerC"));
		login.setName("");
		Assert.assertEquals(login.loginInvalid("blank"), true);
	}


	@Test
	public void TC_CVT_1_2_1() {
		System.out.println("Running TC_CVT_1_2_1");
		login=new LoginPage(driver);
		login.setName(prop.getProperty("useridManagerC"));
		login.setPwd(prop.getProperty("pwdManagerC"));
		login.login();
		//		waitabit();
		db = new DashboardPage(driver);
		actualResults=db.compareAppointmentNumber();
		login.logOut();
		Assert.assertEquals(actualResults,true);
	}


	@Test
	public void TC_CVT_1_2_9(){
		System.out.println("Running TC_CVT_1_2_9");
		login=new LoginPage(driver);
		db = new DashboardPage(driver);
		login.setName(prop.getProperty("useridManagerC"));
		login.setPwd(prop.getProperty("pwdManagerC"));
		login.login();
		waitabit();	
		actualResults=db.deleteVisit();
		login.logOut();	
		Assert.assertEquals(actualResults, true);		
	}

	@Test
	public void TC_CVT_1_2_6_7_8(){
		System.out.println("Running TC_CVT_1_2_6_7_8");
		login=new LoginPage(driver);
		db = new DashboardPage(driver);
		login.setName(prop.getProperty("useridManagerC"));
		login.setPwd(prop.getProperty("pwdManagerC"));
		login.login();
		waitabit();	
		actualResults=db.updateNewVisit();
		login.logOut();	
		Assert.assertEquals(actualResults, true);

	}

	@Test
	public void TC_CVT_1_2_3_5(){
		System.out.println("Running TC_CVT_1_2_3_5");
		login=new LoginPage(driver);
		db = new DashboardPage(driver);
		login.setName(prop.getProperty("useridManagerC"));
		login.setPwd(prop.getProperty("pwdManagerC"));
		login.login();
		waitabit();	
		actualResults=db.viewNewVisit();
		login.logOut();	
		Assert.assertEquals(actualResults, true);	
	}

	@Test
	public void TC_CVT_1_2_2() throws InterruptedException {
		System.out.println("Running TC_CVT_1_2_2");
		login=new LoginPage(driver);
		db = new DashboardPage(driver);
		login.setName(prop.getProperty("useridManagerC"));
		login.setPwd(prop.getProperty("pwdManagerC"));
		login.login();
		actualResults=db.addNewVisit("ICTAK Koratty","Associate 1","Testing","Arun (developer)","TestingNote","31-12-2024");
		login.logOut();	
		Assert.assertEquals(actualResults, true);
	}



	@Test
	public void TC_CVT_1_21_4() throws InterruptedException {
		System.out.println("Running TC_CVT_1_2_4");
		login=new LoginPage(driver);
		db = new DashboardPage(driver);
		login.setName(prop.getProperty("useridManagerC"));
		login.setPwd(prop.getProperty("pwdManagerC"));
		login.login();
		System.out.println("logged in for blank check");
		actualResults=db.addNewVisitBlank("ICTAK Koratty","Associate 1","Testing","TestingNote");
		System.out.println("about to logout");
		login.logOut();	
		System.out.println("logged out");
		Assert.assertEquals(actualResults, true);
	}

	@Test
	public void TC_CVT_1_2_10() {
		System.out.println("Running TC_CVT_1_2_10");
		login=new LoginPage(driver);
		db = new DashboardPage(driver);
		login.setName(prop.getProperty("useridManagerC"));
		login.setPwd(prop.getProperty("pwdManagerC"));
		login.login();
		actualResults=db.completedVisits();
		login.logOut();	
		Assert.assertEquals(actualResults, true);
	} 

	@Test
	public void TC_CVT_1_2_11() throws InterruptedException {
		System.out.println("Running TC_CVT_1_2_11");
		login=new LoginPage(driver);
		db = new DashboardPage(driver);
		login.setName(prop.getProperty("useridManagerC"));
		login.setPwd(prop.getProperty("pwdManagerC"));
		login.login();
		actualResults = db.downloadCSV();
		login.logOut();	
		Assert.assertEquals(actualResults, true);
	} 

}
