import java.util.List;
import java.util.ArrayList;

public class InfiniteRecursion {
    public String toString() {
        return "InfiniteRecursion: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> infiniteRecursionList = new ArrayList<InfiniteRecursion>();
        for (int i = 0; i < 10; ++i) {
            infiniteRecursionList.add(new InfiniteRecursion());
        }
        System.out.println(infiniteRecursionList.toString());
    }
}