import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class NumberOfVowels {
    private static final HashSet<Character> VOWELS = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    private static HashMap<Character, Integer> countVowels(String word) {
        HashMap<Character, Integer> numberOfVowels = new HashMap<Character, Integer>();
        for (Character character : word.toCharArray()) {
            if (VOWELS.contains(character)) {
                Integer count = numberOfVowels.get(character);
                numberOfVowels.put(character, count == null ? 1 : count + 1);
            }
        }
        return numberOfVowels;
    }

    public static void main(String[] args) {
        System.out.println(countVowels(args[0]));
    }
}