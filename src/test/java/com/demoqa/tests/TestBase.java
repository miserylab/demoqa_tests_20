package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;





public class TestBase {

//        String firstName = "Alex",
//            lastName = "Egorov",
//            userEmail = "alex@egorov.com";


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
    }

}
