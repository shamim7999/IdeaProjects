public class Main {
    public static void main(String[] args) {
        String nums = "abcdefghhijklmz";
        byte [] data = nums.getBytes();
        StringBuilder result = new StringBuilder();
        for(byte b : data) {
            System.out.println(b);
            result.append(String.format("%X ", b));
        }
        System.out.println(result.toString());
        String byteToStr = new String(data);
        System.out.println(byteToStr);
    }
}