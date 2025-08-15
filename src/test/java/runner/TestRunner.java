package runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.TestContextSetup;

@CucumberOptions(features = "src/test/java/feature", glue = { "stepDefinations", "hooks", "dataProvider" }, plugin = {
		"pretty"
		 }, monochrome = true, tags = " @cart or @login", dryRun = false)
public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeClass
	@Parameters("env")
	public void setEnvirnment(String env) {
     System.out.println("this is for env variable");
		TestContextSetup.setEnv(env);
	}

	@SuppressWarnings("deprecation")
	@BeforeMethod
	@Parameters("browser")
	public void setBrowser(String browser) {
		System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Browser: " + browser);
		utils.TestContextSetup.setBrowser(browser);
	}

	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
