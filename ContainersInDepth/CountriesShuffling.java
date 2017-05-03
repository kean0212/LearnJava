import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class CountriesShuffling {
    private static void printShuffledCountryNames(List<String> countryNames, int times) {
        for (int i = 0; i < times; ++i) {
            Collections.shuffle(countryNames);
            System.out.println(i + "st shuffle: " + countryNames);
        }
    }

    public static void main(String[] args) {
        List<String> countryNames= new ArrayList(Countries.names(10));
        Collections.sort(countryNames);
        System.out.println("Sorted country names: " + countryNames);
        printShuffledCountryNames(countryNames, 5);

        countryNames = new LinkedList(Countries.names(10));
        Collections.sort(countryNames);
        System.out.println("Sorted country names: " + countryNames);
        printShuffledCountryNames(countryNames, 5);
    }
}