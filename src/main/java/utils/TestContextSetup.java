package utils;

import org.openqa.selenium.WebDriver;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductDetailPage;
import pages.ProductPage;
import baseclass.BaseClass;

public class TestContextSetup {
	private final ScenarioContext scenarioContext = new ScenarioContext();
	private static ThreadLocal<String> browser = new ThreadLocal<>();
	private static ThreadLocal<String> envVariable = new ThreadLocal<>();

	public WebDriver driver;
	public ProductPage productPage;
	public LoginPage loginPage;
	public ProductDetailPage productDetailpage;
	public CartPage cartPage;

	public TestContextSetup() {
		driver = BaseClass.getDriver(); // Adjust if you're managing WebDriver differently
		loginPage = new LoginPage();
		productPage = new ProductPage();
		productDetailpage = new ProductDetailPage();
		cartPage = new CartPage();
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

	public static void setBrowser(String browserName) {
		browser.set(browserName);
	}

	public static String getBrowser() {
		return browser.get();
	}
	
	public static void setEnv(String env) {
		
		envVariable.set(env);
	}

	public static String getEnv() {
		
		return envVariable.get();
	}

	public static void clear() {
		browser.remove();
	}
}
