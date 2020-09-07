package ru.netology;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.DataGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static ru.netology.DataGenerator.Registration.generateByInfo;
import static ru.netology.DataGenerator.Registration.getDate;


public class FormTest {
    RegistrationByInfo person;
    String planDate;

    @BeforeEach
    void setup() {
        person = generateByInfo("ru");
        planDate = getDate(3);
        open("http://localhost:9999");
    }

    @Test
    void shouldRegister() {

        open("http://localhost:9999");
        RegistrationByInfo person = generateByInfo("ru");
        $("[placeholder='Город']").setValue(person.getCity());
        $("[placeholder='Дата встречи']").setValue(planDate);
        $("[name='name']").setValue(person.getName());
        $("[name='phone']").setValue(person.getPhone());
        $("[class='checkbox__box']").click();
        $$("button").find(exactText("Запланировать")).click();
        $("[class='notification__content']").waitUntil(Condition.visible, 15000).shouldHave(text(planDate));
    }

    @Test
    void shouldChangeTheMeetingDate() {
        String replanDate = getDate(5);
        $("[placeholder='Город']").setValue(person.getCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(planDate);
        $("[name='name']").setValue(person.getName());
        $("[name='phone']").setValue(person.getPhone());
        $("[class='checkbox__box']").click();
        $$("button").find(exactText("Запланировать")).click();
        $("[class='notification__content']").waitUntil(Condition.visible, 15000).shouldHave(text(planDate));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(replanDate);
        $$("button").find(exactText("Запланировать")).click();
        $(withText("Необходимо подтверждение")).waitUntil(Condition.visible, 15000);
        $$("button").find(exactText("Перепланировать")).click();
        $("[class='notification__content']").waitUntil(Condition.visible, 15000).shouldHave(text(replanDate));
    }

}



