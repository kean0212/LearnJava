import java.util.*;

abstract class Base {
    abstract void print();
    Base() {
        System.out.println("Base");
        print();
    }
}

class Child extends Base {
    int i = 3;

    void print() {
        System.out.println("Child: " + i);
    }
}

public class ExerciseThree {
    public static void main(String[] args) {
        Child child = new Child(); // this should output Child: 0
        child.print(); // this should output Child: 3
    }
}
