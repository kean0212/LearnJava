import java.util.regex.Pattern;
import java.util.regex.Matcher;

class ReplaceVowelsInSplittingKnights {
    private final static String KNIGHTS = "Then, when you have found the shrubbery, you must" +
            "cut down the mightiest tree in the forest... with... a herring!";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[aeiou]");
        Matcher matcher = pattern.matcher(KNIGHTS);
        String replacedKnights = matcher.replaceAll("_");
        System.out.println(replacedKnights);
    }
}
