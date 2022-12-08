package page.objects;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart_Page {
	WebDriver driver;
	public Cart_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"cart-total\"]")
	WebElement Cart_Page;
	
	
	@FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")
	WebElement checkout_from_cart;
	
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[4]/div/span/button[2]/i")
	WebElement Remove_IMac;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/a")
	WebElement checkoutBtn;
	
	public void click_CartPage() {
		// TODO Auto-generated method stub
		Cart_Page.click();
		System.out.println("Clicked on Cart Page\n");
	}
	public void click_checkout_from_cart() {
		// TODO Auto-generated method stub
		checkout_from_cart.click();
		System.out.println("Clicked on Checkout Page\n");
	}
	public void click_Remove_IMac() {
		// TODO Auto-generated method stub
		 Remove_IMac.click();
		System.out.println("Clicked on remove product iMac from Checkout Page\n");
	}
	public void click_checkoutBtn() {
		// TODO Auto-generated method stub
		checkoutBtn.click();
		System.out.println("Clicked on Checkout Page\n");
	}
	
		 public void Screenshot( WebDriver driver) throws IOException  {
				Date currentdate = new Date();
				System.out.println("currentdate");
				//modifying the date into string format
				String screenshotfilename = ".//ssfolder//"+currentdate.toString().replace(" ", ",").replace(":", "-")+".png";
				System.out.println(screenshotfilename);
				//driver.get(checkout_from_cart);
				//Convert web driver object to TakeScreenshot

		        TakesScreenshot scrShot =((TakesScreenshot)driver);

		        //Call getScreenshotAs method to create image file

		                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		            //Move image file to new destination

		                File DestFile=new File( screenshotfilename);

		                //Copy file at destination

		                FileUtils.copyFile(SrcFile, DestFile);
		System.out.println("Screenshot taken\n");
	}

}
