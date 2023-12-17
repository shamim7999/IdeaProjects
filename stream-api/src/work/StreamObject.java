package work;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamObject {
    public static void main(String[] args) {
        IntStream stream = Arrays.stream(new int[]{1,2,3,4,5});
        stream.forEach(e->{
            System.out.println(e);
        });
    }
}
