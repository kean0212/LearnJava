import java.util.*;

public class StaticField {
    public static void main(String[] args) {
        Class a = new Class();
        a.x = 12;

        Class b = new Class();
        System.out.println(b.x);

        b.x = 24;
        System.out.println(a.x);

        Class c = new Class();
        System.out.println(c.x);

        c.x = 35;
        System.out.println(a.x);
        System.out.println(b.x);
    }
}

class Class {
    public static int x;
}