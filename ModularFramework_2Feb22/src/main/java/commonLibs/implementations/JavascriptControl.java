package commonLibs.implementations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IJavascriptOperations;

public class JavascriptControl implements IJavascriptOperations{
	
	JavascriptExecutor js;
	
	public JavascriptControl(WebDriver driver) {
		js = (JavascriptExecutor) driver;
	}

	@Override
	public void executeJavaScript(String scriptToExecute) throws Exception {
		js.executeScript(scriptToExecute);
		
	}

	@Override
	public void scrollDown(int x, int y) throws Exception {
		String jsCommand = String.format("window.scrollBy(%d,%d)", x,y);
		js.executeScript(jsCommand);
		
	}

	@Override
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		return js.executeScript(scriptToExecute).toString();
	}

}
