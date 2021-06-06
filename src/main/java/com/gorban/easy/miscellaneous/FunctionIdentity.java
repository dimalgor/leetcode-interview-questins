package com.gorban.easy.miscellaneous;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionIdentity {

    public static void main(String[] args){
        List<String> names = Arrays.asList(
                "Ivanov",
                "Petrov",
                "Ivanov",
                "Petrov",
                "Sidorov",
                "Petrov",
                "Gorban",
                "Petrov");

        Set<String> namesSet = new HashSet<>(names);

        names.stream()
                .map(getFunction(names, names.size() != namesSet.size()))
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    static Function<String, String> getFunction(List<String> names, boolean hasDuplicates){
        return hasDuplicates
                ? name -> name + " (" + Collections.frequency(names, name) + ")"
                : Function.identity();
    }
}
