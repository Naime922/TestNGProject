package day07;

import Utilities.DriverClass;
import Utilities.ParameterDriverClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Go to "https://opencart.abstracta.us/index.php?route=account/login"
 * Log in
 * search for ipod (send "ipod" from xml file
 * add one of the elements to the wish list randomly
 * Click on Wish List button
 * Check if the name of the element is the same with the name of the element you added.
 * Use POM and ParameterDriver
 * Perform non-parallel cross browser test
 * */
public class _04_WishListTest extends ParameterDriverClass {

    @Test
    @Parameters(value = "searchKey")
    void wishListTest1(String str) {
        _04_WishListFunctionalityElements wishListElements = new _04_WishListFunctionalityElements(driver);

        wishListElements.getSearchBox().sendKeys(str);
        wishListElements.getSearchButton().click();

        int randomIndex = (int)(Math.random()*wishListElements.getProductsList().size());
        String productName = wishListElements.getProductNameList().get(randomIndex).getText();
        wishListElements.getProductsList().get(randomIndex).click();

        wishListElements.getWishListButton().click();

        Assert.assertEquals(wishListElements.getWishListProduct().getText(),productName);

        wishListElements.getRemoveFromWishListButton().click();


















    }

}
