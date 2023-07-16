package com.demoqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.tests.TestData.*;

public class AutomationPracticeFormWithTestDataTests extends TestBase {


//    String firstName = "Alex",
//            lastName = "Egorov",
//            userEmail = "alex@egorov.com";

//    private static final String firstName = "Alex",
//            lastName = "Egorov",
//            userEmail = "alex@egorov.com";

//        String firstName,
//            lastName,
//            userEmail;
//
//    @BeforeEach
//    void prepareTestData() {
//            firstName = "Alex";
//            lastName = "Egorov";
//            userEmail = "alex@egorov.com";
//    }

    @Test
    void fillFormTest() {
//        String firstName = "Alex",
//                lastName = "Egorov",
//                userEmail = "alex@egorov.com";


        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2003");
        $(".react-datepicker__day--018").click();

        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("Toolsqa.jpg");
        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Merrut")).click();
        $("#submit").click();


        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail),
                text("0123456789"));
    }
}