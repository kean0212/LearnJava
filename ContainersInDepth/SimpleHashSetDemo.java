import java.util.List;

public class SimpleHashSetDemo {
    public static void main(String[] args) {
        List<String> countryNames = Countries.names(10);
        Util.println("countryNames: " + countryNames);

        SimpleHashSet<String> simpleHashSet = new SimpleHashSet<String>();
        Util.println("simpleHashSet: " + simpleHashSet);

        Util.println("simpleHashSet.addAll(countryNames): " + simpleHashSet.addAll(countryNames));
        Util.println("simpleHashSet: " + simpleHashSet);
    }
}