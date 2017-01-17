import java.util.*;

class Number {
    float x;
}

public class AliasingMethodCalls {
    static void f(Number number) {
        number.x = 13;
    }

    public static void main(String[] args) {
        Number a = new Number();
        System.out.println("a.x = " + a.x);

        f(a);
        System.out.println("a.x = " + a.x);
    }
}