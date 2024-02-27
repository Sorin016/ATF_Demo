package stepDefinition.important;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static actions.Actions.*;
import static util.WaitUtils.waitForRetry;


public class AddToCartFunctionality extends AbstractStepDef {


    @When("User navigate to Mens Shoes")
    public void user_navigate_to_Mens_Shoes() throws InterruptedException {
        waitForRetry(2000);
        sendKey(searchForMensShoes.getSerchAllTab(),"mens shoes");
        waitForRetry(2000);
        click(searchForMensShoes.getSearchButton());
    }

    @When("Choose the {} and {} and {}")
    public void choose_the_mens_size_and_color_and_price(String mens_size, String color, String price) throws InterruptedException {
        waitForRetry(2000);
        log.info(" Man Shoe's inscription is displayed");
        isDisplayed(searchForMensShoes.getMensShoesLogo());
//        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div/h1")).isDisplayed();
        waitForRetry(2000);
        click(searchForMensShoes.getMenShoesSize());
        waitForRetry(2000);
        click(searchForMensShoes.getMenShoesColor());
        waitForRetry(2000);
        click(searchForMensShoes.getMenShoesPrice());
        waitForRetry(2000);

    }

    @When("Choose the first item and add them to the cart")
    public void choose_the_first_item_and_add_them_to_the_cart() throws InterruptedException {
        click(searchForMensShoes.getTheSelectedItemToBuy());
        log.info("size inside the item");
        waitForRetry(3000);
        click(searchForMensShoes.getTheSizeInsideTheItemDescription());
        log.info("press add to cart first product");
        waitForRetry(3000);
        click(viewCart.getAddedToBagSighn());
    }

    @When("Check that all selected items are present in cart")
    public void check_that_all_selected_items_are_present_in_cart() throws InterruptedException {
        waitForRetry(3000);
        driver.findElement(By.xpath("//*[@id=\"modalDescription\"]")).isDisplayed();
        driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div[1]/div[2]/div[1]/a/span[1]")).isDisplayed();
        driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/form/a")).click();
        waitForRetry(3000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/a/span[1]")).isDisplayed();

    }
}
