package com.gorban.easy.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ExamplesFromDocumentation {

    public static void main(String[] args) {
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

        final var employees = List.of(new Employee("Ivanov", 100),
                                      new Employee("Petrov", 200),
                                      new Employee("Sidorov", 300));

        final var employeesSalary = employees.stream()
                                             .collect(Collectors.summarizingInt(Employee::getSalary));

        System.out.println("employeesSalary: " + employeesSalary);

        // Group Employees by department:
        final var employeesDepartments = List.of(
                new Employee("Ivanov", 100, "Security"),
                new Employee("Petrov", 200, "IT"),
                new Employee("Sidorov", 300, "IT"));

        final var employeesByDepartment = employeesDepartments.stream()
                                                              .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("employeesByDepartment: " + employeesByDepartment);

        // Compute sum of salaries by department
        final var salariesByDepartment = employeesDepartments.stream()
                                                             .collect(Collectors.groupingBy(Employee::getDepartment,
                                                                                            Collectors.summarizingInt(
                                                                                                    Employee::getSalary)));
        System.out.println("salariesByDepartment: " + salariesByDepartment);

        // Partition students into passing and failing
        final var students = List.of(
                new Student("Ivanov", 3),
                new Student("Petrov", 4),
                new Student("Sidorov", 5));

        final var passingFailing =
                students.stream().collect(Collectors.partitioningBy(s -> s.getGrade() >= Student.PASS_THRESHOLD));

        System.out.println("passingFailing: " + passingFailing);
    }

    static class Student {

        private static int PASS_THRESHOLD = 4;
        private int grade;
        private String lastName;

        public Student(final String lastName, final int grade) {
            this.grade = grade;
            this.lastName = lastName;
        }

        public int getGrade() {
            return grade;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "grade=" + grade +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    static class Person {

        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Employee {

        private String name;
        private int salary;
        private String department;

        public Employee(String name, int salary, String department) {
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    '}';
        }
    }
}
