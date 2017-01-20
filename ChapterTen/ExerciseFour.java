import java.util.*;

class FavoriteFilm {
    private static final String[] FILMS = {"Snow White", "Star Wars", "2012"};
    private int index;

    public String next() {
        return FILMS[index++ % 3];
    }
}

public class ExerciseFour {
    static void fill(Collection<String> collection) {
        FavoriteFilm favoriteFilm = new FavoriteFilm();
        for (int i = 0; i < 5; ++i) {
            collection.add(favoriteFilm.next());
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        fill(arrayList);
        System.out.println(arrayList); // 0, 1, 2, 0, 1

        LinkedList<String> linkedList = new LinkedList<String>();
        fill(linkedList);
        System.out.println(linkedList); // 0, 1, 2, 0, 1

        HashSet<String> hashSet = new HashSet<String>();
        fill(hashSet);
        System.out.println(hashSet); // disordered

        TreeSet<String> treeSet = new TreeSet<String>();
        fill(treeSet);
        System.out.println(treeSet); // Snow White, Star Wars, 2012

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        fill(linkedHashSet);
        System.out.println(linkedHashSet); // 0, 1, 2
    }
}