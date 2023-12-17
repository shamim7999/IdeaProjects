import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Box <T> {
    T container;
    public Box(T container) {
        //System.out.println(container.getClass().getName());
        this.container = container;

        if(container instanceof String) {
            System.out.println("This is an Object of String Class");
        } else if(container instanceof Integer) {
            System.out.println("This is an Object of Integer Class");
        }

    }
    public Box(){}
    public void setValue(T container) {
        this.container = container;
    }
    public T getValue() {
        //System.out.println(container.getClass().getName());
        return this.container;
    }

//    public List<T> sort(List<T> unsortedList) {
//        Collections.sort(unsortedList);
//        return unsortedList;
//    }

}
