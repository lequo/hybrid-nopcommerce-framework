package com.nopcommece.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class User_01_Register_login {
    WebDriver driver;

    @BeforeClass
    public void beforeclass(){
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void TC_01_Register(){

    }

    @Test
    public void TC_02_Register(){

    }

    @Test
    public void TC_03_Register(){

    }

    @AfterClass
    public void afterclass(){
        //driver.quit();
    }

}
