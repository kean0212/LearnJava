public class ThreeTuple<A extends Comparable, B extends Comparable, C extends Comparable>
        extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }

    public int hashCode() {
        return 37 * super.hashCode() + third.hashCode();
    }

    public boolean equals(Object other) {
        return other instanceof ThreeTuple &&
                first.equals(((ThreeTuple) other).first) &&
                second.equals(((ThreeTuple) other).second) &&
                third.equals(((ThreeTuple) other).third);
    }

    public int compareTo(Object other) {
        if (super.compareTo(other) != 0) {
            return super.compareTo(other);
        }
        return third.compareTo(((ThreeTuple) other).third);
    }
}
