import java.util.*;

abstract class Dad {}

class Child extends Dad {
    void print() {
        System.out.println("Child");
    }
}

abstract class SecondDad {
    abstract void print();
}

class SecondChild extends SecondDad {
    void print() {
        System.out.println("SecondChild");
    }
}

public class ExerciseFour {
    static void print(Dad dad) {
        ((Child) dad).print();
    }

    static void print(SecondDad secondDad) {
        secondDad.print();;
    }

    public static void main(String[] args) {
        Child child = new Child();
        print(child);

        SecondChild secondChild = new SecondChild();
        print(secondChild);
    }
}