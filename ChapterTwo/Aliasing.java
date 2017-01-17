import java.util.*;


public class Aliasing {
    public static void main(String[] args) {
        Class a = new Class();
        a.x = 12;
        System.out.println("a.x = " + a.x);

        Class b = new Class();
        b.x = 24;
        System.out.println("b.x = " + b.x);

        b = a;
        System.out.println("b.x = " + b.x);
    }
}

class Class {
    float x;
}
