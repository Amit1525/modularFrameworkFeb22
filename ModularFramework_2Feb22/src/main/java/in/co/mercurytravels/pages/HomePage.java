package in.co.mercurytravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementations.CommonElement;
import commonLibs.utils.WaitUtils;

public class HomePage extends BasePage{
	
	@FindBy(linkText ="International Holidays")
	private WebElement internationalHolidayLink;
	
	@FindBy(linkText ="Indian Holidays")
	private WebElement indianHolidayLink;
	
	@FindBy(linkText ="Luxury Rails")
	private WebElement luxuryHolidayLink;
	
	@FindBy(xpath ="(//*[text()=' Customer Login '])[2]")
	private WebElement customerLoginLink;
	
	@FindBy(xpath ="(//ul[@class='dropdown-menu user-login']//li//a)[3]")
	private WebElement userLoginLink;
	
	@FindBy(linkText ="Register")
	private WebElement registerLink;
	
	@FindBy(id ="sign_user_email")
	private WebElement emailId;
	
	@FindBy(id ="sign_user_password")
	private WebElement passwd;
	
	@FindBy(xpath="//p[@class='text-right']//following::button[1]")
	private WebElement loginButton;
	
	@FindBy(id ="acc_first_name")
	private WebElement newUserfirstName;
	
	@FindBy(id ="acc_last_name")
	private WebElement newUserlastName;
	
	@FindBy(id ="acc_user_email")
	private WebElement newUserEmail;
	
	@FindBy(id ="acc_user_password")
	private WebElement newUserpassword;
	
	@FindBy(id ="acc_user_passconf")
	private WebElement newUserConfpassword;
	
	@FindBy(name = "countrycode")
	private WebElement countryCd;
	
	@FindBy(id = "acc_mobile_no")
	private WebElement newUserMobile;
	
	@FindBy(xpath = "//button[text()='Register']")
	private WebElement registerButton;
	
	@FindBy(xpath = "(//a[contains(text(),'Welcome,')])[2]")
	private WebElement welcomeText;
	
	@FindBy(xpath = "(//a[contains(text(),'Log Out')])[2]")
	private WebElement logoutLink;
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void userLogin(String username, String password) throws Exception
	{

		WaitUtils.waitForSeconds(2);
		mouseControl.moveToElement(customerLoginLink);
		mouseControl.moveToElementAndClick(userLoginLink);
		WaitUtils.waitForSeconds(1);
		elementControl.enterText(emailId, username);
		elementControl.enterText(passwd, password);
		elementControl.clickElement(loginButton);
		//Thread.sleep(2000);
		//mouseControl.pressEscapeKey();
		
	}
	
	
	public void registerNewUser(String firstName, String lastName, String email, String pass, 
			String confPass, String userMobile) throws Exception
	{
		WaitUtils.waitForSeconds(2);
		mouseControl.moveToElement(customerLoginLink);
		mouseControl.moveToElementAndClick(registerLink);
		WaitUtils.waitForSeconds(1);
		elementControl.enterText(newUserfirstName, firstName);
		elementControl.enterText(newUserlastName, lastName);
		elementControl.enterText(newUserEmail, email);
		elementControl.enterText(newUserpassword, pass);
		elementControl.enterText(newUserConfpassword, confPass);
		dropdownControl.selectWithValue(countryCd, "1");
		elementControl.enterText(newUserMobile, userMobile);
		//elementControl.clickElement(registerButton);
		WaitUtils.waitForSeconds(1);
		mouseControl.pressEscapeKey();
		
	}
	
	public String getWelcomeMessage() throws Exception
	{
		WaitUtils.waitForSeconds(1);
		return elementControl.getText(welcomeText);
	}

	public void logout() throws Exception
	{
		WaitUtils.waitForSeconds(1);
		mouseControl.moveToElement(welcomeText);
		mouseControl.moveToElementAndClick(logoutLink);
				
	}
	
	
	
	
}
