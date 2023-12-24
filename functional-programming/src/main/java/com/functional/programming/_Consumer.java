package com.functional.programming;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer customer = new Customer("Shamim", "01611404246");
        getCustomerInfo.accept(customer);
        customer = new Customer("Ahsan Habib", "01535707889");
        getCustomerInfo2.accept(customer, false);
    }

    static BiConsumer<Customer, Boolean> getCustomerInfo2 =
            (customer, aBoolean) ->
                    System.out.println(
                            "\nCustomer name is: "+customer.customerName +
                                "\nContact Number is: " +
                                    (aBoolean == true ?  customer.customerNumber : "01xxxxxxxxx")

                    );

    static Consumer<Customer> getCustomerInfo =
            customer ->
                    System.out.println(
                        "\nCustomer name is: "+customer.customerName +
                            "\nContact number is: "+customer.customerNumber
                    );
    static class Customer {
        private String customerName;
        private String customerNumber;

        public Customer(String customerName, String customerNumber) {
            this.customerName = customerName;
            this.customerNumber = customerNumber;
        }
        public Customer(){}
    }
}
