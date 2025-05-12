package runner;

import io.cucumber.core.cli.Main;

import java.io.FileInputStream;
import java.util.Properties;

public class MainRunner {
    public static void main(String[] args) throws Exception {
        // Load config.properties
        Properties prop = new Properties();
        prop.load(new FileInputStream("config/config.properties"));

        String[] browsers = prop.getProperty("browser", "chrome").split(",");

        for (String browser : browsers) {
            browser = browser.trim();
            System.out.println("===== Running tests on: " + browser + " =====");

            // Set system property for Hooks to read
            System.setProperty("browser", browser);

            // Run Cucumber CLI (invokes your step definitions/hooks normally)
            Main.run(new String[]{
                "--plugin", "pretty",
                "--plugin", "html:target/cucumber-reports/" + browser,
                "--glue", "hooks",
                "--glue", "stepDefinitions",
                "src/test/resources/features"
            }, Thread.currentThread().getContextClassLoader());
        }
    }
}
