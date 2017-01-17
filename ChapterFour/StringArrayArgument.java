import java.util.*;

public class StringArrayArgument {
    static void print(String... strings) {
        for (int i = 0; i < strings.length; ++i) {
            System.out.println(strings[i]);
        }
    }

    public static void main(String[] args) {
        print("a", "b", "c", "d");
        print(new String[5]);
    }
}