package com.functionalprogramming.streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Stream {
  public static void main(String[] args) {

      List<Person> people = List.of(
            new Person("Vishal", Gender.MALE),
            new Person("Lakshay", Gender.MALE),
            new Person("Roshni", Gender.FEMALE),
            new Person("Supriya", Gender.FEMALE),
            new Person("Himank", Gender.MALE),
            new Person("Jyoti", Gender.FEMALE)
        );

      // people.stream()
      //         .map(person -> person.gender)
      //         .collect(Collectors.toSet())
      //         .forEach(System.out::println);

      // System.out.println();
      
      //this Function takes a Person object and return a String
      // Function<Person, String> personStringFunction = person -> person.name;
      //this Function takes a String and return its length
      // ToIntFunction<String> length = String::length;
      //this Consumer takes an Integer and returns nothing
      // IntConsumer println = x -> System.out.println(x);

      // people.stream()
      //         .map(personStringFunction)
      //         .mapToInt(length)
      //         .forEach(println);
      // //both are same
      // people.stream()
      //         .map(person -> person.name)
      //         .mapToInt(String::length)
      //         .forEach(System.out::println);

      Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
      boolean containsOnlyFemales = people.stream()
            // .allMatch(personPredicate);
            .anyMatch(personPredicate);
      System.out.println(containsOnlyFemales);
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
