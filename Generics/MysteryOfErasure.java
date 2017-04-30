interface Testable {
    public void f();

    public void g();
}

class Test implements Testable {
    public void f() {
        System.out.println("Test.f()");
    }

    public void g() {
        System.out.println("Test.g()");
    }

    public void h() {
        System.out.println("Test.h()");
    }
}

public class MysteryOfErasure {
    private static <T extends Testable> void callTestableMethods(T test) {
        test.f();
        test.g();
    }

    public static void main(String[] args) {
        Test test = new Test();
        callTestableMethods(test);
    }
}