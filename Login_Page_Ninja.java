package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_Ninja {

	WebDriver driver;
	
	public Login_Page_Ninja(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	WebElement Menu_LoginBtn;
	
	@FindBy(xpath = "//*[@id=\"input-email\"]")
	WebElement emailId;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")
	WebElement loginBtn;
	
	public void setEmailId(String email) {
		emailId.clear();
		emailId.sendKeys(email);
		System.out.println("Emial is entered into testField\n");
	}
	
	public void setPassword(String password) {
		this.password.clear();
	    this.password.sendKeys(password);
	    System.out.println("Password is entered into testField\n");
	}
	public void clickLoginBtn() {
		loginBtn.click();
		System.out.println("Login Btn is clicked\n");
	}

	public void clickMenu_LoginBtn() {
		// TODO Auto-generated method stub
		Menu_LoginBtn.click();
		System.out.println("Menu Login Btn is clicked\n");
	}

	
}



