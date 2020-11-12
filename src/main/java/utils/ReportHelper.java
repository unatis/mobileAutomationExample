package utils;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ReportHelper
{
	
	public static String saveScreenshot(AppiumDriver driver, String method, String folder)
	{
		File scrFile = driver.getScreenshotAs(OutputType.FILE);
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(GregorianCalendar.YEAR, cal.get(GregorianCalendar.YEAR));
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy.HH:mm:ss");
		String currentTime = formatter.format(cal.getTime()).replace('.', '_');
		Path screenPath;
		if (folder != null)
		{
			screenPath = Paths.get("target", "surefire-reports", folder, "html", method + currentTime + ".png");
		}
		else
		{
			screenPath = Paths.get("target", "surefire-reports", "html", method + currentTime + ".png");
		}
		try
		{
			FileUtils.copyFile(scrFile, new File(screenPath.toString()));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		//        return "<p></p> <a href=\"" + method+currentTime+".png"+"\">"+method+currentTime+"</a>";
		return method + currentTime + ".png";
	}
	
	public void log(String screenshotPath)
	{
		final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
		System.setProperty(ESCAPE_PROPERTY, "false");
		//            Reporter.log(text.replace("<u><b>||||||", "<u><b>" + "___NAME___"));
		Reporter.log("<u><b></b></u><br><a href=\"" + screenshotPath + "\"><img src=\"" + screenshotPath + "\" alt=\"\"" + "height='720' width='480'/> " + "<br />");
	}
}
