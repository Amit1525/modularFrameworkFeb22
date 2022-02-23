package in.co.mercurytravels.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MercuryTravelTestcases extends BaseTest{
	
	
	@Test(enabled = true, priority = 1)
	public void verifyUserLoginWithCorrectCredential() throws Exception
	{
		String username = "activeproton1525@protonmail.com";
		String password = "abc@123!-IN!";
		
		homepage.userLogin(username, password);
		String expectedWelcomeText ="Welcome, Ami";
		String actualWelcomeText = homepage.getWelcomeMessage();
		
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
		homepage.logout();
		
	
	}
	
	@Test(enabled = true, priority = 2)
	public void verifyNewUserRegistration() throws Exception
	{
		String firstname = "Ami";
		String lastname = "Am";
		String emailId = "activeproton1525@protonmail.com";
		String passwd = "abc@123!-IN!";
		String confPasswd = "abc@123!-IN!";
		String userCell = "12398989172";
		
		homepage.registerNewUser(firstname, lastname, emailId, passwd, confPasswd, userCell);
	}
	
	
	
	
	
	
}
