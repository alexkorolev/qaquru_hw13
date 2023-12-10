package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    public void setDateOfBirth(String day, String month, String year){
        $("select[class*='month-select']").selectOption(month);
        $("select[class*='year-select']").selectOption(year);
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text(day)).click();
    }
}