package day02;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_UpdateName extends DriverClass {
    /** Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Login
     * Click on Edit Account
     * Update name
     * Click on Continue
     * Verify the success message
     * Than update the name with the old name
     */

    @Test
    void test1(){
       editName("John");
       editName("Jane");
    }

    public void editName(String name){

//        WebDriver driver=new ChromeDriver();
//        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
//        driver.manage().window().maximize();
//        //<input type="text" name="email" value="" placeholder="E-Mail Address" id="input-email" class="form-control">
//        WebElement email=driver.findElement(By.id("input-email"));
//        email.sendKeys("janeDoe@outlook.com");
//
//        //<input type="password" name="password" value="" placeholder="Password" id="input-password" class="form-control">
//        WebElement password= driver.findElement(By.id("input-password"));
//        password.sendKeys("naime123");
//
//        //<input type="submit" value="Login" class="btn btn-primary">
//        WebElement loginButton=driver.findElement(By.cssSelector("input[type='submit']"));
//        loginButton.click();

        //<a href="https://opencart.abstracta.us:443/index.php?route=account/edit" class="list-group-item">Edit Account</a>
        WebElement editAccount=driver.findElement(By.xpath("//a[text()='Edit Account']"));
        editAccount.click();

        //<input type="text" name="firstname" value="Jane" placeholder="First Name" id="input-firstname" class="form-control">
        WebElement changeFirstName=driver.findElement(By.id("input-firstname"));
        changeFirstName.clear();
        changeFirstName.sendKeys(name);

        //<input type="submit" value="Continue" class="btn btn-primary">
        WebElement continueButton=driver.findElement(By.cssSelector("input[type='submit']"));
        continueButton.click();

        //<div class="alert alert-success alert-dismissible"><i class="fa fa-check-circle"></i> Success: Your account has been successfully updated.</div>
        WebElement alertMessage=driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(alertMessage.getText(),"Success: Your account has been successfully updated.","Your test is not passed");



    }

}
