package utils;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductPage;
import baseclass.BaseClass;

public class TestContextSetup {
    public WebDriver driver;
    public ProductPage productPage;
    public LoginPage loginPage;

    public TestContextSetup() {
        driver = BaseClass.getDriver();  // Adjust if you're managing WebDriver differently
        loginPage = new LoginPage();
        productPage = new ProductPage();
    }
}
