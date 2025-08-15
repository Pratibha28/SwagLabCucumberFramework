package hooks;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import dataProvider.DataProvider;
import dataProvider.DataProviders;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;
import baseclass.BaseClass;

public class Hooks extends BaseClass {
	private static ThreadLocal<Map<String, String>> currentCreds = new ThreadLocal<>();
    private static ThreadLocal<Map<String, String>> loginCreds = new ThreadLocal<>();
    
    @Before
    public void setUp(Scenario scenario) throws Exception {

        // ✅ Get env and browser from context
        String env = TestContextSetup.getEnv();
        if (env == null || env.trim().isEmpty()) {
        	System.out.println("env is not get from testng xml");
            env = "qa"; // default fallback
        }
        loadConfig(env);
    	
    	String browser = TestContextSetup.getBrowser();
        if (browser == null || browser.trim().isEmpty()) {
            browser = "chrome";
        }
        System.out.println("Running test in browser: " + browser);
        launchApp(browser);

        
        //get sheet tag from feature file and pass in dataprovider
        Collection<String> tags = scenario.getSourceTagNames();
        String featureSheet = getSheetNameFromTags(tags);

        // 1. Functional Sheet (Product, Cart, Checkout, etc.)
        if (featureSheet != null) {
            Object[][] sheetData = new DataProviders().loadSheetData(featureSheet);
            if (sheetData.length > 0) {
                @SuppressWarnings("unchecked")
                Map<String, String> featureData = (Map<String, String>) sheetData[0][0];  // just use first row
                currentCreds.set(featureData);
            } else {
                System.out.println("⚠️ Sheet '" + featureSheet + "' is empty.");
                currentCreds.set(null);
            }
        } else {
            System.out.println("ℹ️ No @sheet=... tag found. Skipping functional data load.");
            currentCreds.set(null);
        }

        // 2. Load login data from Credentials (optional fallback)
        Object[][] loginSheet = new DataProviders().loadSheetData("Credentials");
        if (loginSheet.length > 0) {
            @SuppressWarnings("unchecked")
            Map<String, String> loginData = (Map<String, String>) loginSheet[0][0];  // first login row
            loginCreds.set(loginData);
        } else {
            System.out.println("⚠️ No login data available in Credentials sheet.");
            loginCreds.set(null);
        }
        
        
    }
    
 // ✅ Used to get sheet name from tag which will sent to dataproviders
    private String getSheetNameFromTags(Collection<String> tags) {
        for (String tag : tags) {
            if (tag.startsWith("@sheet=")) {
                return tag.substring("@sheet=".length());
            }
        }
        return null;
    }
    
   
    
    
 // ✅ Unified getter for both functional and login data
    public static String get(String key) {
        if (currentCreds.get() != null && currentCreds.get().containsKey(key)) {
            return currentCreds.get().get(key);
        } else if (loginCreds.get() != null && loginCreds.get().containsKey(key)) {
            return loginCreds.get().get(key);
        } else {
            System.out.println("⚠️ Data not found for key: " + key);
            return null;
        }
    }
    
    @After
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
        currentCreds.remove();
        loginCreds.remove();
        TestContextSetup.clear();
    }

}
