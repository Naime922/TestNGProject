package day06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _06_SoftAssertVsHardAssert {

    @Test
    void hardAssertTest(){
        String str="Hello";
        System.out.println("Before assertion");

        Assert.assertEquals("Hello World", str,"Your test is failed");//Hard assertion
        //If actual is not the same with expected it will be throw exception and stop the code
        //Then TestNG will run the next tests
        System.out.println("After assertion");
    }

    @Test
    void softAssertTest() {
        String startHomePage = "www.facebook.com/homepage";
        String startCartPage = "www.facebook.com/CartPage";
        String strEditAccount = "www.facebook.com/editaccountpae";

        SoftAssert softAssert = new SoftAssert();

        System.out.println("Before soft assert");
        softAssert.assertEquals("www.facebook.com/homepage",startHomePage);
        System.out.println("After soft assert1");

        System.out.println("before soft assert 2");
        softAssert.assertEquals("www.facebook.com/profile",startCartPage);
        System.out.println("After soft assert 2");

        System.out.println("before soft assert 3");
        softAssert.assertEquals("www.facebook.com/settings",strEditAccount);
        System.out.println("after soft assert 3");
        softAssert.assertAll();

    }

}
