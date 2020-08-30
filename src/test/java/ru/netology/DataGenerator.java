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

        private Registration() {}

        public static LocalDate getDate (){
            LocalDate dateMeetingForTest = LocalDate.now().plusDays(3);
            return  dateMeetingForTest;
        }

        public static String getCity (){
            String[] myString = new String[]{"Москва", "Казань", "Хабаровск", "Абакан", "Белгород", "Курск", "Иркутск", "Калуга", "Ярославль", "Владимир"};
            int n = (int)Math.floor(Math.random() * myString.length);
            return myString[n];
        }

        public static RegistrationByInfo generateByInfo(String locale) {
            Faker faker = new Faker(new Locale("ru"));
            return new RegistrationByInfo(
                    faker.name().fullName(), faker.phoneNumber(), getCity(), getDate());
        }

        public static LocalDate changeDate (RegistrationByInfo person){
            person.getDate().plusDays(3);
            return person.getDate();
        }
    }}


