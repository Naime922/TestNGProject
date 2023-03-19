package day06;

import Utilities.ParameterDriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class _05_SearchFunctionalityWithDataProvider2 extends ParameterDriverClass {

    /**
     * Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Log in
     * search for mac, samsung, ipod
     * Check all results contains these keywords
     * Use ParameterDriver
     * */
    @Test(dataProvider = "searchKeys")
    void searchFunctionalityTest(String keys) throws InterruptedException {
        //<input type="text" name="search" value="" placeholder="Search" class="form-control input-lg">
        WebElement searchBox= driver.findElement(By.cssSelector("input[placeholder='Search']"));
        searchBox.clear();
        searchBox.sendKeys(keys);

        //<button type="button" class="btn btn-default btn-lg"><i class="fa fa-search"></i></button>
        WebElement searchButton= driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();


        List<WebElement> elements=driver.findElements(By.cssSelector("h4>a"));

        for (WebElement element:elements) {
            Assert.assertTrue(element.getText().toLowerCase().contains(keys));
        }
        Thread.sleep(3000);
    }

    @DataProvider
    public Object[][] searchKeys(){
        Object[][] dataList={{"mac"},{"samsung"},{"ipod"}};

        return dataList;
    }
}
