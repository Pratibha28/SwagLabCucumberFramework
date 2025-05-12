package baseclass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	@BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setBrowserParam(String browser) {
        System.setProperty("browser", browser);
    }
}
