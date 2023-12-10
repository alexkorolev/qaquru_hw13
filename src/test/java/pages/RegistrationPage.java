package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement firstNameLocator = $("#firstName"),
            lastNameLocator = $("#lastName"),
            userEmailLocator = $("#userEmail"),
            genderLocator = $("#genterWrapper"),
            subjectLocator = $("#subjectsContainer input"),
            hobbiesLocator = $("#hobbiesWrapper"),
            userNumberLocator = $("#userNumber"),
            uploadPickureLocator = $("#uploadPicture"),
            setAddressLocator = $("#currentAddress"),
            stateLocator = $("#state input"),
            cityLocator = $("#city input"),
            submitLocator = $("#submit"),
            calendarLocator = $("#dateOfBirth input");


    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanners(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameLocator.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value){
        lastNameLocator.setValue(value);
        return this;
    }
    public RegistrationPage setUserEmail(String value){
        userEmailLocator.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        genderLocator.$(byText(value)).doubleClick();
        return this;
    }

    public RegistrationPage setSubject(String value){
        subjectLocator.click();
        subjectLocator.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value){
        subjectLocator.click();
        hobbiesLocator.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumberLocator.setValue(value);
        return this;
    }

    public RegistrationPage setCalendarDate(String day, String mounth, String year){
        calendarLocator.click();
        calendarComponent.setDateOfBirth(day,mounth,year);
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPickureLocator.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value){
        setAddressLocator.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value){
        stateLocator.val(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String value){
        cityLocator.val(value).pressEnter();
        return this;
    }

    public RegistrationPage pressSubmit(){
        submitLocator.click();
        return this;
    }
}