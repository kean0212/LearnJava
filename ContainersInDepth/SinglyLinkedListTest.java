import java.util.Arrays;
import java.util.List;

public class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList();
        List<String> input = Arrays.asList("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" "));
        SinglyLinkedList.SinglyListIterator iterator = singlyLinkedList.iterator();
        for (String string : input) {
            iterator.add(string);
        }
        Util.print(singlyLinkedList);

        iterator = singlyLinkedList.iterator();
        iterator.remove();
        Util.print(singlyLinkedList);
    }
}