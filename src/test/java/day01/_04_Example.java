package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Example {
    /**
     * https://opencart.abstracta.us/index.php?route=account/login
     * login
     *testngusbatch@gmail.com
     *  usbatch1234
     * */

    @Test
    void test1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        //<input type="text" name="email" value="" placeholder="E-Mail Address" id="input-email" class="form-control">
        WebElement username = driver.findElement(By.id("input-email"));
        username.sendKeys("testngusbatch@gmail.com");

        //<input type="password" name="password" value="" placeholder="Password" id="input-password" class="form-control">
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("usbatch1234");

        //<input type="submit" value="Login" class="btn btn-primary">
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        loginButton.click();

        //<h2>My Account</h2>
        WebElement myAccountHeader = driver.findElement(By.xpath("(//div[@id='content']//h2)[1]"));
        Assert.assertEquals(myAccountHeader.getText(),"My Account");

        Thread.sleep(3000);
        driver.quit();
        }



    }



