package actions;

import io.appium.java_client.remote.SupportsContextSwitching;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.imagecomparison.OccurrenceMatchingOptions;
import io.appium.java_client.imagecomparison.OccurrenceMatchingResult;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.MobileDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Set;


public class BaseActions {

    private final AppiumDriver driver;

    public BaseActions() {
        this.driver = MobileDriver.getAndroidDriver();
    }

    public WebElement getElementByXpath(String element){
        waitForPresenceOfEle(element);
        WebElement ele = this.driver.findElement(new By.ByXPath(element));
        return ele;
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void sendKeys(WebElement element, String keys){
        element.sendKeys(keys);
    }

    public String getElementText(String element){
        WebElement ele = this.driver.findElement(new By.ByXPath(element));
        return ele.getText();
    }

    public WebElement waitForPresenceOfEle(String ele){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath(ele)));
        return element;
    }

    public double compareScreenShot(){
        String baseImagePath="~/images/baseimages.png";
        String screenshotPath="~/images/page_screenshot.png";
        TakesScreenshot screenshotDriver = this.driver;
        File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            System.out.println("Screenshot saved: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file1 = new File(baseImagePath);
        File file2 = new File(screenshotPath);
        SimilarityMatchingResult result = null;
        try {
            result = this.driver.getImagesSimilarity(file2, file1,new SimilarityMatchingOptions().withEnabledVisualization());
            byte[] opImageData = result.getVisualization();
            byte[] decodedBytes = Base64.getDecoder().decode(opImageData);
            File opFile = new File("~/images/visual_result.png");
            FileUtils.writeByteArrayToFile(opFile, decodedBytes);
            System.out.println("Similarity Score "+result.getScore());
//            double threshold = 80;
//            assertTrue(result.getScore()>threshold, "Visual Assertion, Similarity check failed threshold not matched, Expected(Greather then) :"+threshold+" But Actual Score is :"+result.getScore());
        } catch (IOException e) {
            e.printStackTrace();
//            assertTrue(false, "Visual Assertion, Images are not of same size");
        }
        return result.getScore();
    }

    public void switchToWebview(){
        try {
            Thread.sleep(5000);
        } catch(Exception e){
            System.out.println(e);
        }
        Set<String> contextNames = ((SupportsContextSwitching) this.driver).getContextHandles();
        System.out.println("Context names :"+contextNames);
        for (String contextName : contextNames) {
            if (contextName.contains("WEBVIEW")) {
                ((SupportsContextSwitching) this.driver).context(contextName);
                break;
            }
        }
    }

    public void switchToNativeApp(){
        ((SupportsContextSwitching) this.driver).context("NATIVE_APP");
    }

}
