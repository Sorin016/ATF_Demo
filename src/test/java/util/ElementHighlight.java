package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@FunctionalInterface
public interface ElementHighlight {
    void elementHighlight(WebElement element, WebDriver driver);
}
