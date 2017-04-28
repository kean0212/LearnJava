import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;

enum Color{
        RED,GREEN,YELLOW,PURPLE,BLACK,WHITE,ORANGE
        }

public class SetsTest {
    private static void fillSet(Set<Color> colorSet) {
        colorSet.add(Color.RED);
        colorSet.add(Color.YELLOW);
        colorSet.add(Color.BLACK);
        colorSet.add(Color.WHITE);
    }

    private static <T> void mathematicalRelationResults(String setOneName, String setTwoName,
                                                        Set<T> setOne, Set<T> setTwo) {
        System.out.println(setOneName + " or " + setTwoName + ": " + Sets.union(setOne, setTwo));
        System.out.println(setOneName + " and " + setTwoName + ": " + Sets.intersection(setOne, setTwo));
        System.out.println(setOneName + " diff " + setTwoName + ": " + Sets.difference(setOne, setTwo));
        System.out.println(setOneName + " complement " + setTwoName + ": " + Sets.complement(setOne, setTwo));
    }

    public static void main(String[] args) {
        Set<Color> colorSetOne = new HashSet<Color>();
        fillSet(colorSetOne);
        colorSetOne.add(Color.GREEN);

        Set<Color> colorSetTwo = new HashSet<Color>();
        fillSet(colorSetTwo);
        colorSetTwo.add(Color.PURPLE);


        Set<Color> colorSetThree = EnumSet.copyOf(colorSetOne);
        fillSet(colorSetThree);
        colorSetThree.add(Color.ORANGE);

        System.out.println(colorSetOne);
        System.out.println(colorSetTwo);
        mathematicalRelationResults("colorSetOne", "colorSetTwo", colorSetOne, colorSetTwo);
        System.out.println("");

        System.out.println(colorSetThree);
        System.out.println(colorSetTwo);
        mathematicalRelationResults("colorSetThree", "colorSetTwo", colorSetThree, colorSetTwo);
    }
}