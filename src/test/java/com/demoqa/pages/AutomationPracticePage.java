package com.demoqa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AutomationPracticePage {

    CalendarComponent calendarComponent = new CalendarComponent();

    //    String loginLocator = "#first_name"; // BAD PRACTICE
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput");

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

    public AutomationPracticePage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public AutomationPracticePage setBirthDay(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
}
