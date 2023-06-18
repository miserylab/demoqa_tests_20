package com.demoqa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AutomationPracticePage {
    //    String loginLocator = "#first_name"; // BAD PRACTICE
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper");

    public AutomationPracticePage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public AutomationPracticePage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public AutomationPracticePage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public AutomationPracticePage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public AutomationPracticePage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }
}
