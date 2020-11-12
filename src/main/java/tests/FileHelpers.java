package tests;

import java.nio.file.Paths;

public class FileHelpers extends TestHelpers
{
    public static final String IOS_APP_PATH = getTestAppsFolderPath() + "kangreactnative.app";
    public static final String ANDROID_APP_PATH = getTestAppsFolderPath() + "app-khealth-release.apk";
    public static final String CHROME_DRIVER_PATH = getChromeDriverFolderPath() + "chromedriver";
    public static final String JSON_PATH = getTestDataFolderPath() + "Json.json";
    public static String LOCAL_ANDROID_DEBUG_APP_PATH = "/Users/shaharsheinfeld/GitProjects/kmono/kang-react-native/packages/app/android/app/build/outputs/apk/khealth/debug/app-khealth-debug.apk";
    public static String LOCAL_IOS_DEBUG_APP_PATH = "/Users/shaharsheinfeld/Library/Developer/Xcode/DerivedData/kangreactnative-ckwtjbrkqzyxqebafppnwleosjld/Build/Products/Debug-iphonesimulator/kangreactnative.app";
    
///////////////////////////Button ENUM
    public enum buttons
{
    YES
            {
                public String toString()
                {
                    return "option_0";
                }
            },
    
    NO
            {
                public String toString()
                {
                    return "chat_screen.tapToRespond";
                }
            },
    
    FIRST
            {
                public String toString()
                {
                    return "option_0";
                }
            },
    
    SECOND
            {
                public String toString()
                {
                    return "option_1";
                }
            },
    
    THIRD
            {
                public String toString()
                {
                    return "option_2";
                }
            },
    
    FORTH
            {
                public String toString()
                {
                    return "option_3";
                }
            },
    
    FIFTH
            {
                public String toString()
                {
                    return "option_4";
                }
            },
    
    SINGLE_BUTTON
            {
                public String toString()
                {
                    return "chat_screen.tapToRespond";
                }
            },
    
    NONE_OF_THE_ABOVE
    {
        public String toString()
        {
            return "chat_screen.tapToRespond";
        }
    }
}
// ///////////////////////////////////////////////////




//    public static String iosBundleID = "ai.kanghealth." + TestHelpers.env;
    public static String appPackageName = env.equals("staging") ? "ai.kanghealth.staging" : "ai.kanghealth.qadev";


    public static String getTestAppsFolderPath()
    {
        return Paths.get("src", "main", "java", "apps").toAbsolutePath().toString() + "/";
    }

    public static String getChromeDriverFolderPath()
    {
        return Paths.get("src", "main", "java", "chromeDriver").toAbsolutePath().toString() + "/";
    }

    public static String getTestDataFolderPath()
    {
        return Paths.get("src", "main", "java", "testData").toAbsolutePath().toString() + "/";
    }
}
