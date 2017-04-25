class FiveTuple<A, B, C, D, E> {
    public final A first;
    public final B second;
    public final C third;
    public final D fourth;
    public final E fifth;

    public FiveTuple(A first, B second, C third, D fourth, E fifth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    public String toString() {
        return "FiveTuple<" + first + "," + second + "," + third + "," + fourth + "," + fifth + ">";
    }
}

public class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> {
    public final F sixth;

    public SixTuple(A first, B second, C third, D fourth, E fifth, F sixth) {
        super(first, second, third, fourth, fifth);
        this.sixth = sixth;
    }

    public String toString() {
        return "SixTuple<" + first + "," + second + "," + third + "," + fourth + "," + fifth + "," + sixth + ">";
    }

    public static void main(String[] args) {
        SixTuple<String, Integer, Character, Boolean, Float, Double> sixTuple = new SixTuple<String, Integer, Character, Boolean, Float, Double>
                ("hello", 3, 'a', false, 3.0f, 4.21);
        System.out.println(sixTuple);
    }

}