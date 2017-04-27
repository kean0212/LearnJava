public class Tuple {
    public static <A, B> TwoTuple<A, B> tuple(A first, B second) {
        return new TwoTuple<A, B>(first, second);
    }

    public static <A, B, C> ThreeTuple<A, B, C> tuple(A first, B second, C third) {
        return new ThreeTuple<A, B, C>(first, second, third);
    }

    public static <A, B, C, D> FourTuple<A, B, C, D> tuple(A first, B second, C third, D fourth) {
        return new FourTuple<A, B, C, D>(first, second, third, fourth);
    }

    public static <A, B, C, D, E> FiveTuple<A, B, C, D, E> tuple(A first, B second, C third, D fourth, E fifth) {
        return new FiveTuple<A, B, C, D, E>(first, second, third, fourth, fifth);
    }

    public static <A, B, C, D, E, F> SixTuple<A, B, C, D, E, F> tuple(A first, B second, C third, D fourth, E fifth, F sixth) {
        return new SixTuple<A, B, C, D, E, F>(first, second, third, fourth, fifth, sixth);
    }
}

class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return this.getClass() + ": " + first + ": " + second;
    }
}

class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }

    public String toString() {
        return super.toString() + ", " + third;
    }
}

class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D fourth;

    public FourTuple(A first, B second, C third, D fourth) {
        super(first, second, third);
        this.fourth = fourth;
    }

    public String toString() {
        return super.toString() + ", " + fourth;
    }
}

class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
    public final E fifth;

    public FiveTuple(A first, B second, C third, D fourth, E fifth) {
        super(first, second, third, fourth);
        this.fifth = fifth;
    }

    public String toString() {
        return super.toString() + ", " + fifth;
    }
}

class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> {
    public final F sixth;

    public SixTuple(A first, B second, C third, D fourth, E fifth, F sixth) {
        super(first, second, third, fourth, fifth);
        this.sixth = sixth;
    }

    public String toString() {
        return super.toString() + ", " + sixth;
    }
}