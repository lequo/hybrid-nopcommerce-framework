package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static java.time.Duration.ofSeconds;

public class BasePage {

    public WebElement getElement(WebDriver driver, String locator){
        return driver.findElement(By.xpath(locator));
    }

    public void openPageUrl(WebDriver driver, String url){
        driver.get(url);
    }

    public String getPageSourceCode(WebDriver driver){
        return driver.getPageSource();
    }

    public Alert waitAlertPresence(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }

    public void forwardTopage(WebDriver driver){
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }

    public void acceptToAlert(WebDriver driver){
        waitAlertPresence(driver).accept();
    }

    public void cancelToAlert(WebDriver driver){
        waitAlertPresence(driver).dismiss();
     }

    public String getToAlert(WebDriver driver){
        return waitAlertPresence(driver).getText();
    }

    public void sendKeyToAlert(WebDriver driver, String sendkey){
        waitAlertPresence(driver).sendKeys(sendkey);
    }

    public void switchToWindowById(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
            }
        }
        driver.close();
    }

    public void closeAllWindowsWithouParent(WebDriver driver, String parentID){
        Set<String> allWindows = driver.getWindowHandles();
        for(String runWindows : allWindows){
            if(!runWindows.equals(parentID)){
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public void clickToElement(WebDriver driver, String locator){
        getElement(driver, locator).click();
    }

    public void sendKeyToElement(WebDriver driver,String localtor, String sendkeys){
        getElement(driver, localtor).sendKeys(sendkeys);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String textItem){
        new Select(getElement(driver, locator)).selectByVisibleText(textItem);
    }

    public String getSelectItemInDropdown(WebDriver driver, String locator){
        return new Select (getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public boolean isDropdowMultiple(WebDriver driver, String locator){
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem ){
        driver.findElement(By.xpath(parentLocator)).click();
        sleepInSeconds(2);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));

        for(WebElement item : allItems){
            if(item.getText().trim().equals(expectedItem)){
                item.click();
                break;
            }
        }
    }

    public void sleepInSeconds(long time){
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
