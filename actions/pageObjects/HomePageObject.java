package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageUis.HomePageUI;

public class HomePageObject extends BasePage {

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;


    public void clickToRegisterLink() {
        clickToElement(driver, HomePageUI.Click_Account);
        clickToElement(driver, HomePageUI.Register_link);
    }

}
