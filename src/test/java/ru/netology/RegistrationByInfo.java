package ru.netology;

import com.github.javafaker.Address;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.PhoneNumber;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class RegistrationByInfo {

    private final String name;
    private final PhoneNumber phone;
    private final String city;
    private final LocalDate date;

    public RegistrationByInfo(String name, PhoneNumber phone, String city, LocalDate date) {

        this.name = name;
        this.phone = phone;
        this.city = city;
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public PhoneNumber getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getDate() {
        return date;
    }

    }

