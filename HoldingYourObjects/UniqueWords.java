import java.util.LinkedHashMap;
import java.util.Collections;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.nio.charset.Charset;

public class UniqueWords {
    public static void main(String[] args) {

        String fileName = args[0];
        try {
            // Read the file
            InputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Read word by word and calculate the count
            List<String> words = new ArrayList<String>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                words.addAll(Arrays.asList(line.split(" ")));
            }

            // Sort the stats by alphabetic and print it out
            Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
            Map<String, Integer> wordsCounts = new LinkedHashMap<String, Integer>();
            for (String word : words) {
                Integer wordCount = wordsCounts.get(word);
                wordsCounts.put(word, wordCount == null ? 1 : wordCount + 1);
            }
            System.out.println(wordsCounts);
        } catch (Exception e) {
            System.out.println("Failed to count the words in " + fileName);
        }
    }
}