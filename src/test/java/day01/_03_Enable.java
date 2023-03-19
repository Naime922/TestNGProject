package day01;

import org.testng.annotations.Test;

public class _03_Enable {


    @Test
    void  test1(){
        System.out.println("Test one is successful");
    }

    @Test(enabled = false)
    void test2(){
        System.out.println("test 2 is successful");
    }

    @Test
    void test3(){
        System.out.println("Test 3 is successful");
    }
}
