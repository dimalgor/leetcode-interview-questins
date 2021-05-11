package com.gorban.easy;

import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdasIntro {

    public static void main(String[] args) {
        // 1
        Runnable noArguments = () -> System.out.println("Hello World!");
        // 2
        ActionListener oneArgument = event -> System.out.println("button clicked!");
        // 3
        Runnable multiStatement = () -> {
            System.out.println("Hello");
            System.out.println("World");
        };
        // 4
        BinaryOperator<Long> add = (x, y) -> x + y;
        // 5
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;

        //Example 2.9
        //1
        Map<String, Integer> oldWordCounts = new HashMap<String, Integer>();
        //2
        Map<String, Integer> diamondCounts = new HashMap<>();

        // Example 2.11
        Predicate<Integer> atLeast5 = x -> x > 5;

        // Example 2.13
        BinaryOperator<Long> addLong = (x, y) -> x + y;

        // Example 2.14
//        Will not compile because compiler cannot guess the type Integer or String
//        BinaryOperator add = (x, y) -> x + y;

        List<String> collected = Stream.of("a", "b", "c", "hello")
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println("Uppercased strings: " + collected.toString());

        example311();
        example312();
        example313();
    }

    private static void example311() {
        List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(Collectors.toList());
        System.out.println("beginningWithNumbers: " + beginningWithNumbers);
    }

    private static boolean isDigit(Character c) {
        return c.equals('1') ? true : false;
    }

    private static void example312() {
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());

        System.out.println("Together: " + together.toString());
    }

    private static void example313() {
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));

        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getDuration())).get();
        System.out.println("Shortest track: " + shortestTrack);
    }

    private static class Track {
        private String name;
        private int duration;

        private Track(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }

        public String getName() {
            return name;
        }

        public int getDuration() {
            return duration;
        }

        @Override
        public String toString() {
            return "Track{" +
                    "name='" + name + '\'' +
                    ", duration=" + duration +
                    '}';
        }
    }


}
