package TrackingApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	WebDriver driver;
	Properties prop=null;


	public void loadProp() throws IOException {
		prop = new Properties();
		 InputStream fileip = getClass().getResourceAsStream("/config.properties");
			new BufferedReader(new InputStreamReader(fileip));
			prop.load(fileip);
	}
	
	@BeforeSuite
	public void setup() throws IOException{
		loadProp();
//		System.setProperty("webdriver.chrome.driver", "path for chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
		this.driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void teardown() {
//		driver.quit();
	}
	
	public void waitabit() {
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));	
	}
}
