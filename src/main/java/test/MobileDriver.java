package test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriver {
    private static AppiumDriver driver;
    private static AppiumDriver pwadriver;

    public static AppiumDriver initializeAndroidDriver() {
        String projectPath = System.getProperty("user.dir");
        String apkPath = projectPath + GlobalConstants.apkPath;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.APP, new File(apkPath).getAbsolutePath());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.org.app");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.club.MainActivity");
        capabilities.setCapability("timeouts", "{ \"implicit\": 30000, \"pageLoad\": 60000, \"script\": 30000 }");
        // Add other desired capabilities as needed

        try {
            driver = new AndroidDriver(new URL("http://localhost:4723/"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static AppiumDriver getAndroidDriver() {
        if (driver == null) {
          driver =  initializeAndroidDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
