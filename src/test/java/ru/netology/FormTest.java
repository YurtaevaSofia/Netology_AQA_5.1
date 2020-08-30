package ru.netology;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.DataGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class FormTest {

    @Test
    void shouldRegister() {

        open("http://localhost:9999");
        RegistrationByInfo person = DataGenerator.Registration.generateByInfo("ru");
        $("[placeholder='Город']").setValue(person.getCity());
        $("[placeholder='Дата встречи']").setValue(person.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        $("[name='name']").setValue(person.getName());
        $("[name='phone']").setValue(person.getPhone().phoneNumber());
        $("[class='checkbox__box']").click();
        $$("button").find(exactText("Запланировать")).click();
        $("[class='notification__content']").waitUntil(Condition.visible, 15000).shouldHave(text(person.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
    }

    @Test
    void shouldChangeTheMeetingDate() {

        open("http://localhost:9999");
        RegistrationByInfo person = DataGenerator.Registration.generateByInfo("ru");
        $("[placeholder='Город']").setValue(person.getCity());
        $("[placeholder='Дата встречи']").setValue(person.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        $("[name='name']").setValue(person.getName());
        $("[name='phone']").setValue(person.getPhone().phoneNumber());
        $("[class='checkbox__box']").click();
        $$("button").find(exactText("Запланировать")).click();
        $("[class='notification__content']").waitUntil(Condition.visible, 15000).shouldHave(text(person.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
        DataGenerator.Registration.changeDate(person);
        $("[placeholder='Дата встречи']").setValue(person.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        $$("button").find(exactText("Запланировать")).click();
        $(withText("Необходимо подтверждение")).waitUntil(Condition.visible, 15000);
        $$("button").find(exactText("Перепланировать")).click();
        $("[class='notification__content']").waitUntil(Condition.visible, 15000).shouldHave(text(person.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
    }


}



