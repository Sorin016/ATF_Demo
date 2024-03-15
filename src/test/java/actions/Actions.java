package actions;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static util.CreationFolderIfNotExist.createDirectoryIfNotExists;

public class Actions {
    public static void sendKey(WebElement element, String value) {
        element.sendKeys(value);
    }

    public static void isDisplayed(WebElement element) {
        element.isDisplayed();
    }

    public static void click(WebElement element) throws InterruptedException {
        Thread.sleep(3000);
        element.click();
    }

    public static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)", "");
    }

    public static void scrollUp(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,150)", "");
    }

    public static void takeScreenshot(Scenario scenario, WebDriver driver) throws IOException {
        try {
            String screenshotName = generateScreenshotName(scenario.getName());
            String directoryName = "target/screenshots/";
            createDirectoryIfNotExists(directoryName);
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(directoryName + screenshotName + ".png"));
        } catch (Exception e) {
            System.out.println("Screenshot nu lucreaza " + e);
        }
    }

    private static String generateScreenshotName(String scenarioName) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestamp = currentTime.format(formatter);

        return scenarioName.replaceAll("[^a-zA-Z0-9_-]", "_") + "_" + timestamp;
    }
}
