package in.co.mercurytravels.pages;

import java.awt.Window;

import org.openqa.selenium.WebDriver;

import commonLibs.implementations.AlertControl;
import commonLibs.implementations.CommonElement;
import commonLibs.implementations.DropdownControl;
import commonLibs.implementations.FramesControl;
import commonLibs.implementations.JavascriptControl;
import commonLibs.implementations.MouseControl;
import commonLibs.implementations.ScreenshotControl;
import commonLibs.implementations.WindowControl;

public class BasePage {
	
	protected AlertControl alertControl;
	
	protected CommonElement elementControl;
	
	protected DropdownControl dropdownControl;
	
	protected FramesControl framesControl;
	
	protected MouseControl mouseControl;
	
	protected JavascriptControl javascriptControl;
	
	protected ScreenshotControl screenshotControl;
	
	protected WindowControl windowControl;
	
	public BasePage(WebDriver driver)
	{
		alertControl = new AlertControl(driver);
		elementControl = new CommonElement();
		dropdownControl = new DropdownControl();
		framesControl = new FramesControl(driver);
		mouseControl = new MouseControl(driver);
		javascriptControl = new JavascriptControl(driver);
		screenshotControl = new ScreenshotControl(driver);
		windowControl = new WindowControl(driver);
		
	}
	

}
