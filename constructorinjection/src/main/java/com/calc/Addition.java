package com.calc;

public class Addition {
    private int a, b;
    public Addition(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("Addition Constructor int : int");
    }
    public Addition(double a, double b) {
        this.a = (int)a;
        this.b = (int)b;
        System.out.println("Addition Constructor double : double");
    }

    public Addition(String a, String b) {
        this.a = Integer.parseInt(a);
        this.b = Integer.parseInt(b);
        System.out.println("Addition Constructor String : String");
    }

    public void doSum() {
        System.out.println("Sum is = "+(this.a + this.b));
    }

    @Override
    public String toString() {
        return "Addition{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public void init() {
        System.out.println("Init() called!!");
    }

    public void destroy() {
        System.out.println("Destroy() Called!!!");
    }

}
