public class TwoTuple<A extends Comparable, B extends Comparable> implements Comparable {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public int hashCode() {
        int result = 17;
        result = 37 * result + first.hashCode();
        result = 37 * result + second.hashCode();
        return result;
    }

    public boolean equals(Object other) {
        return other instanceof TwoTuple &&
                (first != null && first.equals(((TwoTuple) other).first)) &&
                (second != null && second.equals(((TwoTuple) other).second));
    }

    public int compareTo(Object other) {
        int resultCompareFirst = first.compareTo(((TwoTuple) other).first);
        int resultCompareSecond = second.compareTo(((TwoTuple) other).second);
        if (resultCompareFirst != 0) {
            return resultCompareFirst;
        }
        return resultCompareSecond;
    }
}
