package stepDefinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import baseclass.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;
import utils.TestContextSetup;

public class ProductPageStepDefination extends BaseClass {
	TestContextSetup testContext;

	List<WebElement> actualProductTitle;
	List<WebElement> actualProductprice;
	List<Comparable> actuallist;
	List<WebElement> descProductTitle;
	List<WebElement> allproductPrices;
	List<?> templist;
	List<WebElement> dscProductPrice;
	private boolean b;

	public ProductPageStepDefination(TestContextSetup testContext) {
		this.testContext = testContext;
	}
//Scenario 1
	@When("Get all the product name")

	public void get_all_the_product_name() {

		actualProductTitle = testContext.productPage.VerifyallProductTitle();
		System.out.println(actualProductTitle.size());

	}

	@Then("Validate all the product name")
	public void validate_all_the_product_name() {
		List<String> expectedProductTitle = new ArrayList<String>();
		String[] ProductListTitle = prop.getProperty("product").split(",");
		expectedProductTitle = Arrays.asList(ProductListTitle);

		for (int i = 0; i < expectedProductTitle.size(); i++) {

			Assert.assertEquals(actualProductTitle.get(i).getText(), expectedProductTitle.get(i));
		}
	}
	
	//Scenario 2

	@When("Get all the product price")
	public void get_all_the_product_price() {
		actualProductprice = testContext.productPage.getAllProductprice();
		System.out.println(actualProductprice.size());
	}

	@Then("Validate all the product price")
	public void validate_all_the_product_price() {
		List<String> expectedProductprice = new ArrayList<String>();
		String[] ProductListPrice = prop.getProperty("price").split(",");
		expectedProductprice = Arrays.asList(ProductListPrice);

		for (int i = 0; i < actualProductprice.size(); i++) {

			Assert.assertEquals(actualProductprice.get(i).getText(), expectedProductprice.get(i));
		}

	}
	//Scenario 3

	@When("apply the Name: Z to A sorting filter on the product listing page")
	public void apply_the_name_z_to_a_sorting_filter_on_the_product_listing_page() throws InterruptedException {
		descProductTitle = testContext.productPage.VerifyDecOrderProductTitle();
		actuallist = new ArrayList<Comparable>();
		for (int i = 0; i < descProductTitle.size(); i++) {
			String data = descProductTitle.get(i).getText();
			actuallist.add(data);

		}
	}

	@Then("should see all product names sorted in descending alphabetical order")
	public void should_see_all_product_names_sorted_in_descending_alphabetical_order() {

		Object templist = actuallist.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		for (int i = 0; i < descProductTitle.size(); i++) {
			System.out.println(actuallist.get(i));

		}

		Assert.assertEquals(templist, actuallist);
	}

	//scenario 4
	@When("apply the Price\\(low to high) sorting filter on the product listing page")
	public void apply_the_price_low_to_high_sorting_filter_on_the_product_listing_page() {
		actuallist = new ArrayList<Comparable>();

		allproductPrices = testContext.productPage.verifyProductPriceAscOrder();

		for (int i = 0; i < allproductPrices.size(); i++) {

			String data = allproductPrices.get(i).getText();

			String newstring = data.substring(1);

			double number = Double.parseDouble(newstring);

			actuallist.add(number);
		}
	}

	@SuppressWarnings("unchecked")
	@Then("should see all product price sorted in ascending order")
	public void should_see_all_product_price_sorted_in_ascending_order() {
		List<Comparable> templist = actuallist;
		Collections.sort(templist);

		Assert.assertEquals(actuallist, templist);
	}
//sceanrio 5
	@When("apply the Price\\(high to low) sorting filter on the product listing page")
	public void apply_the_price_high_to_low_sorting_filter_on_the_product_listing_page() {
		dscProductPrice = testContext.productPage.verifyProductPriceDscOrder();
		actuallist = new ArrayList<Comparable>();
		for (int i = 0; i < dscProductPrice.size(); i++) {
			String data = dscProductPrice.get(i).getText();
			String Price = data.substring(1);
			Double actualPrice = Double.parseDouble(Price);
			actuallist.add(actualPrice);

		}
		System.out.println("Highest price of the product is " + actuallist.get(0));
		System.out.println("Lowest  price of the product is " + actuallist.get(actuallist.size() - 1));

	}

	@Then("should see all product price sorted in descending order")
	public void should_see_all_product_price_sorted_in_descending_order() {

		List tempList = actuallist;

		Collections.reverse(tempList);
		Assert.assertEquals(actuallist, tempList);
	}
	
	
	//Sceanrio 6
	
	@When("the user add a product to the cart from the product listing page")
	public void the_user_add_a_product_to_the_cart_from_the_product_listing_page() {
		testContext.productPage.addTocartProductfromList();
	}
	@Then("the product should be successfully added to the cart")
	public void the_product_should_be_successfully_added_to_the_cart() {
		boolean result= testContext.productPage.validateAddToCart();
		Assert.assertTrue(result);
	}

	
	//Scenario 7
	@When("the user remove product from the product listing page")
	public void the_user_remove_product_from_the_product_listing_page() {
		testContext.productPage.removeProductFromList();
	}
	
	@Then("the product should be successfully remove from the cart")
	public void the_product_should_be_successfully_remove_from_the_cart() {
		boolean results = testContext.productPage.validateRemove();
		Assert.assertTrue(results);
}
}