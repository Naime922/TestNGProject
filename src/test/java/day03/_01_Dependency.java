package day03;

import org.testng.annotations.Test;

public class _01_Dependency {

    @Test
    void startCar() {
        System.out.println("Car is started");
    }

    @Test(dependsOnMethods = {"startCar"})
//This test depends on the success of startCar test
    void driveCar() {
        System.out.println("Car is driven");
    }

    @Test(dependsOnMethods = {"startCar", "driveCar"})
//This test depends on the success of startCar and driveCar methods
    void parkCar() {
        System.out.println("Car is parked");
    }

    @Test(dependsOnMethods = {"startCar", "driveCar", "parkCar"})
    void stopCar() {
        System.out.println("Car is stopped");
    }

}
