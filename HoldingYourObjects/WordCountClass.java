import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class WordCount {
    String word;
    int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public boolean equals(WordCount another) {
        return word == another.word;
    }

    public String toString() {
        return "" + word + ": " + count;
    }
}

public class WordCountClass {
    public static void main(String[] args) {
        String fileName = args[0];
        try {
            // Read the file
            InputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Read and sort the words
            String line;
            List<String> words = new ArrayList<String>();
            while ((line = bufferedReader.readLine()) != null) {
                words.addAll(Arrays.asList(line.split(" ")));
            }
            Collections.sort(words, String.CASE_INSENSITIVE_ORDER);

            // Count the words and construct the counts of words
            Iterator<String> iterator = words.iterator();
            Set<WordCount> wordCounts = new HashSet<WordCount>();
            String previousWord = "";
            int count = 1;
            while (iterator.hasNext()) {
                String currentWord = iterator.next();
                if (!currentWord.equals(previousWord)) {
                    wordCounts.add(new WordCount(previousWord, count));
                    previousWord = currentWord;
                    count = 1;
                } else {
                    count++;
                }
            }
            wordCounts.remove(new WordCount("", 0));

            System.out.println(wordCounts);
        } catch (Exception e) {
            System.out.println("Failed to count the words in file " + fileName);
        }
    }
}