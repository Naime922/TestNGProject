package day01;

import org.testng.annotations.*;

public class _02_Annotations {
    //@BeforeClass --> This code will be run before class
       //@BeforeMethod --> This code will be run before all test annotation
          //@Test -->To write our tests
        //@AfterMethod --> This code will be run after all test annotations
    //@AfterClass --> This code will run after the class


    @BeforeMethod
    public  void beforeMethod(){
        System.out.println("Before method is working");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After method is working");
    }
    @BeforeClass
    public void beforeClass9(){
        System.out.println("Before class is working");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class is working");
    }
    @Test
    public void test1(){
        System.out.println("Test 1 is successful");
    }

    @Test
    void test2(){
        System.out.println("Test 2 is successful");
    }



}
