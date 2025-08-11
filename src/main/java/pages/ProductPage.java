package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.ActionDriver;
import baseclass.BaseClass;

public class ProductPage extends BaseClass {

	ActionDriver action = new ActionDriver();
	
	public ProductPage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cart;

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement select;

	@FindBy(xpath = "//div[@class='inventory_item']//div[@class='inventory_item_label']//div[@class='inventory_item_name']")
	List<WebElement> productListTitle;

	@FindBy(xpath = "//div[@class='inventory_item_desc']")
	List<WebElement> productListDesc;

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	List<WebElement> productListPrice;

	@FindBy(xpath = "//button[text()='ADD TO CART']")
	WebElement addToCart;

	@FindBy(xpath = "//button[text()='REMOVE']")
	WebElement remove;

	@FindBy(xpath="//*[@id=\"item_4_title_link\"]/div")
	WebElement productTitle;

	
	public List<WebElement> VerifyallProductTitle() {
		// productSTitle = null;

for (int i = 0; i < productListTitle.size(); i++) {
	System.out.println(productListTitle.get(i).getText());
}
		return productListTitle;
	}

	public List<WebElement> getAllProductDesc() {

		return productListDesc;
	}

	public List<WebElement> getAllProductprice() {

		return productListPrice;
	}
	
	public List<WebElement> VerifyDecOrderProductTitle() throws InterruptedException {
		System.out.println("in method");

		action.selectByIndex(select, 1);
		Thread.sleep(5000);
		VerifyallProductTitle();

		return productListTitle;

	}
	
	public List<WebElement> verifyProductPriceAscOrder() {
		action.selectByIndex(select, 2);
		getAllProductprice();
		
		System.out.println(productListPrice.size()+"@@@@@@@");
		return productListPrice;
	}
 
	public List<WebElement> verifyProductPriceDscOrder() {
		action.selectByIndex(select, 3);
		getAllProductprice();

		return productListPrice;
	}
	
	
	//Add to cart product
	public void addTocartProductfromList() {

		for (int i = 0; i < productListTitle.size(); i++) {
			if (productListTitle.get(i).getText().equalsIgnoreCase(prop.getProperty("productname"))) {
                System.out.println(prop.getProperty("productname")+"!@#$%^&");
				if (action.isDisplayed(getDriver(), addToCart)) {
					action.click(addToCart, "addtocart");

				}
			}
		}
	}
	//Validate product added to the cart
	public Boolean validateAddToCart() {
		
		action.visibilityOfWebElementLocated(remove);

		return action.isDisplayed(getDriver(), remove);

	}
	//Remove product from the cart
	public void removeProductFromList() {

		for (int i = 0; i < productListTitle.size(); i++) {
			if (productListTitle.get(i).getText().equalsIgnoreCase(prop.getProperty("productname"))) {

				if (action.isDisplayed(getDriver(), remove)) {
					action.click(remove, "remove");

				}
			}
		}

	}
	//validate Remove product from the cart
	public Boolean validateRemove() {

		return action.isDisplayed(getDriver(), addToCart);

	}
	
public void  clickOnProductTitle() {
		
		for (int i = 0; i < productListTitle.size(); i++) {
			if (productListTitle.get(i).getText().equalsIgnoreCase(prop.getProperty("productname"))) {

				if (action.isDisplayed(getDriver(), addToCart)) {
					System.out.println("i am here##############");
					System.out.println(productListTitle.get(i));

					System.out.println(productListTitle.get(i).getText());

					action.click(productListTitle.get(i), "productTitle");

				}
			}
		}
		
		//return new ProductDetailPage();
	}
	

}
