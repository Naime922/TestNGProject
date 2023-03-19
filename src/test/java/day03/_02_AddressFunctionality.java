package day03;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Go to "https://opencart.abstracta.us/index.php?route=account/login"
 * Login
 * Click on Address Book
 * Add a new address
 * Edit the address
 * Delete the address
 */

public class _02_AddressFunctionality extends DriverClass {
    @Test
    void test1() {
        //<a href="https://opencart.abstracta.us:443/index.php?route=account/address" class="list-group-item">Address Book</a>
        WebElement addressBook = driver.findElement(By.xpath("//a[text()='Address Book']"));
        addressBook.click();
    }

    @Test(dependsOnMethods = {"test1"})
    void test2() throws InterruptedException {
        //<a href="https://opencart.abstracta.us:443/index.php?route=account/address/add" class="btn btn-primary">New Address</a>
        WebElement addNewAddress = driver.findElement(By.xpath("//a[text()='New Address']"));
        addNewAddress.click();
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Jane");
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Doe");
        WebElement address = driver.findElement(By.id("input-address-1"));
        address.sendKeys("1234 Flower street");
        WebElement city = driver.findElement(By.id("input-city"));
        city.sendKeys("NYC");
        WebElement zipcode = driver.findElement(By.id("input-postcode"));
        zipcode.sendKeys("55522");

        WebElement country = driver.findElement(By.id("input-country"));
        Select select = new Select(country);
        select.selectByValue("223");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("input-zone"))));
        WebElement region = driver.findElement(By.id("input-zone"));
        Select select1 = new Select(region);
        select1.selectByValue("3616");
        //<input type="submit" value="Continue" class="btn btn-primary">
        WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit']"));
        continueButton.click();

    }

    @Test(dependsOnMethods = {"test1", "test2"})
    void test3() throws InterruptedException {
        Thread.sleep(3000);
        //<a href="https://opencart.abstracta.us:443/index.php?route=account/address/edit&amp;address_id=7836" class="btn btn-info">Edit</a>
        WebElement editAddress = driver.findElement(By.xpath("(//a[text()='Edit'])[2]"));
        editAddress.click();
        WebElement addressInput = driver.findElement(By.id("input-address-1"));
        addressInput.clear();
        addressInput.sendKeys("5454 georgia street");

        WebElement city = driver.findElement(By.id("input-city"));
        city.clear();
        city.sendKeys("New York");

        WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit']"));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"))));
        WebElement successMessage = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));

        Assert.assertTrue(successMessage.getText().contains("successfully"));

    }

    @Test(dependsOnMethods = "test3")
    void test4() {
        WebElement deleteButton = driver.findElement(By.xpath("(//a[text()='Delete'])[2]"));
        deleteButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"))));
        WebElement successMessage = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));

        Assert.assertTrue(successMessage.getText().contains("successfully"));
    }
}
