package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests extends TestBase {

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("alex@egorov.com");
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
        $(".table-responsive").shouldHave(text("Alex"), text("Egorov"), text("alex@egorov.com"),
                text("0123456789"));
//        $(".modal-dialog tr:nth-child(1) td:nth-child(1)").shouldHave(text("Student Name"));
//        $(".modal-dialog tr:nth-child(1) td:nth-child(2)").shouldHave(text("Alex Egorov"));
//        $(".modal-dialog tr:nth-child(2) td:nth-child(1)").shouldHave(text("Student Email"));
//        $(".modal-dialog tr:nth-child(2) td:nth-child(2)").shouldHave(text("alex@egorov.com"));
//        $(".modal-dialog tr:nth-child(3) td:nth-child(1)").shouldHave(text("Gender"));
//        $(".modal-dialog tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
//        $(".modal-dialog tr:nth-child(4) td:nth-child(1)").shouldHave(text("Mobile"));
//        $(".modal-dialog tr:nth-child(4) td:nth-child(2)").shouldHave(text("0123456789"));
//        $(".modal-dialog tr:nth-child(5) td:nth-child(1)").shouldHave(text("Date of Birth"));
//        $(".modal-dialog tr:nth-child(5) td:nth-child(2)").shouldHave(text("18 July,2003"));
//        $(".modal-dialog tr:nth-child(6) td:nth-child(1)").shouldHave(text("Subjects"));
//        $(".modal-dialog tr:nth-child(6) td:nth-child(2)").shouldHave(text("Chemistry, Physics"));
//        $(".modal-dialog tr:nth-child(7) td:nth-child(1)").shouldHave(text("Hobbies"));
//        $(".modal-dialog tr:nth-child(7) td:nth-child(2)").shouldHave(text("Sports, Reading"));
//        $(".modal-dialog tr:nth-child(8) td:nth-child(1)").shouldHave(text("Picture"));
//        $(".modal-dialog tr:nth-child(8) td:nth-child(2)").shouldHave(text("Toolsqa.jpg"));
//        $(".modal-dialog tr:nth-child(9) td:nth-child(1)").shouldHave(text("Address"));
//        $(".modal-dialog tr:nth-child(9) td:nth-child(2)").shouldHave(text("Some address 1"));
//        $(".modal-dialog tr:nth-child(10) td:nth-child(1)").shouldHave(text("State and City"));
//        $(".modal-dialog tr:nth-child(10) td:nth-child(2)").shouldHave(text("Uttar Pradesh Merrut"));
//        $(".modal-dialog #closeLargeModal").shouldHave(text("Close"));
    }
}
