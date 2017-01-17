interface First {
    void first();

    void second();
}

interface Second {
    void third();

    void fourth();
}

interface Third {
    void fifth();

    void sixth();
}

interface Fourth extends First, Second, Third {
    void seventh();
}

class Concrete {
    void eighth() {
    }
}

abstract class Abstract {
    abstract void nineth();
}

public class ExerciseFourteen extends Abstract implements Fourth {
    public void first() {
    }

    public void second() {
    }

    public void third() {
    }

    public void fourth() {
    }

    public void fifth() {
    }

    public void sixth() {
    }

    public void seventh() {
    }

    public void nineth() {
    }

    public static void t(First first) {
        first.first();
    }

    public static void u(Second second) {
        second.third();
    }

    public static void v(Third third) {
        third.fifth();
    }

    public static void w(Fourth fourth) {
        fourth.seventh();
    }

    static void x(Abstract test) {
        test.nineth();
    }

    public static void main(String[] args) {
        ExerciseFourteen test = new ExerciseFourteen();
        t(test);
        u(test);
        v(test);
        w(test);
        x(test);
    }
}
