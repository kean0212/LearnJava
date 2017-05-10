import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<String> stringTreeSet = new TreeSet<String>();
        for (int i = 0; i < 10; ++i) {
            stringTreeSet.add((new RandomGenerator.String(5)).next());
        }
        Util.print(stringTreeSet);
    }
}