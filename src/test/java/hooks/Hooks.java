package hooks;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    WebDriver driver=null;

    public Hooks(WebDriver driver) {
        this.driver=driver;
    }

//    @Before
//    public void Afisare(){
//        System.out.println("afisare la before nethod");
//    }

    @Before
    public void chromeDriverSetUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
    }

    @After
    public void closeChromeDriver(){
        driver.quit();
        driver.close();
    }
}
