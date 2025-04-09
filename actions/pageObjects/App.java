package pageObjects;

import commons.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class App extends BasePage {
    private AndroidDriver androidDriver;

    public App() {

    }

    public void Run_app() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "realme ui");
        caps.setCapability("udid", "89XKCI4XDUVKAU45");
        caps.setCapability("platformVersion", "14");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "D:\\VTHealthCare_WMS_1.0.5_qc.apk");
        caps.setCapability("noReset", true);
        // Tạo AndroidDriver (phiên bản 8.x của Appium Java Client không generic)
       androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4724/wd/hub"), caps);
        System.out.println("Session started on Android!");
    }

     public AndroidDriver getDriver() {
        return androidDriver;
    }
}