package com.functionalprogramming.functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {

        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("07847483987"));
        System.out.println(isPhoneNumberValid("9947483987"));

        System.out.println("With Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07847483987"));

        System.out.println();
        System.out.println(
          "is phone number valid and contains number 3 " +
          isPhoneNumberValidPredicate.and(containsNumber3).test("07847483987")
        );
        System.out.println(
          "is phone number valid or contains number 3 " +
          isPhoneNumberValidPredicate.or(containsNumber3).test("99847483987")
        );
    }

    
    static boolean isPhoneNumberValid(String phoneNumber) {
      return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> 
          phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber -> 
          phoneNumber.contains("3");

    
  }
