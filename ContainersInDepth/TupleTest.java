import java.util.HashSet;

public class TupleTest {
    public static void main(String[] args) {
        HashSet<TwoTuple<Integer, String>> twoTupleHashSet = new HashSet();
        twoTupleHashSet.add(new TwoTuple(0, "hello"));
        twoTupleHashSet.add(new TwoTuple(0, "world"));
        twoTupleHashSet.add(new TwoTuple(1, "hello"));
        twoTupleHashSet.add(new TwoTuple(1, "world"));
        Util.println(twoTupleHashSet);

        HashSet<ThreeTuple<Integer, String, Character>> threeTupleHashSet = new HashSet();
        threeTupleHashSet.add(new ThreeTuple(0, "hello", 'a'));
        threeTupleHashSet.add(new ThreeTuple(0, "hello", 'b'));
        threeTupleHashSet.add(new ThreeTuple(0, "hello", 'c'));
        threeTupleHashSet.add(new ThreeTuple(0, "world", 'a'));
        threeTupleHashSet.add(new ThreeTuple(0, "world", 'b'));
        threeTupleHashSet.add(new ThreeTuple(0, "world", 'c'));
        threeTupleHashSet.add(new ThreeTuple(1, "hello", 'a'));
        threeTupleHashSet.add(new ThreeTuple(1, "hello", 'b'));
        threeTupleHashSet.add(new ThreeTuple(1, "hello", 'c'));
        threeTupleHashSet.add(new ThreeTuple(1, "world", 'a'));
        threeTupleHashSet.add(new ThreeTuple(1, "world", 'b'));
        threeTupleHashSet.add(new ThreeTuple(1, "world", 'c'));
        Util.println(threeTupleHashSet);
    }
}