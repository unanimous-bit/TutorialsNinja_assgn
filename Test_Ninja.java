package test.scenarious;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
//import java.util.concurrent.TimeUnit;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

//import io.github.bonigarcia.wdm.WebDriverManager;
import page.objects.Cart_Page;
import page.objects.Login_Page_Ninja;

import page.objects.Products_Page;
import page.objects.Registration_Ninja;

public class Test_Ninja {
	 WebDriver  driver;
	FileReader reader = null;
	Properties props = new Properties();
	Registration_Ninja rn;
	Login_Page_Ninja lp;
	Products_Page pp;
	Cart_Page cp;
	
	String filePath = ".//Amir//Screenshot";
	
	String product_1_Name; 
	String product_2_Name; 
	
	

	@Test(priority = -1, enabled = true)
	public void readConfig() {

		try {
			reader = new FileReader(".//config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			props.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("OPENING URL: " + props.getProperty("URL"));
	}
	
	
	@Parameters("browserName")
	@Test(priority = 0, enabled = true)
	public void setUp(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.out.println("BrowserName is " + browserName);
			System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("me")) {
			System.out.println("BrowserName is " + browserName);
			System.setProperty("webdriver.edge.driver", ".//Drivers//msedgedriver.exe");
			driver = new EdgeDriver();
		}
	}

	@Test(priority = 1, enabled = true)
	public void openBrowsers() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(props.getProperty("URL"));
		driver.manage().window().maximize();
	}
	
	  @Test
	  (priority = 2, enabled = true) 
	  public void register() throws
	  InterruptedException {
		  rn = new Registration_Ninja(driver);
	  rn.setFirst_Name(props.getProperty("firstname"));
	  rn.setLast_Name(props.getProperty("lastname"));
	  rn.setEmailId(props.getProperty("useremail"));
	  rn.setTelephone(props.getProperty("Telephone"));
	  rn.setPassword(props.getProperty("password"));
	  rn.setPassword1(props.getProperty("confirmpass"));
	  rn.setCheckbox(props.getProperty("checkbox"));
	  
	  Thread.sleep(2000); 
	  rn.clickregBtn(); 
	  }
	 

		
		  @Test(priority = 3, enabled = true) 
		  public void login() throws InterruptedException {
		   driver.get(props.getProperty("URL1")); 
		  lp = new Login_Page_Ninja(driver);
		  lp.clickMenu_LoginBtn(); 
		  lp.setEmailId(props.getProperty("email"));
		  lp.setPassword(props.getProperty("pass")); 
		  Thread.sleep(2000);
		  lp.clickLoginBtn();
		  }
		 

	@Test(priority = 4, enabled = true)
	public void products() throws InterruptedException  {
		pp = new Products_Page(driver);
		pp.move_To_Desktops();
		
		pp.click_iMac();
		
		pp.click_iMac_addcart();
		
		String comp_Msg_2 = pp.get_Compare_Msg();
		System.out.println("IN Main" + comp_Msg_2);
		System.out.println("Message should be: "+props.getProperty("verifyComMsgFor_iMac"));
		Assert.assertEquals(comp_Msg_2, props.getProperty("verifyComMsgFor_iMac"));
		
		pp.Tablets();
		
		pp.samsung_add_to_cart();
		
		String comp_Msg_3 = pp.get_Compare_Msg();
		System.out.println("IN Main" + comp_Msg_3);
		System.out.println("Message should be: "+props.getProperty("verifyComMsgFor_samsung"));
		Assert.assertEquals(comp_Msg_3, props.getProperty("verifyComMsgFor_samsung"));
	}

	

	@Test(priority = 5, enabled = true)
	public void Cart_Page()  {
		cp = new Cart_Page(driver);
		cp.click_CartPage();
		cp.click_checkout_from_cart();
		cp.click_Remove_IMac();
		cp.click_checkoutBtn();
	}


 @Test(priority = 6, enabled = true)
 public void Screenshot() throws IOException  {
	cp.Screenshot(driver);
        driver.quit();
}
 
}
