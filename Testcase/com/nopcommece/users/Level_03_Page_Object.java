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
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;

    private String first_name = "hi";
    private String middle_name = "si";
    private String last_name = "it";
    private String email = "lequoc@gmail.com";
    private String password = "Aa123465";
    private String confirm_password = "Aa123465";

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.get("https://live.techpanda.org/");

        homePage = new HomePageObject(driver);
        loginPage = new LoginPageObject(driver);
        registerPage = new RegisterPageObject(driver);
    }

    @Test
    public void Tc_01_User_Register(){
        homePage.clickToRegisterLink();

        registerPage.sendKeyToFirstName(first_name);
        registerPage.sendKeyToMiddleName(middle_name);
        registerPage.sendKeyToLastName(last_name);
        registerPage.sendKeyToEmailAddress(email);
        registerPage.sendKeyToPassword(password);
        registerPage.sendKeyToConfirmPassword(confirm_password);
        registerPage.clickToRegisterButton();

        // Uncomment this if there's an assertion to verify registration success
        // Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");
    }

    @Test
    public void Tc_02_User_Login(){
        loginPage.enterEmailTextBox(email);
        loginPage.enterPasswordTextBox(password);
        loginPage.clickToLoginButton();

        // Uncomment this if there's an assertion to verify login success
        // Assert.assertTrue(homePage.isMyAccountLinkDisplayed(), "My Account link is not displayed");
    }

    @Test
    public void User_My_account(){
        // Implement this test case as per your requirements.
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
