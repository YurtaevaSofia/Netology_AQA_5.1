import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class FormTest {

    private Faker faker;

    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

    @Test
    void shouldRegister() {

        open("http://localhost:9999");

        RegistrationByInfo person = DataGenerator.Registration.generateByInfo("ru");

        $("[placeholder='Город']").setValue(person.getCity().city());

        $("[placeholder='Дата встречи']").setValue(person.getDate().toString());

        $("[name='name']").setValue(person.getName());

        $("[name='phone']").setValue(person.getPhone().cellPhone());

        $("[class='checkbox__box']").click();

        $$("button").find(exactText("Запланировать")).click();

        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);
    }

    @Test
    void shouldChangeTheMeetingDate() {

        open("http://localhost:9999");

        RegistrationByInfo person = DataGenerator.Registration.generateByInfo("ru");

        $("[placeholder='Город']").setValue(person.getCity().city());

        $("[placeholder='Дата встречи']").setValue(person.getDate().toString());

        $("[name='name']").setValue(person.getName());

        $("[name='phone']").setValue(person.getPhone().cellPhone());

        $("[class='checkbox__box']").click();

        $$("button").find(exactText("Запланировать")).click();

        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);

        person.changeDate();

        $("[placeholder='Дата встречи']").setValue(person.getDate().toString());

        $$("button").find(exactText("Запланировать")).click();

        $(withText("Необходимо подтверждение")).waitUntil(Condition.visible, 15000);

        $$("button").find(exactText("Перепланировать")).click();

        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);

    }


}