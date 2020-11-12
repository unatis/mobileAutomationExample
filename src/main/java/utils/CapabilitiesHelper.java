package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.remote.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.FileHelpers;

public class CapabilitiesHelper
{
	public static final String pixel3a = "Pixel3a";
	public static final String pixel3a_1 = "Pixel3a_1";
	public static final String pixel3a_2 = "Pixel3a_2";
	public static final String Pixel3a_for_browser = "Pixel3a_for_browser";
	public static final String iPhone11 = "iPhone 11";
	public static final String iPhone11Pro = "iPhone 11 Pro";
	public static final String iPhone11ProMax = "iPhone 11 Pro Max";
	public static final String iPhoneX = "iPhone X";
	public static final String iPhoneXold= "iPhone X-12.4";
	public static final String iPhoneSE2nd = "iPhone SE2nd";
	
	
	public static DesiredCapabilities capabilitiesForAndroidSimulator(String appPath, String appPackage,
			String simulator, String port)
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP, appPath);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, simulator);
		capabilities.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, 180000);
		capabilities.setCapability(AndroidMobileCapabilityType.ANDROID_DEVICE_READY_TIMEOUT, 180);
//		                capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		capabilities.setCapability(MobileCapabilityType.UDID, CommandLineHelpers.getAvd(simulator));
//		capabilities.setCapability(AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET, true);
		//        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		//                capabilities.setCapability("enforceAppInstall", true);
		capabilities.setCapability(AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET, true);
		capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, port);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10800); //keep appium session alive for 3 hours (in seconds)
		//        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "ai.kanghealth.*");
		//                capabilities.setCapability("uninstallOtherPackages", appPackage);
//		capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_USE_SYSTEM_EXECUTABLE, true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, ImmutableMap.of("w3c", false)); //this is for
		// chromedriver. without it to ids, and more will not be recoginzed.
		capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, FileHelpers.CHROME_DRIVER_PATH);
		capabilities.setCapability(AndroidMobileCapabilityType.NATIVE_WEB_SCREENSHOT, true);
		capabilities.setCapability(AndroidMobileCapabilityType.DISABLE_ANDROID_WATCHERS, true);
//		capabilities.setCapability(AndroidMobileCapabilityType.ANDROID_INSTALL_TIMEOUT, 240000);  //SHAHAR
		capabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		capabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		capabilities.setCapability(AndroidMobileCapabilityType.IGNORE_UNIMPORTANT_VIEWS, true);
		capabilities.setCapability(AndroidMobileCapabilityType.UNINSTALL_OTHER_PACKAGES, appPackage);
		return capabilities;
	}
	
	
	public static DesiredCapabilities capabilitiesForIphoneSimulator(String appPath, String simulator, String port)
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP, appPath);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.6");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, simulator);
		capabilities.setCapability(MobileCapabilityType.UDID, CommandLineHelpers.getUDID(simulator));
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10800); //keep appium session alive for 3 hours (in seconds)
		//        capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
//		capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		//                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, port + 1);
//		capabilities.setCapability("useJSONSource", true); //SHAHAR
//		capabilities.setCapability(IOSMobileCapabilityType.IOS_INSTALL_PAUSE, 12000);  //SHAHAR
		capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 120000);
		capabilities.setCapability(IOSMobileCapabilityType.WDA_LAUNCH_TIMEOUT, 120000);
		capabilities.setCapability(IOSMobileCapabilityType.WDA_CONNECTION_TIMEOUT, 120000);
//		capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
		capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
//		capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
//		capabilities.setCapability(IOSMobileCapabilityType.NATIVE_INSTRUMENTS_LIB, true); //to delete if not needed
//		capabilities.setCapability("simpleIsVisibleCheck", true);
//		capabilities.setCapability("useFirstMatch", true);
//		capabilities.setCapability("reduceMotion", true);
		return capabilities;
	}
	
	
	public static DesiredCapabilities capabilitiesForIphoneSimulatorNoReset(String appPath, String simulator, String port)
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP, appPath);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.5");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, simulator);
		capabilities.setCapability(MobileCapabilityType.UDID, CommandLineHelpers.getUDID(simulator));
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10800); //keep appium session alive for 3 hours (in seconds)
		//        capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
//		capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		//                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, port + 1);
		capabilities.setCapability("useJSONSource", true); //SHAHAR
//		capabilities.setCapability(IOSMobileCapabilityType.IOS_INSTALL_PAUSE, 12000);  //SHAHAR
		capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 120000);
		capabilities.setCapability(IOSMobileCapabilityType.WDA_LAUNCH_TIMEOUT, 120000);
		capabilities.setCapability(IOSMobileCapabilityType.WDA_CONNECTION_TIMEOUT, 120000);
//		capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
		capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
//		capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
//		capabilities.setCapability(IOSMobileCapabilityType.NATIVE_INSTRUMENTS_LIB, true); //to delete if not needed
//		capabilities.setCapability("simpleIsVisibleCheck", true);
//		capabilities.setCapability("useFirstMatch", true);
//		capabilities.setCapability("reduceMotion", true);
		return capabilities;
	}
	
	
	public static DesiredCapabilities capabilitiesForIphoneWebSimulator(String appPath, String simulator, String port)
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP, appPath);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, simulator);
		capabilities.setCapability(MobileCapabilityType.UDID, CommandLineHelpers.getUDID(simulator));
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		capabilities.setCapability(IOSMobileCapabilityType.CONNECT_HARDWARE_KEYBOARD, true);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10800); //keep appium session alive for 3 hours (in seconds)

		//        capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
//		capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
//		capabilities.setCapability(IOSMobileCapabilityType.SIMPLE_ISVISIBLE_CHECK, true);
//		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, port + 1);
		capabilities.setCapability("useJSONSource", true);
//		capabilities.setCapability(IOSMobileCapabilityType.IOS_INSTALL_PAUSE, 12000);  //SHAHAR
		capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 120000);
		capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
		capabilities.setCapability(IOSMobileCapabilityType.AUTO_DISMISS_ALERTS, true);
		return capabilities;
	}
}
