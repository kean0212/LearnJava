import java.util.List;
import java.util.Arrays;

public class StringArrayContainer {
    private static final int DEFAULT_SIZE = 100;
    private String[] stringArray = new String[DEFAULT_SIZE];
    private int count = 0;

    public void add(String string) {
        int length = stringArray.length;
        if (count >= length) {
            // resize the array and copy the values to the new array
            String[] newStringArray = new String[length * 2];
            System.arraycopy(stringArray, 0, newStringArray, 0, length);
            stringArray = newStringArray;
        }
        stringArray[count++] = string;
    }

    public String get(int index) {
        return stringArray[index];
    }

    public int size() {
        return count;
    }
}