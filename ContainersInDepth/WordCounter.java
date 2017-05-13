import java.util.Map;
import java.util.HashMap;

public class WordCounter {
    public static void main(String[] args) {
        String fileName = args[0];
        String fileContent = TextFile.read(fileName);
        String[] words = fileContent.split("[\\p{Punct}\\s]+");

        Map<String, Integer> associativeArray = new HashMap(words.length);
        for (String key: words) {
            Integer count = associativeArray.get(key);
            if (count == null) {
                count = 0;
            }
            associativeArray.put(key, ++count);
        }
        Util.println(associativeArray);
    }
}