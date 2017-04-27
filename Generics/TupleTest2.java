public class TupleTest2 {
    static TwoTuple<String, Integer> f() {
        return Tuple.tuple("hi", 31);
    }

    static TwoTuple f2() {
        return Tuple.tuple("hi", 31);
    }

    static ThreeTuple<String, Character, Integer> f3() {
        return Tuple.tuple("hi", 'h', 31);
    }

    static FourTuple<String, Character, Integer, Float> f4() {
        return Tuple.tuple("hi", 'h', 3, 4.0f);
    }

    static FiveTuple<String, Character, Integer, Float, Double> f5() {
        return Tuple.tuple("hi", 'h', 3, 4.0f, 3.14);
    }

    static SixTuple<String, Character, Integer, Float, Double, Boolean> f6() {
        return Tuple.tuple("hi", 'h', 3, 4.0f, 3.14, true);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> twoTuple = f();
        System.out.println(twoTuple);
        System.out.println(f2());
        System.out.println(f3());
        System.out.println(f4());
        System.out.println(f5());
        System.out.println(f6());

        // Test for exercise 15 -- this gives "unchecked or unsafe operations"
//        TwoTuple<String, Integer> anotherTwoTuple = f2();
//        System.out.println(anotherTwoTuple);
    }
}