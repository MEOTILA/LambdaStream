package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> names = List.of("Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad",
                "Ali", "Davood", "Reza", "Mohsen");


        System.out.println("The number of chars for each words are: ");
        stringCharCounter(names).forEach((k,v) -> System.out.println(k + ":" + v));

        System.out.println("\nThe number of chars for each words are: ");
        stringCharWordsCounter(names).forEach((k,v) -> System.out.println("String Length " + k + ":" + v));

        System.out.println("\nFirst character finder:  ");
        firstCharFinder(names).forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println("\nNames starts with 'A': ");
        namesStartsWithA(names).forEach(System.out::println);

    }
    public static Map<Integer, List<String>> stringCharCounter (List<String> stringList){
      return stringList.stream().collect(Collectors.groupingBy(s -> s.length()));
    };

    public static Map<Integer, Long> stringCharWordsCounter(List<String> stringList) {
        return stringList.stream()
                .collect(Collectors.groupingBy(s -> s.length(), Collectors.counting()));
    }

    public static Map<Character, List<String>> firstCharFinder(List<String> stringList){
        return stringList.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
    };

    public static List<String> namesStartsWithA (List<String> stringLists){
        return stringLists.stream().filter(s -> s.startsWith("A")).toList();
    };

}
