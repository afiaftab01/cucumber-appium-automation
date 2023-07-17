package steps;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.Home;

public class StepDefinitions {

    private final Home home;
    private static final Logger logger = LogManager.getLogger(StepDefinitions.class);
    public StepDefinitions() {
        this.home = new Home();
    }


    @Given("user launched application")
    public void launchApplication() throws Throwable{
        logger.info("Application launch!");
    }

    @When("user click on the landing click button")
    public void userClickLandingCarousal() throws Throwable{
        home.clickContinueCta();
    }

    @Then("user verifies the landing text")
    public void userVerifyLandingCarosalText() throws Throwable{
        home.clickContinueCta();
        home.clickContinueCta();
        System.out.println("Threshold value after comparison :"+home.compareScreenShot());
    }

    @And("navigate to webview")
    public void navigateToWebview() {
        home.login();
        home.navigateToSetttingsFaq();
        try{
            Thread.sleep(5000);
        } catch(Exception e){
            System.out.println(e);
        }
        home.switchToWebView();
        home.clickFaq1();
        home.switchToNative();
        home.clickBackBtn();
    }

    @When("user skip and login")
    public void userSkipAndLogin() {
        home.skipAndLogin();
    }
}
