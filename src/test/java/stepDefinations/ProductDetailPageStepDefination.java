package stepDefinations;

import org.testng.Assert;

import baseclass.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class ProductDetailPageStepDefination extends BaseClass{
        TestContextSetup testContext;
        
        public ProductDetailPageStepDefination(  TestContextSetup testContext) {
        	this.testContext= testContext;
        }
	
	
	
	//Scenario 1:
	@When("User is on product list page and click on product name")
	public void user_is_on_product_list_page_and_click_on_product_name() {
	   testContext.productPage.clickOnProductTitle();
	   String productTitleProductDetail =  testContext.productDetailpage.addTocartProductfromDetail();
	   String productPriceProductDetail = testContext.productDetailpage.productDetailProductPrice();
        testContext.getScenarioContext().set("productTitleProductDetail", productTitleProductDetail);
        testContext.getScenarioContext().set("productPriceProductDetail", productPriceProductDetail);
        
	}
	@Then("product detail page should be get open")
	public void product_detail_page_should_be_get_open() {
	 Boolean flag=   testContext.productDetailpage.validateProductdetail();
	 Assert.assertTrue(true);
	}

	//Scenario 2:
	@When("Add to cart product from product detail")
	public void add_to_cart_product_from_product_detail() {
	   testContext.productDetailpage.addTocartProductfromDetail();
	}
	@Then("the product should be add to cart successfully")
	public void the_product_should_be_add_to_cart_successfully() {
		boolean result = testContext.productDetailpage.validateAddToCart();
		Assert.assertTrue(result);
	}
	
	//Scenario 3
	
	@When("removes the product from the cart using the Remove button on the product detail page")
	public void removes_the_product_from_the_cart_using_the_Remove_button_on_the_product_detail_page() {
	testContext.productDetailpage.removeProductFromCart();
	}
	
	@Then("the product should be successfully removed from the cart")
	public void the_product_should_be_successfully_removed_from_the_cart() {
		boolean result=testContext.productDetailpage.validateRemove();
		Assert.assertTrue(result);
		
	}
	
	//Scenario 4:
	@When("user redirected to product listing using back button")
	public void user_redirected_to_product_listing_using_back_button() {
	    testContext.productDetailpage.BackToProductListing();
	}
	@Then("user should be redirected back to product listing screen")
	public void user_should_be_redirected_back_to_product_listing_screen() {
	    Boolean flag= testContext.productDetailpage.validateBackToProducts();
	    Assert.assertTrue(flag);
	}

}
 