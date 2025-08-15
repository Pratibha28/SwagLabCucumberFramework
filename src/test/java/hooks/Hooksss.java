package hooks;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.testng.annotations.Parameters;

import dataProvider.DataProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooksss extends baseclass.BaseClass {
	/*
	 * private static ThreadLocal<Map<String, String>> currentCreds = new
	 * ThreadLocal<>();
	 * 
	 * 
	 * @Before public void setUp(Scenario scenario) throws Exception { // 1) Load
	 * config loadConfig();
	 * 
	 * 
	 * String[] browsers = prop.getProperty("browser","firefox").split(",");
	 * 
	 * for(int i=0;i<browsers.length;i++) {
	 * 
	 * System.out.println(browsers[i]); }
	 * 
	 * // Loop through each browser for (String browser : browsers) { browser =
	 * browser.trim(); // Remove any leading/trailing spaces
	 * System.out.println("===== Running tests on: " + browser + " =====");
	 * 
	 * // 3) Set browser for this iteration System.setProperty("browser", browser);
	 * 
	 * // 4) Launch the app for the current browser launchApp(browser);
	 * 
	 * // 5) Read ALL credential rows
	 * 
	 * Map<String, String> data = null; if
	 * (scenario.getSourceTagNames().contains("@userCredentials")) { Object[][]
	 * allCreds = new DataProvider().getCredential();
	 * 
	 * // 6) Pick one using scenario hash int idx =
	 * Math.abs(scenario.getName().hashCode()) % allCreds.length;
	 * 
	 * data = (Map<String, String>) allCreds[idx][0]; // 7) Store into ThreadLocal
	 * 
	 * }else if(scenario.getSourceTagNames().contains("@useInvalidCredentials")) {
	 * Object[][] profileData = new DataProvider().getInValidCredential(); int idx =
	 * Math.abs(scenario.getName().hashCode()) % profileData.length; data =
	 * (Map<String, String>) profileData[idx][0]; }
	 * 
	 * 
	 * if (data != null) { currentCreds.set(data); } else {
	 * System.err.println("No data provider matched for scenario: " +
	 * scenario.getName()); } // Run the test for this browser (if necessary: you
	 * could trigger a re-run or just execute the scenario here) // This part is
	 * tricky because you would typically rely on Cucumber to execute a single test,
	 * but you can execute the logic for each browser.
	 * 
	 * // For this current flow, each iteration will run the test on the selected
	 * browser. } }
	 * 
	 * 
	 * 
	 * 
	 * @Before
	 * 
	 * public void setUp(Scenario scenario) throws Exception { String browser =
	 * utils.TestContextSetup.getBrowser(); System.out.println("browser: "
	 * +browser);
	 * 
	 * if (browser == null || browser.trim().isEmpty()) {
	 * System.out.println("No browser provided. Using default: chrome"); // browser
	 * = "chrome"; }
	 * 
	 * System.out.println("Running test in browser: " + browser);
	 * launchApp(browser);
	 * 
	 * // 5) Read ALL credential rows
	 * 
	 * Map<String, String> data = null; if
	 * (scenario.getSourceTagNames().contains("@useCredentials")) { Object[][]
	 * allCreds = new DataProvider().getCredential();
	 * 
	 * // 6) Pick one using scenario hash int idx =
	 * Math.abs(scenario.getName().hashCode()) % allCreds.length;
	 * 
	 * data = (Map<String, String>) allCreds[idx][0]; // 7) Store into ThreadLocal
	 * 
	 * }else if(scenario.getSourceTagNames().contains("@useInvalidCredentials")) {
	 * Object[][] profileData = new DataProvider().getInValidCredential(); int idx =
	 * Math.abs(scenario.getName().hashCode()) % profileData.length; data =
	 * (Map<String, String>) profileData[idx][0]; }
	 * 
	 * 
	 * if (data != null) { currentCreds.set(data); } else {
	 * System.err.println("No data provider matched for scenario: " +
	 * scenario.getName()); } // Run the test for this browser (if necessary: you
	 * could trigger a re-run or just execute the scenario here) // This part is
	 * tricky because you would typically rely on Cucumber to execute a single test,
	 * but you can execute the logic for each browser.
	 * 
	 * // For this current flow, each iteration will run the test on the selected
	 * browser. } //}
	 * 
	 * @After public void tearDown() { // 8) Close the browser after all browsers
	 * have run their tests if (getDriver() != null) { getDriver().quit();
	 * utils.TestContextSetup.clear(); } }
	 * 
	 *//** Helper for step defs to fetch the current scenario’s data *//*
																		 * public static String get(String key) { return
																		 * currentCreds.get().get(key); }
																		 * 
																		 * private String
																		 * getSheetNameFromTags(Set<String> tags) { for
																		 * (String tag : tags) { if
																		 * (tag.startsWith("@sheet=")) { return
																		 * tag.split("=")[1]; } } return null; }
																		 */
}