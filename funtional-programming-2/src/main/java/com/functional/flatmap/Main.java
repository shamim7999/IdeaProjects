package com.functional.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<City> cities = List.of(
                new City("Dhaka", 100),
                new City("Rajshahi", 200),
                new City("Chittagong", 300),
                new City("Barisal", 400),
                new City("Narayanganj", 500),
                new City("Cumilla", 600),
                new City("Rangpur", 700),
                new City("Sylhet", 800)
        );

        List<State> states = List.of(
            new State("texas", cities)
        );

        List<Integer> pops = states.stream()
                .flatMap(state -> state.getCities().stream())
                .map(city -> city.getPopulation())
                .filter(population -> population > 100)
                .collect(Collectors.toList());

        System.out.println("Population greater than 100: "+pops);

        Consumer<String> printStrings = string -> System.out.println(string);

        List<String> nums = List.of("10", "20", "30", "40 ", "", " 90", "50", "0", "50");

        List<Integer> ints = nums.stream()
                .<Integer>mapMulti((str, con) -> {
                    try{
                        con.accept(Integer.parseInt(str));
                    } catch (NumberFormatException e) {

                    }
                })
                .distinct()
                .sorted((x, y)-> y.compareTo(x))
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(ints);

    }
}
