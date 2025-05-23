package baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;



public class BaseClass {

//	Write a Test Script to automate www.saucedemo.com using Page Object Model
//	● Create Maven Project
//	● Use TestNG
//	● Create Repository in Class File

	public static Properties prop;
	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

@BeforeSuite
	public void loadConfig() throws IOException {
	System.out.println("CONFIG LOADED");

		try {
			prop= new Properties();

			FileInputStream fis = new FileInputStream("G:\\eclipse-workplace2025\\NewSwagLabsCucumbers\\Resources\\global.properties");
		    prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	public void launchApp(String BrowserType) {

		if (BrowserType.equalsIgnoreCase("chrome")) {
			// ChromeOptions setup to disable password alerts
			driver.set(new ChromeDriver());
		} else if (BrowserType.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
		}
		// Maximize the screen
		getDriver().manage().window().maximize();
		// Delete all the cookies
		getDriver().manage().deleteAllCookies();
		// Implicit TimeOuts
		//getDriver().manage().timeouts()
				//.implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));

		String url = prop.getProperty("url");
		

		// Launching the URL
		getDriver().get(prop.getProperty("url"));

	}

	





}
