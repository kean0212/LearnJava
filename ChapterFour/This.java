import java.util.*;

public class This {
    public static void main(String[] args) {
        new Test().first();
    }
}

class Test {
    void first() {
        second();
        this.second(); // shouldn't be used
    }

    void second() {
        System.out.println("second");
    }
}