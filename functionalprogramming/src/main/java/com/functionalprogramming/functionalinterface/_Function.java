package com.functionalprogramming.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        int val = incrementByOne(3);
        System.out.println(val);

        // Function takes 1 argument and produces 1 result
        int val2 = incrementByOneFunction.apply(3);
        System.out.println(val2);

        // int val3 = multiplyBy10Function.apply(val2);
        // System.out.println(val3);
        // better way to do this using function chaining
        Function<Integer, Integer> addByOneAndMultiplyBy10 =
                          incrementByOneFunction.andThen(multiplyBy10Function);
        int val3 = addByOneAndMultiplyBy10.apply(3);
        System.out.println(val3);

        // BiFunction takes 2 arguments and produces 1 result
        int val4 = incrementByOneAndMultiplyBiFunction.apply(4, 20);
        System.out.println(val4);
    }

    //these two are the exact same thing 
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }

    // Below two are same
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = 
          (Integer numberToIncrementByOne, Integer numToMultiplyBy) -> (numberToIncrementByOne + 1) * numToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }

}

/*
 Function<T,R> - Represents a function that accepts one argument and produces a result.
 T is input, R is output.

 BiFunction<T,U,R> - Represents a function that accepts two arguments and produces a result.
 T & U are input, R is output.
 */