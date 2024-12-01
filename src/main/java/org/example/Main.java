package org.example;

import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> names = List.of("Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad",
                "Ali", "Davood", "Reza", "Mohsen", "asghar", "ben", "Ben");

        List<Integer> numbers = List.of(1,20,27,11,0,3,30,31,47);

        List<Double> doubleNumbers = List.of(1.0,20.0,27.0,11.0,3.0,30.0,31.0,47.0,0.0);

        List<String> sentences = List.of(
                "David is a man",
                "Robert is a boy",
                "Adam is ","Alisa","Arash","Sarah","ali","adam"
        );




        System.out.println("The number of chars for each words are: ");
        stringCharCounter(names).forEach((k,v) -> System.out.println(k + ":" + v));

        System.out.println("\nThe number of chars for each words are: ");
        stringCharWordsCounter(names).forEach((k,v) -> System.out.println("String Length " + k + ":" + v));

        System.out.println("\nThe number of chars for each words are: ");
        stringCharCounterWithWordCount2(names).forEach((k, v) -> System.out.println("Length " + k + ": " + v));


        System.out.println("\nFirst character finder:  ");
        firstCharFinder(names).forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println("\nNames starts with 'A': ");
        namesStartsWithA(names).forEach(System.out::println);

        System.out.println("\nSum of Even numbers: ");
        System.out.println(sumOfEvenNumbers(numbers));

        System.out.println("\nSorted names not case sensitive: ");
        sortNamesToUpperCase(names).forEach(System.out::println);

        System.out.println("\nSorted names case sensitive");
        sortNamesCaseSensitive(names).forEach(System.out::println);

        System.out.println("\nMinimum number is: ");
        System.out.println(minNumFinder(doubleNumbers));

        System.out.println("\nMaximum number is: ");
        System.out.println(maxNumFinder(doubleNumbers));

        System.out.println("\nSorted words Alphabetically: ");
        stringsDividerAlphabetically(names).forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println("\nWords counter: ");
        wordCounter(sentences).forEach((k,v) -> System.out.println(k + ":" + v));

    }
    public static Map<Integer, List<String>> stringCharCounter (List<String> stringList){
      return stringList.stream().collect(Collectors.groupingBy(s -> s.length()));
    };

    public static Map<Integer, Long> stringCharWordsCounter(List<String> stringList) {
        return stringList.stream()
                .collect(Collectors.groupingBy(s -> s.length(), Collectors.counting()));
    }

    public static Map<Integer, String> stringCharCounterWithWordCount2(List<String> stringList) {
        return stringList.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                words -> "Words: " + words + ", Count: " + words.size()
                        )
                ));
    }

    public static Map<Character, List<String>> firstCharFinder(List<String> stringList){
        return stringList.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
    };

    public static List<String> namesStartsWithA (List<String> stringLists){
        return stringLists.stream().filter(s -> s.startsWith("A")).toList();
    };

    public static int sumOfEvenNumbers (List<Integer> numbers){
        return numbers.stream().filter(n -> n % 2 == 0).reduce(0,(n1,n2) -> n1+n2);
    }

    public static List<String> sortNamesToUpperCase(List<String> stringLists){
        return stringLists.stream().sorted().map(s -> s.toUpperCase()).toList();
    };

    public static List<String> sortNamesCaseSensitive(List<String> stringLists){
        return stringLists.stream().sorted((s1,s2) -> s1.compareToIgnoreCase(s2)).toList();
    };

    public static double minNumFinder (List<Double> doubleNumbers){
        Optional<Double> output = doubleNumbers.stream().min(Comparator.naturalOrder());
        if(output.isPresent())
            return output.get();
        else return 0;


    };
    public static double maxNumFinder (@NonNull List<Double> doubleNumbers){
        return doubleNumbers.stream().max(Comparator.naturalOrder()).get();
    };
    public static Map<Character, List<String>> stringsDividerAlphabetically (List<String> stringList){
        return stringList.stream()
                .collect(Collectors.groupingBy(
                        s -> Character.toLowerCase(s.charAt(0)),
                        HashMap::new,
                        Collectors.collectingAndThen(
                                Collectors.toMap(
                                        word -> word.toLowerCase(),
                                        word -> word,
                                        (existing, replacement) -> existing,
                                        HashMap::new
                                ),
                                map -> new ArrayList<>(map.values())
                        )
                ));
    };

    public static Map<Integer, List<String>> wordCounter (List<String> stringList){
        return stringList.stream().collect(Collectors.groupingBy(s -> s.split(" ").length,
                HashMap::new,
                Collectors.toList()));
    };





}
