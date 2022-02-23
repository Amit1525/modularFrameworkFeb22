package commonLibs.implementations;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commonLibs.contracts.IDropdown;

public class DropdownControl implements IDropdown{
	
	private Select getSelect(WebElement element)
	{
		Select select = new Select(element);
		return select;
	}

	@Override
	public void selectVisibleText(WebElement element, String visibleText) throws Exception {
		//Select select = new Select(element);
		//select.selectByVisibleText(visibleText);
		
		getSelect(element).selectByVisibleText(visibleText);
		
	}

	@Override
	public void selectWithValue(WebElement element, String value) throws Exception {
		//Select select = new Select(element);
		//select.selectByValue(value);
		
		getSelect(element).selectByValue(value);
	}

	@Override
	public void selectWithIndex(WebElement element, int index) throws Exception {
		getSelect(element).selectByIndex(index);
		
	}

	@Override
	public List<WebElement> getAllOptions(WebElement element) throws Exception {
		List<WebElement> allSelectedOptions = getSelect(element).getAllSelectedOptions();
		return allSelectedOptions;
	}
	
	

	
}
