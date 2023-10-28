package com.functionalprogramming.finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {

        // both are same
        // Function<String, String> upperCaseName = String::toUpperCase;
        // Function is a functional interface and it takes one argument. 
        // The first String is the type of argument and second String is return type
        Function<String, String> upperCaseName = name -> name.toUpperCase();
        System.out.println(upperCaseName.apply("hello"));

        // BiFunction is a functional interface and it takes two arguments.
        // The first & second String is the type of arguments and third String is return type
        BiFunction<Integer, Integer, Integer> sumNums = (num1, num2) -> {
            int sum=num1+num2;
            return sum;
        };
        System.out.println(sumNums.apply(10, 20));
    }
}
