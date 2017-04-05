import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.nio.charset.Charset;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class RecordWordsPositions {
    public static Map<String, ArrayList<Integer>> record(String fileName) {
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

            return wordsPositions;
        } catch (Exception e) {
            System.out.println("Failed to record the words' positions in file: " + fileName);
            return null;
        }
    }
}

public class RecreateOrderOfWords {
    public static void main(String[] args) {
        String fileName = args[0];
        Map<String, ArrayList<Integer>> wordsPositions = RecordWordsPositions.record(fileName);

        int wordsCount = 0;
        Iterator<ArrayList<Integer>> iterator = wordsPositions.values().iterator();
        while(iterator.hasNext()) {
            wordsCount += iterator.next().size();
        }

        String[] wordsInOrder = new String[wordsCount];
        for (Map.Entry<String, ArrayList<Integer>> entry : wordsPositions.entrySet()) {
            String word = entry.getKey();
            for (Integer position : entry.getValue()) {
                wordsInOrder[position] = word;
            }
        }
        for (String word : wordsInOrder) {
            System.out.print(word + " ");
        }
        System.out.println("");
    }
}