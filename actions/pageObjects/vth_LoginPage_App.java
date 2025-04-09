package pageObjects;

import commons.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUis.Vth_LoginPageUI_App;

import java.time.Duration;

public class vth_LoginPage_App extends BasePage {
    private AndroidDriver driver;

    public vth_LoginPage_App(AndroidDriver driver) {
        this.driver = driver;
    }

    public void login_App(String Ten_Dang_Nhap, String Mat_Khau){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Vth_LoginPageUI_App.NAME)));
        clickToElement(driver,Vth_LoginPageUI_App.NAME);

        // Không cần tìm lại phần tử NAME ngay sau khi click
        sendKeyToElement(driver, Vth_LoginPageUI_App.NAME,Ten_Dang_Nhap);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Vth_LoginPageUI_App.MATKHAU)));
        clickToElement(driver,Vth_LoginPageUI_App.MATKHAU);
        sendKeyToElement(driver,Vth_LoginPageUI_App.MATKHAU, Mat_Khau);

        swipeDown(driver,0.4, 0.2);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Vth_LoginPageUI_App.DANG_NHAP)));
        clickToElement(driver,Vth_LoginPageUI_App.DANG_NHAP);
    }
}
