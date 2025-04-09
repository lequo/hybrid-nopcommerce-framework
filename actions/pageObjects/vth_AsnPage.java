package pageObjects;

import commons.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pageUis.Vth_AsnUI.*;

public class vth_AsnPage extends BasePage {
    private WebDriver driver;

    public vth_AsnPage(WebDriver driver) {
        this.driver = driver;
    }

    public void Click_Create_Asn() throws InterruptedException {
        // Định nghĩa locator dưới dạng String
        String locator = "//button[@tabindex='24']";

        // Chờ cho phần tử hiển thị
        waitForElementVisible(driver, locator);

        // Tìm lại phần tử ngay trước khi click
        WebElement button = driver.findElement(By.xpath(locator));

        // Nếu cần, có thể thêm chờ ngắn (tùy thuộc vào tình huống)
        Thread.sleep(100);

        // Thực hiện click bằng JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public void Click_Create_Asn_Good(){
        waitForElemetClickable(driver, IMPORT_GOODS);
        waitForElemetClickable(driver, CLICK_ASN);
    }

    public void Create_Asn(String Mot, String Loai_Container, String So_Container, String So_Van_Don,
                           String Voy_No, String Khoi_Hang, String Hoa_Don, String Tu, String Ma_Hang,
                           String Vi_Tri_Thung, String So_Luong_Du_kien) throws InterruptedException {
        Click_Create_Asn_Good();
        Click_Create_Asn();
        Enter_Information(Mot,Loai_Container,So_Container, So_Van_Don,
                Voy_No,Khoi_Hang,Hoa_Don,Tu,Ma_Hang,Vi_Tri_Thung,So_Luong_Du_kien);
    }

    public void Create_AsnS(int bao_nhieu_ma_hang,String Mot, String Loai_Container, String So_Container, String So_Van_Don,
                            String Voy_No, String Khoi_Hang, String Hoa_Don, String Tu, String Ma_Hang,
                            String Vi_Tri_Thung, String So_Luong_Du_kien) throws InterruptedException {
        Thread.sleep(1000);
        Click_Create_Asn();
        Enter_Information(Mot,Loai_Container,So_Container, So_Van_Don, Voy_No,Khoi_Hang,Hoa_Don,Tu,Ma_Hang,Vi_Tri_Thung,So_Luong_Du_kien);
        if(bao_nhieu_ma_hang>1){
            for (int i=1;i<bao_nhieu_ma_hang;i++){
               clickToElement(driver,BTN_THEM_MA_HANG);
                Enter_Information(Mot,Loai_Container,So_Container, So_Van_Don, Voy_No,Khoi_Hang,Hoa_Don,Tu,Ma_Hang,Vi_Tri_Thung,So_Luong_Du_kien);
                System.out.println("so ma hagn"+i);
            }
            Thread.sleep(1000);
            clickToElement(driver,BTN_THEM_MA_HANG);
        }
    }

    public void Enter_Information(String Mot, String Loai_Container, String So_Container, String So_Van_Don,
                                  String Voy_No, String Khoi_Hang, String Hoa_Don, String Tu, String Ma_Hang, String Vi_Tri_Thung, String So_Luong_Du_kien) {

        waitForElementVisible(driver, MOT_AIR);
        selectItemInDropdown(driver, MOT_AIR, Mot);

        waitForElementVisible(driver, TYPE_CONTAINER);
        selectItemInDropdown(driver, TYPE_CONTAINER, Loai_Container);

        waitForElementVisible(driver, NUMBER_CONTAINER);
        sendKeyToElement(driver, NUMBER_CONTAINER, So_Container);

        waitForElementVisible(driver, SO_VAN_DON);
        sendKeyToElement(driver, SO_VAN_DON, So_Van_Don);

        waitForElementVisible(driver, VOY_NO);
        sendKeyToElement(driver, VOY_NO, Voy_No);

        waitForElementVisible(driver, VESSEL);
        sendKeyToElement(driver, VESSEL, Voy_No);

        waitForElementVisible(driver, NOI_KHOI_HANG);
        sendKeyToElement(driver, NOI_KHOI_HANG, Khoi_Hang);

        waitForElementVisible(driver, SO_HOA_DON);
        sendKeyToElement(driver, SO_HOA_DON, Hoa_Don);

        waitForElementVisible(driver, TU);
        sendKeyToElement(driver,TU,Tu);

        waitForElementVisible(driver, MA_HANG);
        sendKeyToElement(driver,MA_HANG,Ma_Hang);

        waitForElementClickable(driver,VI_TRI_THUNG);
        selectItemInDropdown(driver,VI_TRI_THUNG,Vi_Tri_Thung);

        waitForElementClickable(driver,SO_LUONG_DU_KIEN);
        sendKeyToElement(driver,SO_LUONG_DU_KIEN,So_Luong_Du_kien);

        clickToElement(driver,Luu);
    }

    public void Update_Asn(String asnValue, String Muon, String confirmDeletion) throws InterruptedException {
        String rowLocator = "//table[contains(@class,'vuetable')]//tbody[@class='vuetable-body']/tr[td//a[contains(text(),'" + asnValue + "')]]";
        String checkboxLocator = rowLocator + "//td[contains(@class,'vuetable-td-component-checkbox')]//input";
        waitForElementVisible(driver, rowLocator);
        waitForElementClickable(driver, checkboxLocator);
        clickToElement(driver, checkboxLocator);

        switch (Muon) {
            case "1. Chỉnh Sửa":
                hoverAndSelectDropdown(driver,HANG_DONG,HIEN_THI_HANH_DONG,Muon);
                clickToElement(driver,BTN_LUU);
                break;
            case "2. Nhân Bản ASN":
                //hoverAndSelectDropdown(driver,HANG_DONG,HIEN_THI_HANH_DONG,Vi_Tri);
                break;
            case "3. Hoàn Thành ASN":
                hoverAndSelectDropdown(driver,HANG_DONG,HIEN_THI_HANH_DONG,Muon);
                break;
            case "4. Hủy ASN":

                break;
            case "5. In Bảng Kiểm Đếm":

                break;
            case "6. Tải Bảng Kiểm Đếm":
                if("Yes".equalsIgnoreCase(confirmDeletion)){
                    clickToElement(driver,BTN_CO);
                }
                else {
                    clickToElement(driver,BTN_KHONG);
                }
                break;
            case "7. Xuất Chi Tiết":
                // Code khi expression == value2
                break;
            case "8. In Công Nhập":
                // Code khi expression == value2
                break;
            case "9. Tải hình ảnh Công":
                // Code khi expression == value2
                break;
            case "10. Print Putaway":
                // Code khi expression == value2
                break;
            case "11. Tải thông tin PLT":
                // Code khi expression == value2
                break;
            case "12. Download Serial List":
                // Code khi expression == value2
                break;
            default:
                // Code khi không khớp với case nào
                break;
        }
    }

}
