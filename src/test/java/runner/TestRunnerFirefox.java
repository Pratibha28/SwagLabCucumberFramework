package runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(  features = "src/test/java/feature",
glue = {"stepDefinations", "hooks","dataProvider"},  // include 'hooks' here
plugin = {"pretty", "html:target/cucumber.html"},
monochrome = true,
tags = "@login",
dryRun = false)
public class TestRunnerFirefox extends AbstractTestNGCucumberTests {
	@BeforeClass
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

