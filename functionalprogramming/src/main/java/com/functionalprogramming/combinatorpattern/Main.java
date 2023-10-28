package com.functionalprogramming.combinatorpattern;

import java.time.LocalDate;

import com.functionalprogramming.combinatorpattern.CustomerRegistrationValidator.ValidationResult;

public class Main {
    public static void main(String[] args) {
        System.out.println("hhhhh");
        Customer customer = new Customer(
            "Vishal", 
            "vishal@gmail.com", 
            "+918888888888", 
            LocalDate.of(2000, 9, 18)
        );

        CustomerValidatorService validatorService = new CustomerValidatorService();
        System.out.println(validatorService.isValid(customer));
        System.out.println(new CustomerValidatorService().isValid(customer));

        // if valid we can store customer in db

        // Using combinator pattern
        ValidationResult result = CustomerRegistrationValidator.isEmailValid()
            .and(CustomerRegistrationValidator.isphoneNumberValid())
            .and(CustomerRegistrationValidator.isAnAdult())
            .apply(customer);
        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
/*
A combinator pattern is a design pattern that allows you to chain functions together, so basically a combinator is a function
that might take all the functions as arguments and returns new function.
This is an awesome pattern. 
*/
