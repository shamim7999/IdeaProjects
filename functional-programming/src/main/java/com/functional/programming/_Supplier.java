package com.functional.programming;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println("Connection Strings: ");
        getConnectionString.get().forEach(System.out::println);
    }

    static Supplier<List<String>> getConnectionString =
            () -> List.of(
                    "jdbc://localhost:5432/users",
                    "jdbc://localhost:5432/customers"
                  );
}
