class Outer {
    static class Inner {
        static int counter = 0;
        int id = counter++;

        public String toString() {
            return super.toString() + ": " + id;
        }
    }
}

public class StaticNestedClass {
    public static void main(String[] args) {
        Outer outerOne = new Outer();
        System.out.println("outerOne: " + new Outer.Inner());
        Outer outerTwo = new Outer();
        System.out.println("outerTwo: " + new Outer.Inner());

        System.out.println(Outer.Inner.counter);
    }
}