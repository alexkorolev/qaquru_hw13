import com.codeborne.selenide.Configuration;
import helpers.Attach;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @Step("Настройка значений по умолчанию")
    @BeforeAll
    public void beforeMethod(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @Step("Добавление скриншотов, логов и видеофайлов")
    @AfterEach
    public void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}