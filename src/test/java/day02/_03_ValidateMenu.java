package day02;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class _03_ValidateMenu extends DriverClass {
    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Login
     * Validate that you see all menu options
     * */
    public void startingSettings(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        login();

    }

    @Test(groups ="SmokeTest")
    void ValidateMenuTest(){
       startingSettings();
        List<WebElement> menuList = driver.findElements(By.xpath("//ul[@class=\"nav navbar-nav\"]/li"));
        List<String> expectedMenuList = new ArrayList<>(List.of("Desktops", "Laptops & Notebooks", "Components", "Tablets", "Software", "Phones & PDAs", "Cameras", "MP3 Players"));

        for (WebElement menu: menuList){
            Assert.assertTrue(expectedMenuList.contains(menu.getText()));
        }
    }
    public void login(){
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

    WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("janeDoe@outlook.com");

    //<input type="password" name="password" value="" placeholder="Password" id="input-password" class="form-control">
    WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("naime123");

    //<input type="submit" value="Login" class="btn btn-primary">
    WebElement loginButton=driver.findElement(By.cssSelector("input[type='submit']"));
        loginButton.click();
}

}
