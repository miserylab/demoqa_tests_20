package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.AutomationPracticePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests extends TestBase {

    AutomationPracticePage automationPracticePage = new AutomationPracticePage();



    @Test
    void fillFormTest() {
        automationPracticePage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setUserEmail("alex@egorov.com")
                .setGender("Male")
                .setUserNumber("0123456789")
                .setBirthDay("30", "July", "2008")
                .setSubject("Chemistry")
                .setSubject("Physics")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setUploadPicture("Toolsqa.jpg")
                .setAddress("Some address 1")
                .setState("Uttar Pradesh")
                .setCity("Merrut")
                .clickSubmit();





        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex"), text("Egorov"), text("alex@egorov.com"),
                text("0123456789"));
    }
}
