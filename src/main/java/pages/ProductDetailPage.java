package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.ActionDriver;
import baseclass.BaseClass;


public class ProductDetailPage extends BaseClass{

	ActionDriver action = new ActionDriver();

	public ProductDetailPage() {

		
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//button[text()='ADD TO CART']")
	WebElement addToCart;

	@FindBy(xpath = "//button[contains(text(),'REMOVE')]")
	WebElement remove;

	@FindBy(id = "back-to-products")
	WebElement backToProduct;

	@FindBy(xpath = "//div[@class='inventory_list']/div[1]/div[2]/div[1]/a")
	WebElement productDetail;
	
	@FindBy(xpath="//div[@class='inventory_details']/button")
	WebElement backToProducts;
	
	@FindBy(xpath="//div[@id='inventory_filter_container']")
	WebElement products;

	
	@FindBy(xpath="//div[@id='shopping_cart_container']//a")
	WebElement cart;
	
	@FindBy(xpath="//div[@class='inventory_details_name']")
	WebElement productDetailTitle;
	
	@FindBy(xpath="//div[@class='inventory_details_price']")
	WebElement productDetailPrice;
	
	//check product detail is open
	public Boolean validateProductdetail() {
		return action.isDisplayed(getDriver(), productDetail);
	}
	
	//Add to cart product from product detail
	public String  addTocartProductfromDetail() {

		if (action.isDisplayed(getDriver(), addToCart)) {
			action.click(addToCart, "addtocart");
			
		}
            return productDetailTitle.getText();
	}
	
	//validat ethat product is added to cart
	
	public Boolean validateAddToCart() {

		return action.isDisplayed(getDriver(), remove);

	}
	
	public void removeProductFromCart() {

		if (action.isDisplayed(getDriver(), remove)) {
			action.click(remove, "remove");

		}
	}
	
	public Boolean validateRemove() {

		return action.isDisplayed(getDriver(), addToCart);

	}
	
	
public void BackToProductListing() {
		
		action.click(backToProducts, "Back To Productd");
		
	}
	public Boolean validateBackToProducts() {

		return action.isDisplayed(getDriver(), products);

	}
	
	
	public void clickOnCart() {
		action.click(cart, "Cart");
		System.out.println("i have click oncart icon");
		//return new CartPage();
		
	}
	public String productDetailProductPrice() {
		addTocartProductfromDetail();
		
		
		return productDetailPrice.getText();
		
	}
	 
}
