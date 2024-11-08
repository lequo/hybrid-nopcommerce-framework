package com.nopcommece.users;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object extends BaseTest {

    private WebDriver driver;
    // hàm khởi taọ (constrctor function)
    //1.  cùng tên với claass
    //2. không có kiểu trả về
    //3. chạy đầu tiên khi class này đc gọi
    //4. có tham số hoạc k
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;


    public Level_03_Page_Object(WebDriver driver) {
        this.driver = driver;
    }

    private String first_name = "hi";
    private String middle_name = "si";
    private String last_name =" it";
    private String email = "lequoc@gmail.com";
    private String password = "Aa123465";
    private String conirirm_password = "Aa123465";

    @BeforeClass
    public void beforClass(){
        driver = new ChromeDriver();
        driver.get("https://live.techpanda.org/");

        homePage = new HomePageObject(driver);
        loginPage = new LoginPageObject(driver);
        registerPage = new RegisterPageObject(driver);
    }

    @Test
    public void User_Register(String first_name, String middle_name, String last_name, String email, String password, String conirirm_password){
        homePage.clickToRegisterLink();

        registerPage.sendKeyToFirstName(first_name);
        registerPage.sendKeyToMiddleName(middle_name);
        registerPage.sendKeyToLastName(last_name);
        registerPage.sendKeyToEmailAddress(email);
        registerPage.sendKeyToPassword(password);
        registerPage.sendKeyToConfirmPassword(conirirm_password);
        registerPage.clickToRegisterButton();
//        Assert.assertEquals("","");
    }

    @Test
    public void User_Login(){
        //từ register page qua homepage
        //
        loginPage.enterEmailTextBox(email);
        loginPage.enterPasswordTextBox(password);
        loginPage.clickToLoginButton();
        //Assert.assertTrue();
    }

    @Test
    public void User_My_account(){
        // từ login qua màn hình my account

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
