package ru.netology;

import com.github.javafaker.Address;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.PhoneNumber;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class RegistrationByInfo {

    private final String name;
    private final String phone;
    private final String city;

    public RegistrationByInfo(String name, String phone, String city) {

        this.name = name;
        this.phone = phone;
        this.city = city;
    }


    public String getName() {

        return name;
    }

    public String getPhone() {

        return phone;
    }

    public String getCity() {

        return city;
    }

}

