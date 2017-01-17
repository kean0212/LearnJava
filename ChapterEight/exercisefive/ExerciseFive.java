//package theotherpackage;

import onepackage.Interface;

class Test implements Interface {
    public void print() {
        System.out.println("print");
    }

    public void what() {
        System.out.println("what");
    }

    public int test() {
        return 1;
    }
}

public class ExerciseFive {
    public static void main(String[] args) {
        Test test = new Test();
        test.print();
        test.what();
        test.test();
    }
}
