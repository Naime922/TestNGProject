package day05;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;

public class _02_SearchFunctionality extends DriverClass {
    @Test
    @Parameters(value = "searchKeyWord")
    void searchFuncTest(String str){
       //<input type="text" name="search" value="" placeholder="Search" class="form-control input-lg">
        WebElement searchBox= driver.findElement(By.cssSelector("input[type='text']"));
        searchBox.sendKeys(str);
        //<button type="button" class="btn btn-default btn-lg"><i class="fa fa-search"></i></button>
        WebElement button= driver.findElement(By.cssSelector("button[class=\"btn btn-default btn-lg\"]"));
        button.click();

        List<WebElement>elements=driver.findElements(By.cssSelector("h4>a"));

        for (WebElement element:elements) {
            Assert.assertTrue(element.getText().toLowerCase().contains(str));
        }

    }

}
