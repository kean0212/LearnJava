import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class CountedString {
    private static List<String> created = new ArrayList<String>();
    private String string;
    private int id = 0;
    private char aChar;

    public CountedString(String string, char aChar) {
        this.string = string;
        this.aChar = aChar;
        created.add(string + aChar);
        for (String createdString : created) {
            if (createdString.equals(string + aChar)) {
                id++;
            }
        }
    }

    public String toString() {
        return "String: " + string + " id: " + id + " char: " + aChar + " hashCode(): " + hashCode();
    }

    /**
     * By removing the 'id' combination, the searching still works because of the `equals` method.
     * All instances of CountedString are stored in the same bucket (collisions), which results in deficiency in searching.
     * A linear search is applied for searching.
     */
    public int hashCode() {
        int result = 17;
        result = 37 * result + string.hashCode();
        result = 37 * result + id;
        result = 37 * result + (int) aChar;
        return result;
    }

    public boolean equals(Object object) {
        return object instanceof CountedString &&
                string.equals(((CountedString) object).string) &&
                id == ((CountedString) object).id &&
                aChar == ((CountedString) object).aChar;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<CountedString, Integer>();
        CountedString[] countedStrings = new CountedString[5];
        for (int i = 0; i < countedStrings.length; ++i) {
            countedStrings[i] = new CountedString("hi", 'a');
            map.put(countedStrings[i], i);
        }
        Util.println(map);
        for (CountedString countedString : countedStrings) {
            Util.println("Looking up " + countedString);
            Util.println(map.get(countedString));
        }
    }
}