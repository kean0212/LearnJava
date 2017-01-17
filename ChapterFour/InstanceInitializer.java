import java.util.*;

class Mug {
    Mug(int marker) {
        System.out.println("Mug(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Mugs {
    Mug mug1;
    Mug mug2;

    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        System.out.println("Mug(1) and Mug(2) are initialized");
    }

    Mugs() {
        System.out.println("Mugs()");
    }
}

public class InstanceInitializer {
    public static void main(String[] args) {
        new Mugs();
        System.out.println("new Mugs() completed");
        new Mugs();
        System.out.println("new Mugs() completed");
    }
}