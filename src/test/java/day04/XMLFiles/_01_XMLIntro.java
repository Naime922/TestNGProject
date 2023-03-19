package day04.XMLFiles;

import org.testng.annotations.*;

public class _01_XMLIntro {
 /*
     @BeforeSuit
       @BeforeTest
         @BeforeGroup
           @BeforeClass // runs before every class annotation
             @BeforeMethod // runs before every @Test annotation
                 @Test1 method  // we write our tests
                 @Test2 method
             @AfterMethod // runs after every @Test annotation
           @AfterClass // runs after every class annotation
         @AfterGroup
       @AfterTest
     @AfterSuit
   */
    @BeforeSuite
    void beforeSuitMethod(){
        System.out.println("Before suit runs");
    }
    @BeforeTest
    void beforeTestMethod(){
        System.out.println("Before test is running");
    }
    @BeforeGroups
    void beforeGroupsMethod(){
        System.out.println("Before group is running");
    }
    @BeforeClass
    void beforeClassMethod(){
        System.out.println("Before class method is running");
    }
    @BeforeMethod
    void beforeMethodMethod(){
        System.out.println("Before method runs");
    }
    @Test
    void test1(){
        System.out.println("Test 1 runs");
    }
    @Test
    void test2(){
        System.out.println("Test 2 runs");
    }
    @AfterMethod
    void afterMethodMethod(){
        System.out.println("After method runs");
    }
    @AfterClass
    void afterClassMethod(){
        System.out.println("After class runs");
    }
    @AfterGroups
    void afterGroupsMethod(){
        System.out.println("After groups runs");
    }
    @AfterTest
    void afterTestMethod(){
        System.out.println("After Test runs");
    }

    @AfterSuite
    void afterSuitMethod(){
        System.out.println("After Suit runs");
    }

}

