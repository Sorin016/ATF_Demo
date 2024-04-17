package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@FunctionalInterface
public interface ElementHighlight {
    void highlightElement(WebElement element, WebDriver driver);
}
