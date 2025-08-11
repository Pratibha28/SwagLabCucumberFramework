package stepDefinations;

import org.testng.Assert;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import baseclass.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class CartPageStepDefination extends BaseClass {
	TestContextSetup testContext;

	public CartPageStepDefination(TestContextSetup testContext) {
		this.testContext = testContext;

	}

	// scenario 1
	@When("open cart page from product detail")
	public void open_cart_page_from_product_detail() {
		testContext.productDetailpage.clickOnCart();
	}

	@Then("Validate that cart page is get open")
	public void validate_that_cart_page_is_get_open() {
		Boolean flag = testContext.cartPage.validateCartPage();
		Assert.assertTrue(flag);
	}

	// Scenario 2
	@Then("the product title and price in the cart should match the selected product")
	public void the_product_title_and_price_in_the_cart_should_match_the_selected_product() {
		String expectedTitle = testContext.getScenarioContext().get("productTitleProductDetail", String.class);
		String expectedPrice = testContext.getScenarioContext().get("productPriceProductDetail", String.class);
		
		String productTitleCart = testContext.cartPage.validate_Product_Title();
        String productPriceCart = testContext.cartPage.validate_Product_Price();
        
        //Assert.assertEquals(expectedTitle, productTitleCart);
	}
}
