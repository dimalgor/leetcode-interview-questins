package com.gorban.easy.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ExamplesFromDocumentation {

    static class Person{
        private String name;

        public String getName() {
            return name;
        }

        public Person(String name) {
            this.name = name;
        }
    }

    public static void main(String[]args){
        final var persons = new ArrayList<Person>();
        persons.add(new Person("Ivanov"));
        persons.add(new Person("Petrov"));
        persons.add(new Person("Sidorov"));

        List<String> people = persons.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("people: " + people);

        Set<String> set = persons.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("set: " + set);

        String joined = persons.stream().map(Person::getName).collect(Collectors.joining(" + "));
        System.out.println("Joined people: " + joined);




    }
}
