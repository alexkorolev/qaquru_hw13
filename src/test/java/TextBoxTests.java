import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends BaseTest{

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName("Alex")
                .setUserEmail("alex@egorov.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .pressSubmit()
                .checkResult("Name:","Alex" )
                .checkResult("Email:", "alex@egorov.com")
                .checkResult("Current Address :", "Some street 1")
                .checkResult("Permananet Address :", "Another street 1");
    }
}