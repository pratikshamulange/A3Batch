package ElementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtils.BaseClass;

public class BasePage extends BaseClass
{
	@FindBy(partialLinkText="Register")
	private WebElement registerLink;
	
	@FindBy(partialLinkText="Log in")
	private WebElement loginLink;
	
	@FindBy(partialLinkText="Shopping cart")
	private WebElement shoppingCartLink;
	
	@FindBy(partialLinkText="WISHLIST")
	private WebElement wishlistCartLink;
	
	@FindBy(partialLinkText="BOOKS")
	private WebElement booksLink;     
	
	@FindBy(partialLinkText="COMPUTERS")
	private WebElement computersLink;
	
	@FindBy(partialLinkText="ELECTRONICS")
	private WebElement electronicsLink;
	
	@FindBy(partialLinkText="APPAREL & SHOES")
	private WebElement apparelAndShoesLink;
	
	@FindBy(partialLinkText="DIGITAL DOWNLOAD")
	private WebElement digitaldownloadsLink;
	
	@FindBy(partialLinkText="JEWELRY")
	private WebElement jewelryLink;
	
	@FindBy(partialLinkText="GIFT CARD")
	private WebElement giftCards;
	
	@FindBy(id="small-searchterms")
	private WebElement SsearchBox;
	
	@FindBy(xpath="//input[@value='Search']")
	private WebElement searchButton;
	
	///**
	// * Getter
	// */
	
	///**
	//  * this method is used to access RegisterLink
	// *
	// */
	
	
	public BasePage(WebElement driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}



	public WebElement getLoginLink() {
		return loginLink;
	}



	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}



	public WebElement getWishlistCartLink() {
		return wishlistCartLink;
	}



	public WebElement getBooksLink() {
		return booksLink;
	}



	public WebElement getComputersLink() {
		return computersLink;
	}



	public WebElement getElectronicsLink() {
		return electronicsLink;
	}



	public WebElement getApparelAndShoesLink() {
		return apparelAndShoesLink;
	}



	public WebElement getDigitaldownloadsLink() {
		return digitaldownloadsLink;
	}



	public WebElement getJewelryLink() {
		return jewelryLink;
	}



	public WebElement getGiftCards() {
		return giftCards;
	}



	public WebElement getSsearchBox() {
		return SsearchBox;
	}



	public WebElement getSearchButton() {
		return searchButton;
	}

	


	public BasePage(WebDriver driver)
	{
		
	PageFactory.initElements(driver, this);
	}
}

