package com.functional.programming;

import java.util.function.Function;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isPhoneNumbervalid.test("01797568245"));
        System.out.println(isPhoneNumbervalid.test("02457854566"));

        System.out.println(
                "\n"+
                containsThree.and(isPhoneNumbervalid).test("01797568245") + "\n" +
                        containsThree.or(isPhoneNumbervalid).test("031454")
        );
    }
    static Predicate<String> isPhoneNumbervalid =
            number ->
                    number.startsWith("01") && number.length() == 11;
    static Predicate<String> containsThree =
            number ->
                    number.contains("3");
}
