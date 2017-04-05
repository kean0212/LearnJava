import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;

public class SortLinkedHashMapBasedOnKey {
    public static void main(String[] args) {
        // Construct the map first
        Map<String, Integer> weekdays = new LinkedHashMap<String, Integer>();
        weekdays.put("Monday", 1);
        weekdays.put("Tuesday", 2);
        weekdays.put("Wednesday", 3);
        weekdays.put("Thursday", 4);
        weekdays.put("Friday", 5);
        weekdays.put("Saturday", 6);
        weekdays.put("Sunday", 7);

        // Get the keys and sort the keys
        List<String> weekdaysWords = new ArrayList<String>();
        weekdaysWords.addAll(weekdays.keySet());
        Collections.sort(weekdaysWords);

        // Reinsert them back to the map
        Iterator<String> iterator = weekdaysWords.iterator();
        while (iterator.hasNext()) {
            String weekdayWord = iterator.next();
            int weekdayNumber = weekdays.get(weekdayWord);
            weekdays.remove(weekdayWord);
            weekdays.put(weekdayWord, weekdayNumber);
        }

        System.out.println(weekdays);
    }
}
