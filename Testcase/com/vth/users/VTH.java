package com.vth.users;

import commons.*;
import commons.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.App;
import pageObjects.vth_AsnPage;
import pageObjects.vth_LoginPage;
import pageObjects.vth_LoginPage_App;
import pageObjects.vth_Nhan_HangPage_App;

import java.net.MalformedURLException;


public class VTH extends BasePage {
    private WebDriver driver;
    private AndroidDriver androidDriver;
    private vth_LoginPage loginPage;
    private vth_AsnPage asnPage;
    private App setup_app;
    private vth_Nhan_HangPage_App nhan_hang;
    private vth_LoginPage_App Login_app;
    private String username = "thangle1";
    private String password = "1234569";


    @BeforeClass
    public void BeforeClass() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().fullscreen();
        driver.get("https://wms-qc.vthealthcare.vn/login");
        loginPage = new vth_LoginPage(driver);
        asnPage = new vth_AsnPage(driver);
        setup_app = new App();
//        nhan_hang = new vth_Nhan_HangPage_App();
    }

    @Test(priority = 1)
    public void TC01_Login_Successfully() {
        loginPage.LoginToAppLication(username, password);
        System.out.println("đăng nhập thành công");
    }

    @Test(priority = 2)
    public void Create_ASN() throws InterruptedException {
        asnPage.Create_Asn("AIR"," 5 TON ", "50X134567", "1","1",
                "sg","1","MNCC11","000-00-17-0005","L1","2");
    }

    @Test(priority = 30)
    public void Update_ASN() throws InterruptedException {
        asnPage.Update_Asn("ASN-2504-000039","1. Chỉnh Sửa","Yes");
    }

    @Test(priority = 4)
    public void Create_Asns() throws InterruptedException {
        asnPage.Create_AsnS(1,"SEA"," 5 TON ", "50X134567", "1","1", "sg","1","MNCC11","000-00-17-0005","L1","2");
        System.out.println("tạo nhiều ans xong");
    }

    @Test(priority = 5)
    public void Login_App() throws MalformedURLException, InterruptedException {
        setup_app.Run_app();
        AndroidDriver androidDriver = setup_app.getDriver();
        Login_app = new vth_LoginPage_App(androidDriver);
        Login_app.login_App("thanglemb1","1234569");
        nhan_hang = new vth_Nhan_HangPage_App(androidDriver);
    }

    @Test(priority = 6)
    public void Nhan_Hang() throws InterruptedException {
        nhan_hang.Nhanhang();
        nhan_hang.Chup_Hinh_Dong_Cong();
        nhan_hang.Cap_Nhat_Container("1");
        //nhan_hang.Nhan_Hang_Good("2","123","PLT-2313-09424");
        nhan_hang.Nhan_Hang_Hong("2","CXL","123","hôm nay tôi buồn");
    }

    @AfterClass
    public void AfterClass(){
        //driver.close();
    }

}
