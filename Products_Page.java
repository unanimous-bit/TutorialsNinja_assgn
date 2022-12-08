package page.objects;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Products_Page {
	
	WebDriver driver;
	static int comp_Count=0;
	public Products_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
	WebElement hoverDesktop;
	
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")
	WebElement Mac;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")
	WebElement iMac_add_cart;
	
	
	@FindBy(xpath = "//*[@id=\"product-category\"]/ul/li[1]/a/i")
	WebElement Home;
	
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[4]/a")
	WebElement Tablets;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]/span")
	WebElement Samsung_Tab;
	
	@FindBy(xpath = "//*[@id=\"product-category\"]/div[1]")
	WebElement comparemsg;
	

	public void move_To_Desktops() {
		Actions ac1 = new Actions(driver);
		ac1.moveToElement(hoverDesktop).perform();
		System.out.println(">>>>>>>>>Moved to Desktop present in NAVIGATION\n");
	}

	public void click_iMac() {
		Mac.click();
		System.out.println(">>>>>>>>>Clicked on Mac\n");
		
	}
	public void click_iMac_addcart() {
		// TODO Auto-generated method stub
		iMac_add_cart.click();
		System.out.println(">>>>>>>>>Clicked on iMac add to cart button\n");
		
	}

	public void Tablets() {
		// TODO Auto-generated method stub
		Tablets.click();
		System.out.println(">>>>>>>>>Clicked on Tablets Mobiles\n");
	}

	public void samsung_add_to_cart() {
		// TODO Auto-generated method stub
		Samsung_Tab.click();
		System.out.println(">>>>>>>>>Clicked on add to cart Samsung Galaxy Tab \n");
	}

	public String get_Compare_Msg() throws InterruptedException {
		// TODO Auto-generated method stub
		
			Thread.sleep(3000);
			System.out.println("COMPARE MESSAGE: "+comparemsg.getText());
			Thread.sleep(3000);
			return comparemsg.getText();
	}
	 


}
