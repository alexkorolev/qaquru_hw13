package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ResultWindow {
    private SelenideElement resultTableLocator = $(".table-responsive"),
            modalContentLoctor = $(".modal-content");

    public ResultWindow checkModalWindowDisplayed(){
        modalContentLoctor.should(appear);
        return this;
    }

    public ResultWindow checkModalWindowNotDisplayed(){
        modalContentLoctor.shouldNot(appear);
        return this;
    }
    public ResultWindow checkTableText(String value){
        resultTableLocator.shouldHave(text(value));
        return this;
    }
}