package courses.Java_PRO;

import courses.Java_PRO.annotation.BeforeSuite;
import courses.Java_PRO.annotation.AfterSuite;
import courses.Java_PRO.annotation.Test;

public class SomeClass {

    @Test(priority = 1)
    public void testMethod1(String name) {
        System.out.println("Hello from " + name);
    }

    @Test(priority = 3)
    public void testMethod2(String name) {
        System.out.println("Hello from " + name);
    }

    @Test(priority = 8)
    public void testMethod3(String name) {
        System.out.println("Hello from " + name);
    }

//    @Test(priority = 11)
//    public void errorTestMethod() {
//    }

    @BeforeSuite
    public static void beforeSuiteMethod() {
        System.out.println("Test start");
    }

//    @BeforeSuite
//    public static void errorBeforeSuiteMethod() {
//        // do something
//    }

    @AfterSuite
    public static void afterSuiteMethod() {
        System.out.println("Test finish");
    }
}
