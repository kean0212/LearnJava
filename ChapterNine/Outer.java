import java.util.*;

public class Outer {
    static class Inner {
        Inner() {
            System.out.println("Inner()");
        }
    }

    Outer() {
        System.out.println("Outer()");
    }

    Inner createInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.createInner(); // if Inner is non-static, it needs an instance of Outer to create one
        Inner inner1 = new Inner(); // if Inner is static, we can just use the constructor
    }
}