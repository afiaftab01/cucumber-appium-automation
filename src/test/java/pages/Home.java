package pages;


import actions.BaseActions;
import org.openqa.selenium.WebElement;

public class Home {

    private final BaseActions baseActions;
    public static String continue_cta = "//*[@content-desc='Continue']";
    public static String email_cta = "//android.widget.Button[@content-desc=\"Email\"]";
    public static String email = "test\n";
    public static String continue_email = "//android.widget.ImageView[@content-desc=\"Continue with Email\"]";
    public static String otp = "//android.view.View[@content-desc=\"OTP\"]/android.widget.EditText";
    public static String settings_cta = "//android.widget.ImageView[@content-desc=\"Settings\n" +
            "Tab 3 of 3\"]";
    public static String faq_cta = "//android.view.View[@content-desc=\"FAQ\"]";
    public static String web_faq_1 = "//*[@id=\"q1\"]/h4/strong";
    public static String back_btn = "test";
    public static String skip_cta = "//android.widget.Button[@content-desc=\"Skip\"]";

    public Home(){
         this.baseActions = new BaseActions();
    }

    public void clickContinueCta(){
        WebElement continue_ele = baseActions.getElementByXpath(continue_cta);
        baseActions.clickElement(continue_ele);
    }

    public void login() {
        WebElement email_ele = baseActions.getElementByXpath(email_cta);
        baseActions.clickElement(email_ele);
        WebElement email_cta = baseActions.getElementByXpath(email);
        baseActions.sendKeys(email_cta, "abc@gmail.com");
        WebElement continue_email_cta = baseActions.getElementByXpath(continue_email);
        baseActions.clickElement(continue_email_cta);
        WebElement otp_cta = baseActions.getElementByXpath(otp);
        baseActions.sendKeys(otp_cta, "000000");
    }

    public void navigateToSetttingsFaq(){
        WebElement settings_btn = baseActions.getElementByXpath(settings_cta);
        baseActions.clickElement(settings_btn);
        WebElement faq_btn = baseActions.getElementByXpath(faq_cta);
        baseActions.clickElement(faq_btn);
    }

    public void clickFaq1(){
        WebElement faq1 = baseActions.getElementByXpath(web_faq_1);
        baseActions.clickElement(faq1);
    }

    public void clickBackBtn(){
        WebElement bckbtn = baseActions.getElementByXpath(back_btn);
        baseActions.clickElement(bckbtn);
    }

    public void skipAndLogin() {
        WebElement skip = baseActions.getElementByXpath(skip_cta);
        baseActions.clickElement(skip);
        WebElement email_ele = baseActions.getElementByXpath(email_cta);
        baseActions.clickElement(email_ele);
        WebElement email_cta = baseActions.getElementByXpath(email);
        baseActions.sendKeys(email_cta, "abc@gmail.com");
        WebElement continue_email_cta = baseActions.getElementByXpath(continue_email);
        baseActions.clickElement(continue_email_cta);
        WebElement otp_cta = baseActions.getElementByXpath(otp);
        baseActions.sendKeys(otp_cta, "000000");
    }

    public void switchToWebView(){
        baseActions.switchToWebview();
    }

    public void switchToNative(){
        baseActions.switchToNativeApp();
    }

    public double compareScreenShot(){
       return baseActions.compareScreenShot();
    }

}
