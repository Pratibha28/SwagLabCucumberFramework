package runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(  features =  "@target/rerun.txt",
glue = {"stepDefinations", "hooks","dataProvider"},  // include 'hooks' here
plugin = {"pretty", "html:target/cucumber.html",
		"rerun:target/rerun.txt"
		},
monochrome = true,

tags = "@flaky",
dryRun = false)
public class FlakyTestRunner extends AbstractTestNGCucumberTests {
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

