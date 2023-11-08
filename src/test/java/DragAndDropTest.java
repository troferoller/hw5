import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selenide.actions;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @BeforeAll
    static void configs(){
        Configuration.browserSize = "2560x1440";
        Configuration.pageLoadStrategy = "eager";
    }
    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
    @Test
    void checkContent() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().dragAndDrop($("#column-a"), $("#column-b")).perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
    @Test
    void anotherOne() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $(element("#column-a")).dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}