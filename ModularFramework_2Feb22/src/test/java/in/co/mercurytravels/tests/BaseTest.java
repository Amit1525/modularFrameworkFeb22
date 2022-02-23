package in.co.mercurytravels.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import commonLibs.implementations.CommonDriver;
import in.co.mercurytravels.pages.HomePage;

public class BaseTest {
	
	CommonDriver commonDriver;
	String browserType = "chrome"; 
	String url = "https://www.mercurytravels.co.in/";
	
	HomePage homepage;
	private WebDriver driver;
	
	@BeforeClass
	public void startBrowser() throws Exception
	{
		commonDriver = new CommonDriver(browserType);
		commonDriver.setPageLoadTimeout(60);
		commonDriver.setElementDetectionTimeout(20);
		commonDriver.navigateToUrl(url);
		//commonDriver.refresh();
		
		driver = commonDriver.getDriver();
		homepage = new HomePage(driver);
		
	}
	
	
	@AfterClass
	public void closeBrowser() throws Exception
	{
		commonDriver.closeAllBrowsers();
		Runtime rt = Runtime.getRuntime();
		rt.exec("taskkill /F /IM ChromeDriver.exe");
		rt.exec("taskkill /F /IM geckoDriver.exe");
		rt.exec("taskkill /F /IM msedgeDriver.exe");
	}

}
