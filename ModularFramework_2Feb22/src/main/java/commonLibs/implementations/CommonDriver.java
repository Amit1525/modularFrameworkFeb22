package commonLibs.implementations;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonLibs.contracts.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonDriver implements IDriver {

	private WebDriver driver;
	private int pageLoadTimeout;
	private int elementDetectionTimeout;

	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	public CommonDriver(String browserType) throws Exception {

		pageLoadTimeout = 60;
		elementDetectionTimeout = 10;

		if (browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browserType.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else {
			throw new Exception("Invalid Browser Type");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@Override
	public void navidateToFirstUrl(String url) throws Exception {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));

		url = url.trim();
		driver.get(url);

	}

	@Override
	public String getTitle() throws Exception {
		String title = driver.getTitle();
		return title;
	}

	@Override
	public String getCurrentUrl() throws Exception {
		String currentPageUrl = driver.getCurrentUrl();
		return currentPageUrl;
	}

	@Override
	public String getPageSource() throws Exception {
		return driver.getPageSource();

	}

	@Override
	public void navigateToUrl(String url) throws Exception {
		url = url.trim();
		driver.navigate().to(url);

	}

	@Override
	public void navigateForward() throws Exception {
		driver.navigate().forward();

	}

	@Override
	public void navigateBackward() throws Exception {
		driver.navigate().back();

	}

	@Override
	public void refresh() throws Exception {
		driver.navigate().refresh();

	}

	@Override
	public void closeBrowser() throws Exception {
		if (driver != null)
			driver.close();

	}

	@Override
	public void closeAllBrowsers() throws Exception {
		if (driver != null)
			driver.quit();

	}

}
