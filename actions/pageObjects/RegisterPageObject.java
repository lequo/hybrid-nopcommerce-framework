package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageUis.HomePageUI;
import pageUis.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;


    public void sendKeyToFirstName(String s) {
        waitForElementInVisible(driver,RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX,s);
    }

    public void sendKeyToMiddleName(String s) {
        waitForElementInVisible(driver,RegisterPageUI.MIDDLE_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.MIDDLE_NAME_TEXTBOX," ");
    }

    public void sendKeyToLastName(String s) {
        waitForElementInVisible(driver,RegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.LAST_NAME_TEXTBOX," ");
    }

    public void sendKeyToEmailAddress(String s) {
        waitForElementInVisible(driver,RegisterPageUI.EMAIL_ADRESS_TEXBOX);
        sendKeyToElement(driver,RegisterPageUI.EMAIL_ADRESS_TEXBOX," ");
    }

    public void sendKeyToPassword(String s) {
        waitForElementInVisible(driver,RegisterPageUI.PASSWORD_TEXT_BOX);
        sendKeyToElement(driver,RegisterPageUI.PASSWORD_TEXT_BOX," ");
    }

    public void sendKeyToConfirmPassword(String s) {
        waitForElementInVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX);
        sendKeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX," ");
    }

    public void clickToRegisterButton() {
        clickToElement(driver,RegisterPageUI.CLICK_REGISTER_BUTTON);
    }
}
