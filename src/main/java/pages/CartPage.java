package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.ActionDriver;
import baseclass.BaseClass;

public class CartPage extends BaseClass {
	ActionDriver action = new ActionDriver();

	public CartPage() {

		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//div[@id='contents_wrapper']//div[text()='Your Cart']")
	WebElement title;

	@FindBy(xpath = "//a[@id='item_4_title_link']/div")
	WebElement cartProductTitle;

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	WebElement cartProductPrice;

	@FindBy(xpath = "//button[text()='Remove']")
	WebElement removeButton;

	@FindBy(xpath = "//button[@id='continue-shopping']")
	WebElement continueShopping;

	@FindBy(xpath = "//span[text()='Products']")
	WebElement productTitle;

	@FindBy(name = "checkout")
	WebElement checkout;

	public Boolean validateCartPage() {
		action.visibilityOfWebElementLocated(title);

		return action.isDisplayed(getDriver(), title);

	}
	

	public String validate_Product_Title() {

		//System.out.println(cartProductTitle.getText());

		return cartProductTitle.getText();
	}

	public String validate_Product_Price() {

		System.out.println(cartProductPrice.getText());

		return cartProductPrice.getText();
	}
}
