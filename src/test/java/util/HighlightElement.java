package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElement{
    public static WebDriver driver;
    public static void highlightElement(WebElement element, WebDriver driver){
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border: 3px solid red;');",element);
    }
    public static void highlightElement(WebElement element){
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].setAttribute('style','background:yellow; border: 3px solid red;');",element);
    }
}
