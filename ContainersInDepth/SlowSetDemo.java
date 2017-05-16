import java.util.List;

public class SlowSetDemo {
    public static void main(String[] args) {
        List<String> countryNames = Countries.names(10);
        Util.println("countryNames: " + countryNames);

        SlowSet<String> slowSet = new SlowSet<String>();
        slowSet.addAll(countryNames);
        Util.println("slowSet: " + slowSet);

        Util.println("slowSet.contains(\"ALGERIA\"): " + slowSet.contains("ALGERIA"));
        Util.println("slowSet.containsAll(countryNames): " + slowSet.containsAll(countryNames));

        Util.println("slowSet.add(\"ALGERIA\"): " + slowSet.add("ALGERIA"));
        Util.println("slowSet: " + slowSet);

        Util.println("slowSet.remove(\"ALGERIA\"): " + slowSet.remove("ALGERIA"));
        Util.println("slowSet: " + slowSet);

        slowSet.removeAll(countryNames);
        Util.println("slowSet: " + slowSet);
    }
}