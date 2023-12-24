package com.functional.programming;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.functional.programming.CustomerRegistrationValidator.*;

public class App 
{
    public static void main( String[] args )
    {
        Customer customer = new Customer(
            "Shamim",
                "01611404246",
                "sarker.shamim1998@gmail.com",
                LocalDate.of(1998, 11, 2)
        );
        ValidationResult result = isEmailValid()
                .andd(isAgeValid())
                        .andd(isPhoneNumberValid())
                                .apply(customer);
        System.out.println("Checking : "+result+"\n\n");

        List<Customer> customers = new ArrayList<>();

        customers.add(customer);
        customers.add(
            new Customer("Hasan", "01611404246", "hasan.shamim1998@gmail.com", LocalDate.of(2015, 11, 2))
        );
        customers.add(
                new Customer("Habib", "01611404146", "habib.shamim1998@gmail.com", LocalDate.of(2000, 11, 2))
        );
        //System.out.println(new CustomerValidatorService().isValid(customer));

        CustomerValidatorService customerValidatorService = new CustomerValidatorService();

        List <Customer> validCustomers = customers.stream()
                .filter((Customer c) -> customerValidatorService.isValid(c))
                .collect(Collectors.toList());
        validCustomers.forEach(System.out::println);


        int sum = IntStream.rangeClosed(0, 10)
                .filter(i -> isPerfectSquare(i))
                .sum();
        System.out.println(sum);

        List<Integer> nums = IntStream
                .rangeClosed(0, 100)
                .boxed()
                .collect(Collectors.toList());
        int sum2 = nums.stream()
                .filter(i -> i%3 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum2);
    }

    private static boolean isPerfectSquare(int i) {
        int sq = (int) Math.sqrt(i);
        return sq*sq == i;
    }
}
