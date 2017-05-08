import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* Optional methods in List but not in Collection
add(index, e)
addAll(index, collection)
remove(index)
set(index, e)
*/

public class Unsupported {
    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void test(String listType, List<String> testedList) {
        printMessage(listType);
        try {
            testedList.add(0, "hello");
        } catch (Exception e) {
            printMessage("add(index, element): " + e);
        }
        try {
            testedList.addAll(0, Arrays.asList("hello", "world"));
        } catch (Exception e) {
            printMessage("addAll(index, collection): " + e);
        }
        try {
            testedList.remove(0);
        } catch (Exception e) {
            printMessage("remove(index): " + e);
        }
        try {
            testedList.set(0, "me");
        } catch (Exception e) {
            printMessage("set(index, element): " + e);
        }
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" "));
        test("stringList", stringList);
        List<String> stringArrayList = new ArrayList<String>(stringList);
        test("stringArrayList", stringArrayList);
        List<String> unmodifiableList = Collections.unmodifiableList(stringArrayList);
        test("unmodifiableList", unmodifiableList);
    }
}