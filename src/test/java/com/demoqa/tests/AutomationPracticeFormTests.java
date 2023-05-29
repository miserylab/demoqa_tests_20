package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $(".custom-control-label[for='gender-radio-1']").click();
        $("#userNumber").setValue("0123456789");

        $("#dateOfBirthInput").click();
        $(".react-datepicker .react-datepicker__month-select").selectOption(6);
        $(".react-datepicker .react-datepicker__year-select").selectOption("2003");
        $(".react-datepicker__day--018").click();

        $("#subjectsInput").setValue("Ch").pressEnter();
        $("#subjectsInput").setValue("Ph").pressEnter();
        $(".custom-control-label[for='hobbies-checkbox-1']").click();
        $(".custom-control-label[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFromClasspath("Toolsqa.jpg");
        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-2").click();
        $("#submit").click();


        $(".modal-dialog .modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".modal-dialog tr:nth-child(1) td:nth-child(1)").shouldHave(text("Student Name"));
        $(".modal-dialog tr:nth-child(1) td:nth-child(2)").shouldHave(text("Alex Egorov"));
        $(".modal-dialog tr:nth-child(2) td:nth-child(1)").shouldHave(text("Student Email"));
        $(".modal-dialog tr:nth-child(2) td:nth-child(2)").shouldHave(text("alex@egorov.com"));
        $(".modal-dialog tr:nth-child(3) td:nth-child(1)").shouldHave(text("Gender"));
        $(".modal-dialog tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $(".modal-dialog tr:nth-child(4) td:nth-child(1)").shouldHave(text("Mobile"));
        $(".modal-dialog tr:nth-child(4) td:nth-child(2)").shouldHave(text("0123456789"));
        $(".modal-dialog tr:nth-child(5) td:nth-child(1)").shouldHave(text("Date of Birth"));
        $(".modal-dialog tr:nth-child(5) td:nth-child(2)").shouldHave(text("18 July,2003"));
        $(".modal-dialog tr:nth-child(6) td:nth-child(1)").shouldHave(text("Subjects"));
        $(".modal-dialog tr:nth-child(6) td:nth-child(2)").shouldHave(text("Chemistry, Physics"));
        $(".modal-dialog tr:nth-child(7) td:nth-child(1)").shouldHave(text("Hobbies"));
        $(".modal-dialog tr:nth-child(7) td:nth-child(2)").shouldHave(text("Sports, Reading"));
        $(".modal-dialog tr:nth-child(8) td:nth-child(1)").shouldHave(text("Picture"));
        $(".modal-dialog tr:nth-child(8) td:nth-child(2)").shouldHave(text("Toolsqa.jpg"));
        $(".modal-dialog tr:nth-child(9) td:nth-child(1)").shouldHave(text("Address"));
        $(".modal-dialog tr:nth-child(9) td:nth-child(2)").shouldHave(text("Some address 1"));
        $(".modal-dialog tr:nth-child(10) td:nth-child(1)").shouldHave(text("State and City"));
        $(".modal-dialog tr:nth-child(10) td:nth-child(2)").shouldHave(text("Uttar Pradesh Merrut"));
        $(".modal-dialog #closeLargeModal").shouldHave(text("Close"));
    }
}
