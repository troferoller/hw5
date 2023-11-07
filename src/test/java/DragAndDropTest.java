import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    private final SelenideElement dragItem = $("#column-a");
    private final SelenideElement dropTarget = $("#column-b");
    @BeforeAll
    static void configs(){
        Configuration.browserSize = "2560x1440";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void checkContent() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.dragAndDrop(dragItem.toWebElement(), dropTarget.toWebElement()).perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        $("#column-a").dragAndDropTo(element("#column-b"));
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
    }
}