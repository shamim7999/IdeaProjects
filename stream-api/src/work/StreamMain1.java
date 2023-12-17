package work;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain1 {
    public static void main(String[] args) {
        // Create a List and Filter all even numbers from List
        List<Integer> list1 = List.of(2, 4, 6, 8, 1, 3, 5, 7);

        Stream<Integer> stream = list1.stream();
        List<Integer> evenList = stream.filter(val->val%2 == 0).collect(Collectors.toList());
        System.out.println(evenList);

        // Odd elements
        List <Integer> oddList = list1.stream().filter(val->(val&1) == 1).collect(Collectors.toList());
        System.out.println(oddList);
    }
}
