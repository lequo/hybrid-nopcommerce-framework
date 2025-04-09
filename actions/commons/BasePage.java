package commons;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.time.Duration.ofSeconds;
import static javax.swing.text.html.CSS.getAttribute;
import static org.openqa.selenium.By.xpath;

public class BasePage {



    public WebElement getElementXpath(WebDriver driver, String locator){
        return driver.findElement(xpath(locator));
    }

    public WebElement getElementId(WebDriver driver, String locator){
        return driver.findElement(By.id(locator));
    }

    public void openPageUrl(WebDriver driver, String url){
        driver.get(url);
    }

    public String getPageSourceCode(WebDriver driver){
        return driver.getPageSource();
    }

    public Alert waitAlertPresence(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(15));
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
        getElementXpath(driver, locator).click();
    }

    public void sendKeyToElement(WebDriver driver,String localtor, String sendkeys){
        getElementXpath(driver, localtor).sendKeys(sendkeys);
    }

    public void sendKeyToElementable(WebDriver driver,String localtor, String sendkeys){
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(getByXpath(localtor)))
                 .sendKeys(sendkeys);
    }


    public void selectItemInDropdown(WebDriver driver, String locator, String textItem){
        new Select(getElementXpath(driver, locator)).selectByVisibleText(textItem);
    }

    public String getSelectItemInDropdown(WebDriver driver, String locator){
        return new Select (getElementXpath(driver, locator)).getFirstSelectedOption().getText();
    }

    public boolean isDropdowMultiple(WebDriver driver, String locator){
        return new Select(getElementXpath(driver, locator)).isMultiple();
    }

    public void selectItemCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem ){
        driver.findElement(xpath(parentLocator)).click();
        sleepInSeconds(2);
        List<WebElement> allItems = new WebDriverWait(driver, ofSeconds(15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpath(childItemLocator)));

        for(WebElement item : allItems){
            if(item.getText().trim().equals(expectedItem)){
                item.click();
                break;
            }
        }
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName){
        return getElementXpath(driver, locator).getAttribute(attributeName);
    }

    public String getText(WebDriver driver, String locator){
        return getElementXpath(driver, locator).getText();
    }

    public String getCssValue(WebDriver driver, String locator, String css){
        return getElementXpath(driver, locator).getCssValue(css);
    }

    // get ra bang mau
    public String getHexaColorFromRGBA(String rgbaValue){
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public List<WebElement> getListElement(WebDriver driver, String locator){
        return driver.findElements(xpath(locator));
    }

    public void checkToCheckboxRadio(WebDriver driver, String locator){
        if(!getElementXpath(driver,locator).isSelected()){
            getElementXpath(driver,locator).click();
        }
    }

    public void checkToCheckbox(WebDriver driver, String locator){
        if(getElementXpath(driver,locator).isSelected()){
            getElementXpath(driver,locator).click();
        }
    }

    public boolean isControlDisplayed(WebDriver driver, String locator){
        return getElementXpath(driver,locator).isDisplayed();
    }

    public boolean isControlSelected(WebDriver driver, String locator){
        return getElementXpath(driver,locator).isSelected();
    }

    public boolean isControlEnabled(WebDriver driver, String locator){
        return getElementXpath(driver,locator).isEnabled();
    }

    public void switchto (WebDriver driver, String locator){
        driver.switchTo().frame(getElementXpath(driver,locator));
    }

    public void switchToDefaultPage(WebDriver driver, String locator){
        driver.switchTo().defaultContent();
    }

    public void hoveToElement(WebDriver driver, String locator){
        new Actions(driver).moveToElement(getElementXpath(driver, locator)).perform();
    }

    public void clickAndHoldToElement(WebDriver driver, String locator){
        new Actions(driver).clickAndHold(getElementXpath(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator){
        new Actions(driver).doubleClick(getElementXpath(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator){
        new Actions(driver).contextClick(getElementXpath(driver, locator)).perform();
    }

    public void drapAndropElement(WebDriver driver, String targetLocator, String sourceLocator){
        new Actions(driver).dragAndDrop(getElementXpath(driver,sourceLocator), getElementXpath(driver,targetLocator)).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys keys){
        new Actions(driver).sendKeys(getElementXpath(driver,locator), keys).perform();
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
        WebElement element = getElementXpath(driver, locator);

        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAtrtibute('style', arguments[1])", element, "border: 2px solid red;");
        sleepInSeconds(2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJs(WebDriver driver, String locator){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", getElementXpath(driver, locator));
    }

    public void crollToElementOnTopByJs(WebDriver driver, String locator){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", getElementXpath(driver, locator));
    }

    public void scrollToElementsOnDownByJs(WebDriver driver,String locator){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", getElementXpath(driver, locator));
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue){
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute(' "+attributeName + " ');", getElementXpath(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemmove){
        ((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('" + attributeRemmove+ "');", getElementXpath(driver, locator));
    }

    public String getAttributeInDOM(WebDriver driver, String locator, String attributeName){
        return (String) ((JavascriptExecutor)driver).executeScript("arguments[0].validationMessage;", getElementXpath(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator){
        boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElementXpath(driver, locator));
        return status;
    }

    public By getByXpath(String locator){
        return xpath(locator);
    }

    public void waitForElementVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, ofSeconds(500)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator){
        new WebDriverWait(driver, ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
    }

    public void waitForElementInVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, ofSeconds(80)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitForElemetClickable(WebDriver driver, String locator){
        new WebDriverWait(driver, ofSeconds(1500)).until(ExpectedConditions.elementToBeClickable(getByXpath(locator))).click();
    }

    public void enterTextAndSelectSuggestion(WebDriver driver, String inputLocator, String inputText, String expectedSuggestion, String suggestionLocator) {
        sendKeyToElement(driver, inputLocator, inputText);

        List<WebElement> suggestions = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpath(suggestionLocator)));

        for (WebElement suggestion : suggestions) {
            String suggestionText = suggestion.getText().trim();

            // Kiểm tra nếu phần tử là một thẻ <a> có link
            if (suggestion.getTagName().equals("a")) {
                String suggestionLink = suggestion.getAttribute("href");
                System.out.println("Checking Suggestion: " + suggestionText + " | Link: " + suggestionLink);
            }

            // Nếu nội dung hiển thị đúng thì click
            if (suggestionText.equals(expectedSuggestion)) {
                suggestion.click();
                break;
            }
        }
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(getByXpath(locator)))
                .click();
    }

    public void hoverAndSelectDropdown(WebDriver driver, String hoverLocator, String dropdownLocator, String expectedOption) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Hover vào phần tử chính (trigger dropdown)
        WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hoverLocator)));
        actions.moveToElement(hoverElement).perform();

        // Đợi danh sách dropdown hiển thị
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownLocator)));

        // Lấy danh sách các phần tử trong dropdown (chỉ lấy `li` bên trong `ul`)
        List<WebElement> options = driver.findElements(By.xpath(dropdownLocator + "//li"));
        Thread.sleep(30);
        boolean found = false;
        for (WebElement option : options) {
            String optionText = option.getText().trim();
            if (optionText.equalsIgnoreCase(expectedOption)) {
                // Đợi phần tử option có thể click được rồi click
                wait.until(ExpectedConditions.elementToBeClickable(option)).click();
                found = true;
                break;
            }
        }

        // Nếu không tìm thấy option tương ứng thì ném lỗi
        if (!found) {
            throw new IllegalArgumentException("Không tìm thấy option với giá trị: " + expectedOption);
        }
    }

    public void swipeDown(WebDriver driver, double startRadio, double endRadio) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * startRadio);
        int endY = (int) (size.height * endRadio);

        new TouchAction<>((AndroidDriver) driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    public void take_A_Photo(WebDriver driver, String locator1, String locator2){
        waitForElementClickable(driver,locator1);
        waitForElementClickable(driver,locator2);
    }
}
