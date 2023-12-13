package work;

import java.util.List;
import java.util.stream.Collectors;

public class Methods {
    public static void main(String[] args) {
        // filter(predicate ---> boolean valued function)
        List <String> names = List.of("Amin", "Akash", "Shamim", "Shuvo");
        List <String> newNames = names.stream().filter(e->e.startsWith("Ak")).collect(Collectors.toList());
        System.out.println(newNames);

        // Map
        List <Integer> num = List.of(1,2,12,13,3,4,5);
        num = num.stream().map(i->i*i).collect(Collectors.toList());

        num.stream().forEach(
                e->{
                    System.out.print(e+" ");
                }
        );
        System.out.println("\n");

        num.stream().sorted().forEach(System.out::println); // Ascending Order

        System.out.println("\n");

        num.stream()
                .sorted((x, y) -> y.compareTo(x))
                    .forEach(e->{
                        System.out.print(e + " ");
                    }); /// Descending Order

        int minimumElement = num
                .stream()
                    .min((x, y) -> x.compareTo(y)).get();

        Integer maximumElement = num
                .stream()
                        .max((x, y) -> x.compareTo(y)).get();

        System.out.println("\nMinimum Element is: "+minimumElement);
        System.out.println("\nMaximum Element is: "+maximumElement);
    }
}
