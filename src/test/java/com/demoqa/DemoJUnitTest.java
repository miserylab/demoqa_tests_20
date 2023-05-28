package com.demoqa;

import com.beust.ah.A;
import com.codeborne.selenide.Configuration;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.*;

public class DemoJUnitTest {

    Calculator calc;

    @BeforeAll
    static void beforeAll() {
        System.out.println("#### @BeforeAll");
  //     Configuration.browser = "chrome";
    }

    @AfterAll
    static void afterAll() {
        System.out.println("#### @AfterAll");
        //     Configuration.browser = "chrome";
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    #### @BeforeEach");
        calc = new Calculator();

    }

    @AfterEach
    void afterEach() {
        System.out.println("    #### @AfterEach");
    }

    @Test
    void firstTest() {
        System.out.println("   #### @Test firstTest");
        int result = calc.summ(2,2);
        Assertions.assertTrue(result == 4);
    }

    @Test
    void secondTest() {
        System.out.println("   #### @Test secondTest");
        int result = calc.mult(2,2);
        Assertions.assertTrue(result == 4);
    }

}
