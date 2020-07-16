package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestOrderCard {

    @Test
    void shouldTestOrderCard() {
        Configuration.headless = true;
        open("http://localhost:9999");
        SelenideElement form = $("[method='post']");
        form.$("[name='name']").setValue("Андреев");
        form.$("[type='tel']").setValue("+79998887755");
        form.$("[data-test-id='agreement']").click();
        form.$("[type='button']").click();
        $("[data-test-id='order-success']").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
