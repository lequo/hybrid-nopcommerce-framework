package pageObjects;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.Vth_LoginUi;

public class vth_LoginPage extends BasePage{
    private WebDriver driver;

    public vth_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void LoginToAppLication(String ten, String mk) {
        waitForElementVisible(driver, Vth_LoginUi.FIRST_NAME_TEXTBOX);
       sendKeyToElement(driver, Vth_LoginUi.FIRST_NAME_TEXTBOX,ten);
       sendKeyToElement(driver, Vth_LoginUi.PASS_WORD_TEXTBOX,mk);
       clickToElement(driver, Vth_LoginUi.BUTTON_LOGIN);
    }

}
