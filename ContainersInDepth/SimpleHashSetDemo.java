import java.util.List;

public class SimpleHashSetDemo {
    public static void main(String[] args) {
        List<String> countryNames = Countries.names(10);
        Util.println("countryNames: " + countryNames);

        SimpleHashSet<String> simpleHashSet = new SimpleHashSet<String>();
        Util.println("simpleHashSet: " + simpleHashSet);

        Util.println("simpleHashSet.addAll(countryNames): " + simpleHashSet.addAll(countryNames));
        Util.println("simpleHashSet: " + simpleHashSet);

        simpleHashSet.clear();
        Util.println("simpleHashSet.clear(): " + simpleHashSet);

        simpleHashSet.addAll(countryNames);
        String firstCountryName = Countries.names(1).get(0);
        Util.println("simpleHashSet.contains(firstCountryName): " + simpleHashSet.contains(firstCountryName));

        List<String> subCountryNames = Countries.names(5);
        Util.println("simpleHashSet.containsAll(subCountryNames): " + simpleHashSet.containsAll(subCountryNames));
    }
}