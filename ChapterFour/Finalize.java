import java.util.*;

public class Finalize {
    public static void main(String[] args) {
        new Test();
        System.gc();
        System.runFinalization();
    }
}

class Test {
    protected void finalize() {
        System.out.println("finalize");
//        super.finalize();
    }
}

//import java.util.*;
//
//class Book {
//    boolean checkedOut = false;
//
//    Book(boolean checkOut) {
//        checkedOut = checkOut;
//    }
//
//    void checkIn() {
//        checkedOut = false;
//    }
//
//    protected void finalize() {
//        if (checkedOut)
//            System.out.println("Error: checked out");
//        // Normally, you’ll also do this:
//        // super.finalize(); // Call the base-class version
//    }
//}
//
//public class Finalize {
//    public static void main(String[] args) {
//        Book novel = new Book(true);
//        // Proper cleanup:
//        novel.checkIn();
//        // Drop the reference, forget to clean up:
//        new Book(true);
//        // Force garbage collection & finalization:
//        System.gc();
//    }
//}
