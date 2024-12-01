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

        System.out.println("The number of chars for each words are: ");



    }
    public static Map<Integer, List<String>> stringCharCounter (List<String> stringList){
      return stringList.stream().collect(Collectors.groupingBy(s -> s.length()));
    };
}