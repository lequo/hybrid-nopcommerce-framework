package com.nopcommece.users;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Level_02_Base_Page_Init {
    WebDriver driver;
    BasePage basePage; // khai báo

    String firsName, lastName, day, month, year, emailAddress, companyName, password;

    @BeforeClass
    public void beforeclass() {
        basePage = new BasePage(); // khởi tạo
        driver = new ChromeDriver();
        driver.get("https://nopcommerce.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        firsName = "le";
        lastName = "quoc";
        day = "13";
        month = "July";
        year = "2002";
        emailAddress = "lequoc@gmail.com";
        companyName = "lqt";
        password = "0123456";
    }

    @Test
    public void TC_01_Register() {
        basePage.clickToElement(driver, "//a[@class=\"ico-register\"]");
        basePage.clickToElement(driver,"//input[@id=\"gender-male\"]");
        basePage.sendKeyToElement(driver,"//a[@//input[@id=\"FirstName\"]", firsName);
        basePage.getElement(driver,"//a[@//input[@id=\"LastName\"]").sendKeys(lastName);
        new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]"))).selectByVisibleText(day);
        new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"))).selectByVisibleText(month);
        new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]"))).selectByVisibleText(year);
        basePage.sendKeyToElement(driver,"//input[@type=\"email\"]", emailAddress);
        basePage.sendKeyToElement(driver,"//input[@id=\"Company\"]", companyName);
        basePage.sendKeyToElement(driver,"//input[@id=\"Password\"]", password);
        basePage.sendKeyToElement(driver,"//input[@id=\"ConfirmPassword\"]", password);
        basePage.clickToElement(driver,"//button[@id=\"register-button\"]");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
    }

    @Test
    public void TC_02_Login() {
        basePage.clickToElement(driver,"//a[@class=\"ico-login\"]");
        basePage.sendKeyToElement(driver, "//input[@class=\"email\"]", emailAddress);
        basePage.sendKeyToElement(driver,"//input[@id=\"Password\"]", password);
        basePage.clickToElement(driver,"//button[@class=\"button-1 login-button\"]");
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).isDisplayed());
    }

    @Test
    public void TC_03_MyAccount() {
        driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).click();
        //Assert.assertEquals(driver.findElement(By.xpath("//input[@name=\"Gender\"]")).getAttribute("value"), "M");
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@name=\"FirstName\"]","value"),firsName);
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id=\"LastName\"]","value"),lastName);

        Assert.assertEquals(new Select(basePage.getElement(driver, "//select[@name=\"DateOfBirthDay\"]")).getFirstSelectedOption().getText(), day);
        Assert.assertEquals(new Select(basePage.getElement(driver,"//select[@name=\"DateOfBirthMonth\"]")).getFirstSelectedOption().getText(), month);
        Assert.assertEquals(new Select(basePage.getElement(driver,"//select[@name=\"DateOfBirthYear\"]")).getFirstSelectedOption().getText(), year);
        Assert.assertEquals(basePage.getElement(driver,"//input[@id=\"Email\"]").getAttribute("value"), emailAddress);
        Assert.assertEquals(basePage.getAttributeInDOM(driver,"//input[@id=\"Company\"]", "value"), companyName);
    }

    @AfterClass
    public void afterclass() {
        driver.quit();
    }

}
