package com.nopcommece.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.IOException;
import java.time.Duration;

public class Level_01_Repeat_Youself {
    WebDriver driver;

    String firsName, lastName, day, month, year, emailAddress, companyName, password;

    @BeforeClass
    public void beforeclass() {
        // Thiết lập proxy và User-Agent
        ChromeOptions options = new ChromeOptions();
        // ... rest of your options configuration ...
        String proxy = "116.203.139.209"; // Thay thế bằng proxy hợp lệ
        options.addArguments("--proxy-server=http://" + proxy);

        // **Khởi tạo ChromeDriver với các tùy chọn trước khi sử dụng**
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com");
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
        driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"gender-male\"]")).click();
        driver.findElement(By.xpath("//a[@//input[@id=\"FirstName\"]")).sendKeys(firsName);
        driver.findElement(By.xpath("//a[@//input[@id=\"LastName\"]")).sendKeys(lastName);
        new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]"))).selectByVisibleText(day);
        new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"))).selectByVisibleText(month);
        new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]"))).selectByVisibleText(year);
        driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id=\"Company\"]")).sendKeys(companyName);
        driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id=\"register-button\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
    }

    @Test
    public void TC_02_Login() {
        driver.findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
        driver.findElement(By.xpath("//input[@class=\"email\"]")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).isDisplayed());
    }

    @Test
    public void TC_03_MyAccount() {
        driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).click();
        //Assert.assertEquals(driver.findElement(By.xpath("//input[@name=\"Gender\"]")).getAttribute("value"), "M");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name=\"FirstName\"]")).getAttribute("value"), firsName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"LastName\"]")).getAttribute("value"), lastName);
        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]"))).getFirstSelectedOption().getText(), day);
        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"))).getFirstSelectedOption().getText(), month);
        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]"))).getFirstSelectedOption().getText(), year);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"Email\"]")).getAttribute("value"), emailAddress);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"Company\"]")).getAttribute("value"), companyName);
    }

    @AfterClass
    public void afterclass() {
        driver.quit();
    }

}
