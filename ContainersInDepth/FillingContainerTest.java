import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

class StringAddress {
    public String address;

    public StringAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return address;
    }
}

public class FillingContainerTest {
    private static <T> void printCollection(String testCase, Collection<T> collection) {
        System.out.println(testCase + ": " + collection);
    }

    public static void main(String[] args) {
        // Test "fill" methods - empty list
        List<StringAddress> stringAddressList = new ArrayList<StringAddress>();
        Collections.fill(stringAddressList, new StringAddress("hello"));
        printCollection("Empty stringAddressList", stringAddressList);

        // Test "ncopies" methods
        stringAddressList = Collections.nCopies(4, new StringAddress("world"));
        printCollection("stringAddressList", stringAddressList);

        // Test "ncopies" methods - change of the object
        StringAddress stringAddress = new StringAddress("hello");
        stringAddressList = Collections.nCopies(4, stringAddress);
        printCollection("stringAddressList before change", stringAddressList);
        stringAddress.address = "world";
        printCollection("stringAddressList after change", stringAddressList);

        List<StringAddress> fromCollection = Collections.nCopies(4, new StringAddress("hello"));
        printCollection("fromCollection before change", fromCollection);
        fromCollection.get(0).address = "world";
        printCollection("fromCollection after change", fromCollection);

        // Test "fill" methods - test if  if stringList is mutable
        stringAddressList = new ArrayList<StringAddress>(stringAddressList);
        Collections.fill(stringAddressList, new StringAddress("hello"));
        printCollection("stringAddressList - is immutable", stringAddressList);

        // Test "fill" methods - all objects are the same reference
        stringAddress = new StringAddress("no change");
        Collections.fill(stringAddressList, stringAddress);
        printCollection("stringAddressList before object changes", stringAddressList);
        stringAddress.address = "change";
        printCollection("stringAddressList after object changes", stringAddressList);

        // Use constructor to fill "Collection" subtypes
        List<String> stringList = Arrays.asList("hello", "world");
        Set<String> stringSet = new HashSet<String>(stringList);
        printCollection("stringSet", stringSet);
        List<String> stringListTwo = new ArrayList<String>(stringList);
        printCollection("stringListTwo", stringListTwo);
        Queue<String> stringQueue = new LinkedList<String>(stringList);
        printCollection("stringQueue", stringQueue);

        // Test the "constructor" way to fill a container
        stringAddress.address = "no change";
        List<StringAddress> stringAddressList1 = new ArrayList<StringAddress>(stringAddressList);
        printCollection("stringAddressList before change", stringAddressList);
        printCollection("stringAddressList1 before change", stringAddressList1);
        stringAddress.address = "change";
        printCollection("stringAddressList after change", stringAddressList);
        printCollection("stringAddressList1 after change", stringAddressList1);

        // Test addAll function
        Collection<StringAddress> toCollection = new ArrayList<StringAddress>();
        toCollection.addAll(fromCollection);
        printCollection("toCollection", toCollection);
    }
}