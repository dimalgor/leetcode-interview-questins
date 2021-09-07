package com.gorban.easy.lambdas;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CollectionsAndCollectors {

    public static void main(String[] args){
        example5_3();
    }

    public static void example5_3(){
        Set<Integer> numbers = new HashSet<>(Arrays.asList(4,3,2,1));
        List<Integer> sameOrder = numbers.stream().sorted().collect(toList());
        System.out.println("nambers: " + numbers);
        System.out.println("sameOrder: " + sameOrder);
    }

}
