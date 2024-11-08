package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.LoginPageUI;

public class LoginPageObject extends BasePage {

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;


    public void enterEmailTextBox(String email) {
        waitForElementInVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.EMAIL_ADDRESS_TEXTBOX,"email");
    }

    public void enterPasswordTextBox(String password) {
        waitForElementVisible(driver,LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public void clickToLoginButton() {
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
    }
}
