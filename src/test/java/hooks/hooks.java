package hooks;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import test.MobileDriver;

public class hooks {
    private static AppiumDriver driver;

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("#################################Cucumber Before######################################");
        driver = MobileDriver.initializeAndroidDriver();
    }

    @After
    public void ScenarioTearDown(Scenario scenario) {
        System.out.println("#################################Cucumber After######################################");
        System.out.println("Tear Down section.!");
        driver = MobileDriver.getAndroidDriver();
        if (scenario.isFailed()) {
            // Capture screenshot on test failure

            TakesScreenshot screenshot = driver;
            byte[] screenshotData = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotData, "image/png", "FailureScreenshot");
        }

        // Close the driver instance
        System.out.println("Driver quit!");
        MobileDriver.quitDriver();
    }
}
