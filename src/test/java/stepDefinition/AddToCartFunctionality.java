package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SearchForMensShoes;
import pages.waitUntilTime;

import static actions.Actions.sendKey;
import static util.WaitUtils.waitForRetry;


public class AddToCartFunctionality extends AbstractStepDef {


    @When("User navigate to Mens Shoes")
    public void user_navigate_to_Mens_Shoes(){
        waitForRetry(2000);
        driver.findElement(By.id("searchAll")).sendKeys("mens shoes");
        waitForRetry(2000);
        driver.findElement(By.xpath("//*[@id=\"searchForm\"]/button")).click();
    }

    @When("Choose the {} and {} and {}")
    public void choose_the_mens_size_and_color_and_price(String mens_size, String color, String price) throws InterruptedException {
        waitForRetry(2000);
       // Man Shoe's inscription is displayed
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div/h1")).isDisplayed();


//
//        loginPage =new LoginPage(driver);
//        searchForMensShoes=new SearchForMensShoes(driver);
//        sendKey(searchForMensShoes.getMenShoesText(), MenShoesText);
//        sendKey(searchForMensShoes.getMenShoesSize(), MenShoesText);
//        //size
        driver.findElement(By.xpath("//*[@id=\"searchFilters\"]/div[1]/div[2]/section[2]/div[2]/ul/li[18]/a")).click();
        waitForRetry(2000);
        //color
        waitForRetry(2000);
        driver.findElement(By.xpath("//*[@id=\"searchFilters\"]/div/div[2]/section[5]/div[2]/ul/li[1]/a")).click();
        //price
        waitForRetry(2000);
        driver.findElement(By.xpath("//*[@id=\"searchFilters\"]/div[1]/div[2]/section[6]/div[2]/ul/li[4]/a")).click();
        waitForRetry(2000);
    }

    @When("Choose the first 2 items and add them to the cart")
    public void choose_the_first_2_items_and_add_them_to_the_cart() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"products\"]/article[3]/a")).click();
        //size inside the item
        waitForRetry(3000);
        driver.findElement(By.xpath("//*[@id=\"buyBoxForm\"]/div[2]/fieldset[1]/div/div[1]")).click();
    //    press add to cart first product
        waitForRetry(3000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[5]/div[2]/div/div[4]/button")).click();
        //verify that user is on view cart
    }

    @When("Check that all selected items are present in cart")
    public void check_that_all_selected_items_are_present_in_cart() throws InterruptedException {
        waitForRetry(3000);
        driver.findElement(By.xpath(  "//*[@id=\"modalDescription\"]")).isDisplayed();

        //out first element is in cart
        driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div[1]/div[2]/div[1]/a/span[1]")).isDisplayed();
        driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/form/a")).click();
        waitForRetry(3000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/a/span[1]")).isDisplayed();

    }
}
