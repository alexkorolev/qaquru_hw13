package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ResultWindow {
    private SelenideElement resultTableLocator = $(".table-responsive"),
            modalContentLoctor = $(".modal-content");

    @Step("Проверка появления окна")
    public ResultWindow checkModalWindowDisplayed(){
        modalContentLoctor.should(appear);
        return this;
    }
    @Step("Проверка отсутствия окна")
    public ResultWindow checkModalWindowNotDisplayed(){
        modalContentLoctor.shouldNot(appear);
        return this;
    }
    @Step("Проверка текста в окне с данными клиента")
    public ResultWindow checkTableText(String value){
        resultTableLocator.shouldHave(text(value));
        return this;
    }
}