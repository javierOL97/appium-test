import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class appiumTestLogIn {

    File f = new File("app\\build\\outputs\\apk\\debug");
    File fs = new File(f, "app-debug.apk");


    @Test
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_30_x86");
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);


    }

}
