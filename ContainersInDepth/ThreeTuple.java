public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }

    public int hashCode() {

    }

    public boolean equals() {

    }

    public int compareTo(TwoTuple other) {

    }
}
