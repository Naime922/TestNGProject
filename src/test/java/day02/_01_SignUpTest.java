package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_SignUpTest {

/** Go to "https://opencart.abstracta.us/index.php?route=account/login"
 * Click on My Accout
 * Click on Register
 * Fill int he form with valid informations
 * Accept the agreement
 * Click on Continue button
 * Verify that you are signed up
 */

  @Test
  void test1() throws InterruptedException {
      WebDriver driver=new ChromeDriver();
      driver.get("https://opencart.abstracta.us/index.php?route=account/login");
      driver.manage().window().maximize();
      //<a href="https://opencart.abstracta.us:443/index.php?route=account/account"
      // title="My Account" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>
      // <span class="hidden-xs hidden-sm hidden-md">My Account</span> <span class="caret"></span></a>
      WebElement myAccount= driver.findElement(By.cssSelector("a[class='dropdown-toggle']"));
      myAccount.click();
      Thread.sleep(1000);

      //<a href="https://opencart.abstracta.us:443/index.php?route=account/register">Register</a>
      WebElement register= myAccount.findElement(By.xpath("//a[text()='Register']"));

      Actions actions=new Actions(driver);
      Action registerButton=actions.moveToElement(register).click().build();
      registerButton.perform();

      //<input type="text" name="firstname" value="" placeholder="First Name" id="input-firstname" class="form-control">
      WebElement firstname=driver.findElement(By.id("input-firstname"));
      firstname.sendKeys("Jane");

     // <input type="text" name="lastname" value="" placeholder="Last Name" id="input-lastname" class="form-control">
      WebElement lastname= driver.findElement(By.id("input-lastname"));
      lastname.sendKeys("Doe");

      //<input type="email" name="email" value="" placeholder="E-Mail" id="input-email" class="form-control">
      WebElement email= driver.findElement(By.id("input-email"));
      email.sendKeys("janeDoe@outlook.com");

      //<input type="tel" name="telephone" value="" placeholder="Telephone" id="input-telephone" class="form-control">
      WebElement phone=driver.findElement(By.id("input-telephone"));
      phone.sendKeys("1234567899");

      //<input type="password" name="password" value="" placeholder="Password" id="input-password" class="form-control">
      WebElement password= driver.findElement(By.id("input-password"));
      password.sendKeys("naime123");

      //<input type="password" name="confirm" value="" placeholder="Password Confirm" id="input-confirm" class="form-control">
      WebElement passwordConfirm= driver.findElement(By.id("input-confirm"));
      passwordConfirm.sendKeys("naime123");

      //<input type="checkbox" name="agree" value="1">
      WebElement checkBox=driver.findElement(By.cssSelector("input[type='checkbox']"));
      checkBox.click();

      //<input type="submit" value="Continue" class="btn btn-primary">
      WebElement continueButton=driver.findElement(By.cssSelector("input[type='submit']"));
      continueButton.click();

      //<p>Congratulations! Your new account has been successfully created!</p>
      WebElement confirmationMessage=driver.findElement(By.xpath("//div[@id='content']//p"));

      Assert.assertEquals(confirmationMessage.getText(),"Congratulations! Your new account has been successfully created!","Your test is not passed");
      Thread.sleep(5000);
      driver.quit();

  }
}
