package commonLibs.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	
	public static void waitForSeconds(int waitTimeInSeconds) throws Exception
	{
		Thread.sleep(waitTimeInSeconds * 1000);
	}
	
	public static void waitTillAlertIsPresent(WebDriver driver, int timeInSeconds) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void waitForWebElementToBeVisible(WebDriver driver, WebElement element, int timeInSeconds) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForWebElementToBeClickable(WebDriver driver, WebElement element, int timeInSeconds) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
