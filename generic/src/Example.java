public class Example {
    public static void main(String[] args) {
        Box <Integer> box = new Box<>(12);
        System.out.println(box.getValue());
        Box <String> box2 = new Box<>("StringBuffer");
        System.out.println(box2.getValue());
        box2.setValue("12");
    }
}
