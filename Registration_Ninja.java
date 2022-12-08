package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration_Ninja {

	WebDriver driver;
	
	public Registration_Ninja(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"input-firstname\"]")
	WebElement first_name;
	
	@FindBy(xpath = "//*[@id=\"input-lastname\"]")
	WebElement last_name;
	
	@FindBy(xpath = "//*[@id=\"input-email\"]")
	WebElement emailID;
	
	@FindBy(xpath = "//*[@id=\"input-telephone\"]")
	WebElement Telephone;
	
	@FindBy(xpath = "//*[@id=\"input-password\"]")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"input-confirm\"]")
	WebElement confirmpass;
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
	WebElement checkbox;
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement regBtn;
	
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	WebElement Myaccount;
	
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
	WebElement Logout;
	
	public void setFirst_Name(String firstname) {
		// TODO Auto-generated method stub
		first_name.clear();
		first_name.sendKeys(firstname);
		System.out.println("Email is entered into testField\n");
	}
	
	public void setLast_Name(String lastname) {
		// TODO Auto-generated method stub
		last_name.clear();
		last_name.sendKeys(lastname);
		System.out.println("Email is entered into testField\n");
	}


	public void setEmailId(String useremail) {
		// TODO Auto-generated method stub
		emailID.clear();
		emailID.sendKeys(useremail);
		System.out.println("Email is entered into testField\n");
	}
	public void setTelephone(String Telephone) {
		// TODO Auto-generated method stub
		this.Telephone.clear();
		this.Telephone.sendKeys(Telephone);
		System.out.println("Telephone number entered in Testfield\n");
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password.clear();
		this.password.sendKeys(password);
		System.out.println(" Password entered in Testfield\n");
	}
	
	public void setPassword1(String pass) {
		// TODO Auto-generated method stub
		this.confirmpass.clear();
		this.confirmpass.sendKeys(pass);
		System.out.println("Confirm Password entered in Testfield\n");
	}
	
	

	public void clickregBtn() {
		// TODO Auto-generated method stub
		regBtn.click();
		System.out.println("Registration Btn is clicked\n");
	}

	public void setCheckbox(String property) {
		// TODO Auto-generated method stub
		checkbox.click();
	}

	public void clickMyaccoun() {
		// TODO Auto-generated method stub
		Myaccount.click();
	}

	public void clickLogout() {
		// TODO Auto-generated method stub
		Logout.click();
	}

	

	
}
