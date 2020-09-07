package ru.netology;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DataGenerator {

    private DataGenerator() {}

    public static class Registration {

        private Registration() {

        }

        public static String getDate(int daysToAdd) {
            LocalDate dateMeetingForTest = LocalDate.now().plusDays(daysToAdd);
            return dateMeetingForTest.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static String getCity (){
            String[] myString = new String[]{"Москва", "Казань", "Хабаровск", "Абакан", "Белгород", "Курск", "Иркутск", "Калуга", "Ярославль", "Владимир"};
            int n = (int)Math.floor(Math.random() * myString.length);
            return myString[n];
        }

        public static RegistrationByInfo generateByInfo(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationByInfo(faker.name().lastName() + " " + faker.name().firstName(),
                    faker.phoneNumber().phoneNumber(), getCity());
        }
    }
}


