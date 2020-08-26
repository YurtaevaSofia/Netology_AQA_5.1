import com.github.javafaker.Address;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.PhoneNumber;

import java.util.concurrent.TimeUnit;

public class RegistrationByInfo {

    private final String name;
    private final PhoneNumber phone;
    private final Address city;
    private final DateAndTime date;

    public RegistrationByInfo(String name, PhoneNumber phone, Address city, DateAndTime date) {

        this.name = name;
        this.phone = phone;
        this.city = city;
        this.date = date;
    }

    public DateAndTime changeDate (){
        date.future(3, TimeUnit.DAYS);
        return date;
    }

    public String getName() {
        return name;
    }

    public PhoneNumber getPhone() {
        return phone;
    }

    public Address getCity() {
        return city;
    }

    public DateAndTime getDate() {
        return date;
    }

    }

