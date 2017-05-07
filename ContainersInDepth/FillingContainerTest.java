import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

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
    public static void main(String[] args) {
        // Test "fill" methods - empty list
        List<StringAddress> stringAddressList = new ArrayList<StringAddress>();
        Collections.fill(stringAddressList, new StringAddress("hello"));
        System.out.println("Empty stringAddressList: " + stringAddressList);

        // Test "ncopies" methods
        stringAddressList = Collections.nCopies(4, new StringAddress("world"));
        System.out.println("stringAddressList: " + stringAddressList);

        // Test "ncopies" methods - change of the object
        StringAddress stringAddress = new StringAddress("hello");
        stringAddressList = Collections.nCopies(4, stringAddress);
        System.out.println("stringAddressList before change: " + stringAddressList);
        stringAddress.address = "world";
        System.out.println("stringAddressList after change: " + stringAddressList);


        // Test "fill" methods - test if  if stringList is mutable
        stringAddressList = new ArrayList<StringAddress>(stringAddressList);
        Collections.fill(stringAddressList, new StringAddress("hello"));
        System.out.println("stringAddressList - is immutable: " + stringAddressList);

        // Test "fill" methods - all objects are the same reference
        stringAddress = new StringAddress("no change");
        Collections.fill(stringAddressList, stringAddress);
        System.out.println("stringAddressList before object changes: " + stringAddressList);
        stringAddress.address = "change";
        System.out.println("stringAddressList after object changes: " + stringAddressList);
    }
}