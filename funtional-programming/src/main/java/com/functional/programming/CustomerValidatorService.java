package com.functional.programming;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
    private boolean isValidEmail(String email) {
        return email.contains("@");
    }
    private boolean isValidPhoneNumber(String phoneNUmber) {
        return phoneNUmber.startsWith("01");
    }

    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() >= 25;
    }

    public boolean isValid(Customer customer) {
        return isAdult(customer.getDob()) && isValidEmail(customer.getEmail())
                && isValidPhoneNumber(customer.getPhoneNumber());
    }
}
