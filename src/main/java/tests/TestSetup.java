/**
 * Created by Shahar Sheinfeld on 19/11/2019.
 **/
package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import utils.CapabilitiesHelper;
import utils.CommandLineHelpers;
import utils.ReportHelper;

import java.net.URL;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static tests.FileHelpers.*;

public class TestSetup
{
	public static AppiumDriver driver;
	public static String appPath;
	public static boolean resetAppAfterTest = true;
	public static boolean resetAppiumDriverOnFailureIfIos = false;
	public static boolean isDebug = true;
	public static boolean isIos = false;
	public static String emulator = isIos ? CapabilitiesHelper.iPhone11 : CapabilitiesHelper.pixel3a;
	public static String port = isIos ? "4724" : "4725";
	public static String env = "staging";
	public static int defaultWaitTime = 25000;
	
	public static void initialSetup(String emulator, String port)
	{
		if (driver == null)
		{
			try
			{
				if (isIos)
				{
					DesiredCapabilities capabilities = CapabilitiesHelper.capabilitiesForIphoneSimulator(appPath, emulator, port);
					driver = new IOSDriver(new URL("http://127.0.0.1:" + port + "/wd/hub"), capabilities);
				}
				else
				{
					try
					{
						DesiredCapabilities capabilities = CapabilitiesHelper.capabilitiesForAndroidSimulator(appPath, appPackageName, emulator, port);
						driver = new AndroidDriver(new URL("http://127.0.0.1:" + port + "/wd/hub"), capabilities);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		driver.manage().timeouts().implicitlyWait(defaultWaitTime, TimeUnit.SECONDS);
	}
	
	@BeforeSuite(alwaysRun = true)
	public void setServer()
	{
		String tempCurrentOS = System.getProperty("OSproperty");
		if (tempCurrentOS != null)
		{
			isIos = tempCurrentOS.toLowerCase().equals("ios");
		}
		port = Optional.ofNullable(System.getProperty("port")).orElse(port);
		emulator = Optional.ofNullable(System.getProperty("emulator")).orElse(emulator);
		env = Optional.ofNullable(System.getProperty("env")).orElse(env);
		isDebug = System.getProperty("isDebug") == null ? isDebug : Boolean.parseBoolean(System.getProperty("isDebug"));
//		isLocal = System.getProperty("isLocal") == null ? false : true;
		
		if (isDebug)
			appPath = isIos ? LOCAL_IOS_DEBUG_APP_PATH : LOCAL_ANDROID_DEBUG_APP_PATH;
		else
			appPath = isIos ? IOS_APP_PATH : ANDROID_APP_PATH;
		
		startAndCleanEmulator(emulator);
		startServerAndDriver(emulator, port);
	}
	
	public void startAndCleanEmulator(String emulator)
	{
		if (isIos)
		{
			CommandLineHelpers.startIosSimulator(emulator);
			if (driver == null)
				CommandLineHelpers.uninstallAppOnIos(emulator, appPackageName);
		}
		else
		{
			if ((driver == null))
			{
				System.out.println("Starting " + emulator + " android emulator");
				CommandLineHelpers.startEmulator(emulator);
			}
		}
	}
	
	public void startServerAndDriver(String emulator, String port)
	{
		new CommandLineHelpers().startServerSessionProgrammatically(port);
		initialSetup(emulator, port);
	}
	
	@AfterMethod(alwaysRun = true)
	public void resetAppAndOnFailureTakeScreenShot(ITestResult testResult)
	{
////		if(!isIos)
//		String osLog = isIos ? "syslog" : "logcat";
//		{
//			// inspect available log types
//			Set logtypes = driver.manage().logs().getAvailableLogTypes();
//			System.out.println("suported log types: " + logtypes.toString()); // [logcat, bugreport, server, client]
//
//// print first and last 10 lines of logs
//			LogEntries logs = driver.manage().logs().get(osLog);
////			System.out.println("First and last ten lines of log: ");
////			StreamSupport.stream(logs.spliterator(), false).limit(10).forEach(System.out::println);
////			System.out.println("...");
//			System.out.println("Last 2000 lines of log: ");
//			StreamSupport.stream(logs.spliterator(), false).skip(logs.getAll().size() - 2000).forEach(System.out::println);
//
//		}
		if (testResult.getStatus() == ITestResult.FAILURE)
		{
			String screenshotPath = ReportHelper.saveScreenshot(driver, testResult.getMethod().getMethodName(), System.getProperty("newDir"));
			Reporter.setCurrentTestResult(testResult);
			new ReportHelper().log(screenshotPath);
			
		}
		if(!isIos)
		{
			try
			{
				Runtime.getRuntime().exec("adb tcpip " + port);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
