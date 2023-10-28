package com.functionalprogramming.optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        
        Optional.ofNullable("vishal@gmail.com")
                // .ifPresent(email -> System.out.println("Sending email to " + email));
                .ifPresentOrElse(
                    email -> System.out.println("Sending email to " + email)  
                , 
                    () -> System.out.println("Cannot send email")
                );

        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");
        System.out.println(value);
    }
}
