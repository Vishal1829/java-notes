package org.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<List<String>> sentenceList = Arrays.asList(
                Arrays.asList("I", "LOVE", "JAVA"),
                Arrays.asList("CONCEPTS", "ARE", "CLEAR"),
                Arrays.asList("ITS", "VERY", "EASY")
        );

        Stream<String> wordsStream1 = sentenceList.stream()
                  .flatMap( (List<String> sentence) -> sentence.stream() );
//                .flatMap( (List<String> sentence) -> sentence.stream().map((String value) -> value.toLowerCase()) );
        System.out.println(wordsStream1.collect(Collectors.toList()));


//        Intermediate Operations are "Lazy"
        List<Integer> numbers = Arrays.asList(2, 1, 4, 7, 10);
        Stream<Integer> numbersStream = numbers.stream()
                .filter((Integer val) -> val>=3)
                .peek((Integer val) -> System.out.println(val));

//        From the above example if we run just the above example then nothing will get printed as Intermediate operations
//        are "Lazy" means this streams only get executed when Terminal Operation is invoked.

        List<Integer> numbers1 = Arrays.asList(2, 1, 4, 7, 10);
        Stream<Integer> numbersStream1 = numbers1.stream()
                .filter((Integer val) -> val>=3)
                .peek((Integer val) -> System.out.println(val));

        numbersStream1.count(); //count is one of the terminal operation

    }
}