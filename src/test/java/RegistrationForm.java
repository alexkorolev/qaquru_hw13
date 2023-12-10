import helpers.Attach;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultWindow;

public class RegistrationForm  extends BaseTest{

    RegistrationPage registrationPage = new RegistrationPage();
    ResultWindow resultWindow = new ResultWindow();
    DataForm human = new DataForm();

    @Step("Добавление скриншотов, логов и видеофайлов")
    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Tag("lesson")
    @Test
    void fillFullPracticeForm() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(human.firstName)
                .setLastName(human.lastName)
                .setUserEmail(human.eMail)
                .setGender(human.gender)
                .setSubject(human.subjects)
                .setUserNumber(human.phoneNumber)
                .setCalendarDate(human.dayOfBirth, human.mounthOfBirth, human.yearhOfBirth)
                .setHobbies(human.hobbies)
                .uploadPicture(human.pictureName)
                .setAddress(human.streetAdress)
                .setState(human.state)
                .setCity(human.city)
                .pressSubmit();

        resultWindow.checkModalWindowDisplayed()
                .checkTableText(human.firstName + " " + human.lastName)
                .checkTableText(human.eMail)
                .checkTableText(human.gender)
                .checkTableText(human.phoneNumber)
                .checkTableText(human.dayOfBirth + " " + human.mounthOfBirth + "," + human.yearhOfBirth)
                .checkTableText(human.subjects)
                .checkTableText(human.hobbies)
                .checkTableText(human.pictureName)
                .checkTableText(human.streetAdress)
                .checkTableText(human.state + " " + human.city);
    }

    @Tag("lesson")
    @Test
    void fillMinFieldsOfPracticeForm() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(human.firstName)
                .setLastName(human.lastName)
                .setUserEmail(human.eMail)
                .setGender(human.gender)
                .setUserNumber(human.phoneNumber)
                .pressSubmit();

        resultWindow.checkModalWindowDisplayed()
                .checkTableText(human.firstName + " " + human.lastName)
                .checkTableText(human.eMail)
                .checkTableText(human.gender)
                .checkTableText(human.phoneNumber);
    }

    @Tag("lesson")
    @Test
    void notFillMinFieldsOfForm() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(human.firstName)
                .setLastName(human.lastName)
                .setUserEmail(human.eMail)
                .setGender(human.gender)
                .pressSubmit();

        resultWindow.checkModalWindowNotDisplayed();
    }
}