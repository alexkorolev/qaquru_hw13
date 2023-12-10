package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private SelenideElement userNameLocator = $("#userName"),
            userEmailLocator = $("#userEmail"),
            currentAddressLocator = $("#currentAddress"),
            permanentAddressLocator = $("#permanentAddress"),
            submitButton = $("#submit"),
            resultBox = $("#output");


    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage removeBanners(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName (String value) {
        userNameLocator.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail (String value) {
        userEmailLocator.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress (String value) {
        currentAddressLocator.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress (String value) {
        permanentAddressLocator.setValue(value);
        return this;
    }

    public TextBoxPage pressSubmit() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        resultBox.$(withText(key)).shouldHave(text(value));
        return this;
    }
}