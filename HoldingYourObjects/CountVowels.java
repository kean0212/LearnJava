import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class CountVowels {
    private static Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    static int countVowelsInWord(String word) {
        int count = 0;
        for (char character : word.toCharArray()) {
            if (vowels.contains(character)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countVowelsInWord(args[0]));
    }
}