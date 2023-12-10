package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    @Step("Установка даты в календаре")
    public void setDateOfBirth(String day, String month, String year){
        $("select[class*='month-select']").selectOption(month);
        $("select[class*='year-select']").selectOption(year);
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text(day)).click();
    }
}