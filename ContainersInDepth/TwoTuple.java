public class TwoTuple<A, B> implements Comparable {
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

    public boolean equals(Object object) {
        return object instanceof TwoTuple &&
                (first != null && first.equals(((TwoTuple) object).first)) &&
                (second != null && second.equals(((TwoTuple) object).second));
    }

    public int compareTo(TwoTuple other) {

    }
}
