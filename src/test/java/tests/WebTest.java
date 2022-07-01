package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class WebTest extends TestBase {

    String searchWord = "палатки";

    @Test
    @DisplayName("Поиск заданной категории товара в каталоге")
    public void goodsCategoryShouldBeFound() {
        step("Открыть главную страницу", () -> open("/"));
        step("Ввести в строку поиска " + searchWord, () ->
                $("[placeholder=\"Поиск\"]")
                        .setValue(searchWord)
                        .pressEnter());
        step("Проверить, что найдены товары по запросу " + searchWord, () ->
                $("[data-selenium=\"category-title\"]")
                        .should(Condition.text(searchWord))
                        .should(Condition.visible));
    }
}
