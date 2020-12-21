import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class appiumTestLogIn {

    File f = new File("build\\outputs\\apk\\debug");
    File fs = new File(f, "app-debug.apk");
    AndroidDriver<AndroidElement> driver;

    MobileElement emailElement;
    MobileElement passwordElement;
    MobileElement buttonElement;

    @Before
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_30_x86");
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

        emailElement = driver.findElementByXPath(
                "//android.widget.EditText[@text='Email']");
        passwordElement = driver.findElementByXPath(
                "//android.widget.EditText[@text='Password']");
        buttonElement =  driver.findElementByXPath(
                "//android.widget.Button[@text='SIGN IN OR REGISTER']");
    }

    @Test
    public void login(){
        emailElement.sendKeys("fcoortiz972@gmail.com");
        passwordElement.sendKeys("password");
        buttonElement.click();
    }

    @Test
    public void assertLessThan5(){
        //Assert button is disabled when password length is < 5
        assert(!buttonElement.isEnabled());
    }

    @Test
    public void assertTextViewEqualUsername() {
        String emailString = "fcoortiz972@gmail.com";
        emailElement.sendKeys(emailString);
        passwordElement.sendKeys("password");
        buttonElement.click();

        MobileElement textView =  driver.findElementByXPath(
                "//android.widget.TextView[@text='Hello "+ emailString+"']");
        Assert.assertEquals(textView.getText(), "Hello "+emailString);
    }
}
