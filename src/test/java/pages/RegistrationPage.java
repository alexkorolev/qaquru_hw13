package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Открыть страницу")
    public RegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    @Step("Удаление баннеров")
    public RegistrationPage removeBanners(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Ввод имени клиента")
    public RegistrationPage setFirstName(String value){
        firstNameLocator.setValue(value);
        return this;
    }
    @Step("Ввод фамилии клиента")
    public RegistrationPage setLastName(String value){
        lastNameLocator.setValue(value);
        return this;
    }
    @Step("Ввод Email клиента")
    public RegistrationPage setUserEmail(String value){
        userEmailLocator.setValue(value);
        return this;
    }
    @Step("Ввод пола клиента")
    public RegistrationPage setGender(String value){
        genderLocator.$(byText(value)).doubleClick();
        return this;
    }
    @Step("Ввод предмета который изучает клиент")
    public RegistrationPage setSubject(String value){
        subjectLocator.click();
        subjectLocator.setValue(value).pressEnter();
        return this;
    }
    @Step("Ввод хобби клиента")
    public RegistrationPage setHobbies(String value){
        subjectLocator.click();
        hobbiesLocator.$(byText(value)).click();
        return this;
    }
    @Step("Ввод имени клиента")
    public RegistrationPage setUserNumber(String value){
        userNumberLocator.setValue(value);
        return this;
    }
    @Step("Установка даты в каледаре")
    public RegistrationPage setCalendarDate(String day, String mounth, String year){
        calendarLocator.click();
        calendarComponent.setDateOfBirth(day,mounth,year);
        return this;
    }
    @Step("Загрузка картинки на странице")
    public RegistrationPage uploadPicture(String value) {
        uploadPickureLocator.uploadFromClasspath(value);
        return this;
    }
    @Step("Установка адреса клиента")
    public RegistrationPage setAddress(String value){
        setAddressLocator.setValue(value);
        return this;
    }
    @Step("Ввод области регистрации клиента")
    public RegistrationPage setState(String value){
        stateLocator.val(value).pressEnter();
        return this;
    }
    @Step("Ввод города регистрации клиента")
    public RegistrationPage setCity(String value){
        cityLocator.val(value).pressEnter();
        return this;
    }
    @Step("Нажать Enter")
    public RegistrationPage pressSubmit(){
        submitLocator.click();
        return this;
    }
}