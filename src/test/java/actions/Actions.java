package actions;

import org.openqa.selenium.WebElement;

public class Actions {
    public static void sendKey(WebElement element, String value){
        element.sendKeys(value);
    }
    public static void click(WebElement element) throws InterruptedException {
        Thread.sleep(5000);
        boolean el=element.isDisplayed();
        element.click();
    }
}
