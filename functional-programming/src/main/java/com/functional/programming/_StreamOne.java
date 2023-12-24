package com.functional.programming;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class _StreamOne {

    static class Person {
        private final String name;
        private final String gender;

        public Person(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Shamim", "MALE"),
                new Person("Tamim", "MALE"),
                new Person("Imon", "MALE"),
                new Person("Kashfi", "FEMALE"),
                new Person("Alice", "FEMALE"),
                new Person("Maria", "FEMALE")
        );

        persons.stream()
                .map(person -> person.name)
                .mapToInt(person -> person.length())
                //.collect(Collectors.toList())
                .forEach(System.out::println);

        /// Matching

        boolean containsOnlyFemales = persons.stream()
                .allMatch(person -> "FEMALE".equals(person.gender));
        System.out.println("\n\nContains Only Females is: "+containsOnlyFemales);

        boolean containsAtleastOneFemale = persons
                .stream()
                .anyMatch(person -> person.gender.equals("FEMALE"));
        System.out.println("Contains at least One Females is: "+containsAtleastOneFemale);

    }


}
