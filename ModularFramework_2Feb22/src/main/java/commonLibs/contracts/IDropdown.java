package commonLibs.contracts;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface IDropdown {
	
	public void selectVisibleText(WebElement element, String visibleText) throws Exception;
	
	public void selectWithValue(WebElement element, String value) throws Exception;
	
	public void selectWithIndex(WebElement element, int index) throws Exception;
	
	public List<WebElement> getAllOptions(WebElement element)  throws Exception;

}
