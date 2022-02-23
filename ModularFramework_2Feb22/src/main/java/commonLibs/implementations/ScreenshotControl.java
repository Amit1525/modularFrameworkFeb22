package commonLibs.implementations;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IScreenshot;

public class ScreenshotControl implements IScreenshot{
	
	TakesScreenshot ts;
	
	public ScreenshotControl(WebDriver driver)
	{
		ts = (TakesScreenshot) driver; 
	}
	
	
	@Override
	public void captureAndSaveScreenshot(String pathForTheFile) throws Exception {
		
		pathForTheFile = pathForTheFile.trim();
		
		File imgFile, tmpFile;
		
		imgFile = new File(pathForTheFile);
		
		if(imgFile.exists())
			throw new Exception("Image with this file name already exists..");
		
		tmpFile = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpFile, imgFile);
		
	}

}
