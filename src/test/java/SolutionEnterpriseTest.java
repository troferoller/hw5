
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SolutionEnterpriseTest {
    @BeforeAll
    static void configs(){
        Configuration.browserSize = "2560x1440";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void checkContent() {
        open("https://github.com");
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));

    }
}