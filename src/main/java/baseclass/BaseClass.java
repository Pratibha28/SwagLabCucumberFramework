package baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseClass {
	String mavenEnv = System.getProperty("env");
//	Write a Test Script to automate www.saucedemo.com using Page Object Model
//	● Create Maven Project
//	● Use TestNG
//	● Create Repository in Class File
public BaseClass() {
	
	try {
		loadConfig(mavenEnv);
		System.out.println("@@@@0"+mavenEnv);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public static Properties prop;
	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	@BeforeSuite
	public void loadConfig(String finalEnvs) throws IOException {

		
		String finalEnv = (mavenEnv != null && !mavenEnv.isEmpty()) ? mavenEnv : finalEnvs;

		if (finalEnv == null || finalEnv.isEmpty()) {
			finalEnv = "qa"; // default fallback
		}

		System.out.println("✅ Environment Loaded: " + finalEnv);
		System.out.println("CONFIG LOADED" + finalEnv);

		prop = ConfigReader.loadProperties(finalEnv);

	}

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	public void launchApp(String BrowserType) {

		if (BrowserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (BrowserType.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (BrowserType.equalsIgnoreCase("IE")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		// getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		getDriver().get(ConfigReader.getProperties("baseURL"));
	}

}
