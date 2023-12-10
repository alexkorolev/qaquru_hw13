import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultWindow;

@Tag("lesson")
public class RegistrationForm  extends BaseTest{

    RegistrationPage registrationPage = new RegistrationPage();
    ResultWindow resultWindow = new ResultWindow();
    DataForm human = new DataForm();

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