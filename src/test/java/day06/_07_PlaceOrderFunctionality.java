package day06;

import Utilities.DriverClass;
import Utilities.ParameterDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class _07_PlaceOrderFunctionality extends ParameterDriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * Search for ipod
     * Add the first result to cart
     * Click on cart icon
     * Click on Check Out
     * Fill the form
     * Click on Confirm and verify that your order is successful
     * */
    @Test
    @Parameters(value = "keys")
    void placeOrderFunctionalityTest(String keyWord){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        //<input type="text" name="search" value="" placeholder="Search" class="form-control input-lg">
        WebElement searchBox= driver.findElement(By.cssSelector("input[placeholder='Search']"));
        searchBox.sendKeys(keyWord);

        //<button type="button" class="btn btn-default btn-lg"><i class="fa fa-search"></i></button>
        WebElement searchButton= driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();

        //<button type="button" onclick="cart.add('36', '1');"><i class="fa fa-shopping-cart"></i> <span class="hidden-xs hidden-sm hidden-md">Add to Cart</span></button>
        WebElement addToCartButton = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
        addToCartButton.click();

        //<span class="hidden-xs hidden-sm hidden-md">Shopping Cart</span>
        WebElement cartButton=driver.findElement(By.xpath("//span[text()='Shopping Cart']"));
        cartButton.click();

        //<a href="https://opencart.abstracta.us:443/index.php?route=checkout/checkout" class="btn btn-primary">Checkout</a>
        WebElement checkOutButton=driver.findElement(By.partialLinkText("Checkout"));
        checkOutButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));

        //<input type="button" value="Continue" id="button-payment-address" data-loading-text="Loading..." class="btn btn-primary">
        WebElement continueButton1=driver.findElement(By.id("button-payment-address"));
        continueButton1.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));
        //<input type="button" value="Continue" id="button-shipping-address" data-loading-text="Loading..." class="btn btn-primary">
        WebElement continueButton2=driver.findElement(By.id("button-shipping-address"));
        continueButton2.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
        //<input type="button" value="Continue" id="button-shipping-method" data-loading-text="Loading..." class="btn btn-primary">
        WebElement continueButton3= driver.findElement(By.id("button-shipping-method"));
        continueButton3.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='agree']")));
        //<input type="checkbox" name="agree" value="1">
        WebElement agreeButton=driver.findElement(By.xpath("//input[@name='agree']"));
        agreeButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-method")));
        //<input type="button" value="Continue" id="button-payment-method" data-loading-text="Loading..." class="btn btn-primary">
        WebElement continueButton4= driver.findElement(By.id("button-payment-method"));
        continueButton4.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-confirm")));
        //<input type="button" value="Confirm Order" id="button-confirm" data-loading-text="Loading..." class="btn btn-primary">
        WebElement confirmOrderButton=driver.findElement(By.id("button-confirm"));
        confirmOrderButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1[text()='Your order has been placed!']")));
        //<h1>Your order has been placed!</h1>content
        WebElement successMessage=driver.findElement(By.xpath("//div[@id='content']/h1[text()='Your order has been placed!']"));
        Assert.assertEquals("Your order has been placed!",successMessage.getText());


    }
}
