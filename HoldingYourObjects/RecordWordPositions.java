import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.nio.charset.Charset;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class RecordWordPositions {
    public static void main(String[] args) {
        String fileName = args[0];

        try {
            // Read the file
            InputStream inputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Read word by word and record the positions
            int position = 0;
            Map<String, ArrayList<Integer>> wordsPositions = new HashMap<String, ArrayList<Integer>>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                for (String word : line.split(" ")) {
                    ArrayList<Integer> wordPositions = wordsPositions.get(word);
                    if (wordPositions == null) {
                        wordPositions = new ArrayList<Integer>();
                        wordPositions.add(position++);
                        wordsPositions.put(word, wordPositions);
                    } else {
                        wordPositions.add(position++);
                    }
                }
            }

            System.out.println(wordsPositions);
        } catch (Exception e) {
            System.out.println("Failed to record the words' positions in file: " + fileName);
        }
    }
}