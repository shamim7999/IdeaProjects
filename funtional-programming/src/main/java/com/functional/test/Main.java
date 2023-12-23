package com.functional.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    //Function<Integer, Integer> parity = (x) ->
    //    x%2 == 0;

    public static void main(String[] args) {
        MyFunctionalInterface ob = (x, y) -> x+y;

        System.out.println( ob.sum(32, 45.3));

        List<Integer> nums = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toList());


        int sum = nums.stream()
                        .mapToInt(x -> x%2 == 0 ? x : x+x)
                                .sum();
        System.out.println(sum);

        nums.stream()
                .filter(x -> x%2 == 0)
                .filter(x -> x%8 != 0)
                .forEach(System.out::println);




        List<Person> persons = List.of(
                new Person("Shamim", "25", "shamim@gmail.com"),
                new Person("Habib", "12", "Habib@gmail.com"),
                new Person("Anis", "26", "Anis@gmail.com"),
                new Person("Girish", "21", "Girish@gmail.com")

        );

        List<PersonDTO> personDTOS = persons.stream()
                .map(person -> {
                    PersonDTO personDTO = new PersonDTO(person.getName(), person.getAge(), person.getEmail());
                    return personDTO;
                })
                .filter(personDTO -> Integer.parseInt(personDTO.getAge()) > 17)
                .collect(Collectors.toList());
        personDTOS.forEach(System.out::println);
    }
}
