package pageObjects;

import commons.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import pageUis.Vth_LoginPageUI_App;
import pageUis.Vth_NhanHangUI_App;

public class vth_Nhan_HangPage_App extends BasePage {
    private AndroidDriver driver;

    public vth_Nhan_HangPage_App(AndroidDriver driver) {
        this.driver = driver;
    }

    public void Nhanhang () throws InterruptedException {
        waitForElementClickable(driver, Vth_NhanHangUI_App.NHANHANG);
        waitForElementClickable(driver,Vth_NhanHangUI_App.Ma_ASN);
        waitForElementClickable(driver,Vth_NhanHangUI_App.CLICK_CHUP_CUA_CONTAINER);
        take_A_Photo(driver,Vth_NhanHangUI_App.AN_NUT_CHUP,Vth_NhanHangUI_App.XAC_NHAN_HINH);

        waitForElementClickable(driver,Vth_NhanHangUI_App.CLICK_CHUP_BIEN_SO);
        take_A_Photo(driver,Vth_NhanHangUI_App.AN_NUT_CHUP,Vth_NhanHangUI_App.XAC_NHAN_HINH);
        swipeDown(driver,0.5,0.3);

        waitForElementClickable(driver,Vth_NhanHangUI_App.CLICK_SO_NIEM_PHONG);
        take_A_Photo(driver,Vth_NhanHangUI_App.AN_NUT_CHUP,Vth_NhanHangUI_App.XAC_NHAN_HINH);
        waitForElementClickable(driver,Vth_NhanHangUI_App.CLICK_LUU);
        waitForElementClickable(driver,Vth_NhanHangUI_App.CLICK_DONG);
    }

    public void Chup_Hinh_Dong_Cong(){
        waitForElemetClickable(driver,Vth_NhanHangUI_App.CLICK_CHUP_DONG_CONG);
        waitForElementClickable(driver,Vth_NhanHangUI_App.CLICK_CAMERA_DONG_CONG);
        take_A_Photo(driver,Vth_NhanHangUI_App.AN_NUT_CHUP,Vth_NhanHangUI_App.XAC_NHAN_HINH);
        waitForElementClickable(driver,Vth_NhanHangUI_App.CLICK_LUU_DONG_CONG);
        waitForElementClickable(driver, Vth_NhanHangUI_App.CLICK_DONG_CONG);
    }

    public void Cap_Nhat_Container(String So_Seal){
        waitForElemetClickable(driver,Vth_NhanHangUI_App.CLICK_CAP_NHAT_CONTAINER_VA_SO_NIEM_PHONG);
        waitForElementClickable(driver,Vth_NhanHangUI_App.SO_SEAL);
        sendKeyToElement(driver,Vth_NhanHangUI_App.SO_SEAL,So_Seal);
        waitForElementClickable(driver,Vth_NhanHangUI_App.AN_LUU);
        waitForElementClickable(driver,Vth_NhanHangUI_App.AN_DONG);
    }

    public void Nhan_Hang_Good(String Ctns, String Vi_Tri, String Pallet){
        waitForElementClickable(driver,Vth_NhanHangUI_App.CLICK_VAO);

        waitForElemetClickable(driver,Vth_NhanHangUI_App.CTNS_DANG_NHAN);
        sendKeyToElementable(driver,Vth_NhanHangUI_App.CTNS_DANG_NHAN,Ctns);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

        waitForElemetClickable(driver,Vth_NhanHangUI_App.VI_TRI);
        sendKeyToElementable(driver,Vth_NhanHangUI_App.VI_TRI,Vi_Tri);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        swipeDown(driver,0.2,0.3);

        waitForElemetClickable(driver,Vth_NhanHangUI_App.PALLET);
        sendKeyToElementable(driver,Vth_NhanHangUI_App.PALLET,Pallet);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        waitForElementClickable(driver,Vth_NhanHangUI_App.LUU_NHAN_HANG);
    }

    public void Nhan_Hang_Hong(String So_Ctns_Hong, String Vi_Tri_Thung,String Vi_Tri_Hang_Hong, String Mo_Ta){
        waitForElementClickable(driver,Vth_NhanHangUI_App.CLICK_VAO);

        sendKeyToElement(driver,Vth_NhanHangUI_App.SO_CTNS_BI_HONG,So_Ctns_Hong);

        selectItemInDropdown(driver,Vth_NhanHangUI_App.VI_TRI_THUNG,Vi_Tri_Thung);

        sendKeyToElementable(driver,Vth_NhanHangUI_App.VI_TRI_HANG_HONG,Vi_Tri_Hang_Hong);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        swipeDown(driver,0.3,0.5);

        sendKeyToElementable(driver,Vth_NhanHangUI_App.MOTA,Mo_Ta);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

        clickToElement(driver,Vth_NhanHangUI_App.CLICK_LUU_HANG_HONG);
    }
}
