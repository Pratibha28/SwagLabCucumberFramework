package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(  features = "src/test/java/feature",
glue = {"stepDefinations", "hooks","dataProvider"},  // include 'hooks' here
plugin = {"pretty", "html:target/cucumber.html"},
monochrome = true,
tags = "@product")
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}

