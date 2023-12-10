import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void beforeMethod(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
}