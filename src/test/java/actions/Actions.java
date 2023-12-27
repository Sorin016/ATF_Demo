package actions;

import org.openqa.selenium.WebElement;

public class Actions {
    public static void sendKey(WebElement element, String value){
        element.sendKeys(value);
    }
    public static void isDisplayed(WebElement element){
        element.isDisplayed();
    }
    public static void click(WebElement element) throws InterruptedException {
        Thread.sleep(5000);
//        boolean el=true;
//        if(el == element.isDisplayed())
        element.click();
//        else
            System.out.println("element is true");
    }
    public static void clickOn(WebElement element,String value) throws InterruptedException {
        Thread.sleep(3000);

        element.click();

    }
}
