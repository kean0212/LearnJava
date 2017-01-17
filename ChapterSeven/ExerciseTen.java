import java.util.*;

class Base {
    void first() {
        System.out.println("base.first()");
        second();
    }

    void second() {
        System.out.println("base.second()");
    }
}

class Child extends Base {
    void second() {
        System.out.println("child.second()");
    }
}

public class ExerciseTen {
    public static void main(String[] args) {
        Base base = new Child();
        base.first(); // because of dynamic binding, this should output child.second()
    }
}