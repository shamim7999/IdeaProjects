package com.functional.programming;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class App
{
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

    private static List<Person> add(Person ... people) {
        List<Person> persons = Arrays.stream(people)
                                    .collect(Collectors.toList());
        return persons;
    }

    public static void main( String[] args )
    {
        List<Person> persons = add(
            new Person("Shamim", "MALE"),
            new Person("Tamim", "MALE"),
            new Person("Imon", "MALE"),
            new Person("Kashfi", "FEMALE"),
            new Person("Alice", "FEMALE"),
            new Person("Maria", "FEMALE")
        );
        System.out.println("The whole List");
        persons.stream().forEach(System.out::println);

        System.out.println("\nThe whole Female List");
        persons.stream()
                .filter(person -> ("FEMALE").equals(person.gender))
                .forEach(System.out::println);


        System.out.println("\nThe whole Male List");
        List<Person> males = persons.stream()
                .filter(person -> "MALE".equals(person.gender))
                .collect(Collectors.toList());
        males.stream().forEach(System.out::println);

        /// Another way..
        System.out.println("\nThe whole Male List, by using Predicate..");
        Predicate <Person> personPredicate = person -> "MALE".equals(person.gender);
        List<Person> males2 = persons.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
        males2.forEach(System.out::println);

        List<Integer> nums = List.of(1, 2, 3, 4, 5);


        Function<Integer, Integer> incrementByOne = num -> num + 1; // ---> Or we can declare it as mentioned in comment at bottom
        System.out.println("\nUsing incrementByOne Function");
        int x = incrementByOne.apply(4);
        System.out.println("x: "+x);

        System.out.println("\nMerging incrementByOne And multiplyByTen");

        Function <Integer, Integer> addBy1AndThenMultiplyBy10AndThenAdd1 = incrementByOne.andThen(multiplyByTen).andThen(incrementByOne);
        x = addBy1AndThenMultiplyBy10AndThenAdd1.apply(x);
        System.out.println("x: "+x);

        System.out.println("\nUsing BiFunction to use incrementByOneAndMultiplyBiFunction: ");
        System.out.println(
                incrementByOneAndMultiplyBiFunction.apply(4, 100)
        );
    }

    //static Function<Integer, Integer> incrementByOne = num -> num + 1;
    static Function<Integer, Integer> multiplyByTen = num -> num * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;
}
