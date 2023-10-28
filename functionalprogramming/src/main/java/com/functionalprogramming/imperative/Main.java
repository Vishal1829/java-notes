package com.functionalprogramming.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(
            new Person("Vishal", Gender.MALE),
            new Person("Lakshay", Gender.MALE),
            new Person("Roshni", Gender.FEMALE),
            new Person("Supriya", Gender.FEMALE),
            new Person("Himank", Gender.MALE),
            new Person("Jyoti", Gender.FEMALE)
        );
     
        System.out.println("// Imperative approach");
        // Imperative approach
        List<Person> females = new ArrayList<>();

        for(Person person : people) {
            if(Gender.FEMALE.equals(person.gender))
              females.add(person);
        }

        for(Person female : females) {
          System.out.println(female);
        }

        System.out.println("// Declarative approach");
        // Declarative approach
        // people.stream()
        //         .filter(person -> Gender.FEMALE.equals(person.gender))
        //         .forEach(System.out::println);

        // So this predicate accepts a Person and then returns true of false based on the specified logic.
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        people.stream()
                .filter(personPredicate)
                .forEach(System.out::println);

        // List<Person> femaleList = people.stream()
        //         .filter(person -> Gender.FEMALE.equals(person.gender))
        //         .collect(Collectors.toList());
        // femaleList.forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
          this.name = name;
          this.gender = gender;
        }

        @Override
        public String toString() {
          return "Person [name=" + name + ", gender=" + gender + "]";
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}

/*
 Package - java.util.function
 This package contains a lot of functional interfaces.
 Functional interfaces provide target types for lambda expressions and method references.
 Source:- https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

 Ex:-
 Predicate<T>  -  Represents a predicate (boolean-valued function) of one argument.
 */