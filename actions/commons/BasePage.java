package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import javax.swing.text.Element;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import static java.time.Duration.ofSeconds;
import static javax.swing.text.html.CSS.getAttribute;

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

    public String getElementAttribute(WebDriver driver, String locator, String attributeName){
        return getElement(driver, locator).getAttribute(attributeName);
    }

    public String getText(WebDriver driver, String locator){
        return getElement(driver, locator).getText();
    }

    public String getCssValue(WebDriver driver, String locator, String css){
        return getElement(driver, locator).getCssValue(css);
    }

    // get ra bang mau
    public String getHexaColorFromRGBA(String rgbaValue){
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public List<WebElement> getListElement(WebDriver driver, String locator){
        return driver.findElements(By.xpath(locator));
    }

    public void checkToCheckboxRadio(WebDriver driver, String locator){
        if(!getElement(driver,locator).isSelected()){
            getElement(driver,locator).click();
        }
    }

    public void checkToCheckbox(WebDriver driver, String locator){
        if(getElement(driver,locator).isSelected()){
            getElement(driver,locator).click();
        }
    }

    public boolean isControlDisplayed(WebDriver driver, String locator){
        return getElement(driver,locator).isDisplayed();
    }

    public boolean isControlSelected(WebDriver driver, String locator){
        return getElement(driver,locator).isSelected();
    }

    public boolean isControlEnabled(WebDriver driver, String locator){
        return getElement(driver,locator).isEnabled();
    }

    public void switchto (WebDriver driver, String locator){
        driver.switchTo().frame(getElement(driver,locator));
    }

    public void switchToDefaultPage(WebDriver driver, String locator){
        driver.switchTo().defaultContent();
    }

    public void hoveToElement(WebDriver driver, String locator){
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }

    public void clickAndHoldToElement(WebDriver driver, String locator){
        new Actions(driver).clickAndHold(getElement(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator){
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator){
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }

    public void drapAndropElement(WebDriver driver, String targetLocator, String sourceLocator){
        new Actions(driver).dragAndDrop(getElement(driver,sourceLocator), getElement(driver,targetLocator)).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys keys){
        new Actions(driver).sendKeys(getElement(driver,locator), keys).perform();
    }

    public int getListElementNumber(WebDriver driver, String locator){
         return getListElement(driver, locator).size();
    }

    public void sleepInSeconds(long time){
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJs(WebDriver driver, String url){
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollheight)");
    }

    public void hightlightElement(WebDriver driver, String locator){
        WebElement element = getElement(driver, locator);

        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAtrtibute('style', arguments[1])", element, "border: 2px solid red;");
        sleepInSeconds(2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJs(WebDriver driver, String locator){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", getElement(driver, locator));
    }

    public void crollToElementOnTopByJs(WebDriver driver, String locator){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", getElement(driver, locator));
    }

    public void scrollToElementsOnDownByJs(WebDriver driver,String locator){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", getElement(driver, locator));
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue){
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute(' "+attributeName + " ');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemmove){
        ((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('" + attributeRemmove+ "');", getElement(driver, locator));
    }

    public String getAttributeInDOM(WebDriver driver, String locator, String attributeName){
        return (String) ((JavascriptExecutor)driver).executeScript("arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator){
        boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(driver, locator));
        return status;
    }

    public By getByXpath(String locator){
        return By.xpath(locator);
    }

    public void waitForElementVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
    }

    public void waitForElementInVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(70)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitForElemetClickable(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

}
